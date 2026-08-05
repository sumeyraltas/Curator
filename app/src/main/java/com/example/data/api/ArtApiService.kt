package com.example.data.api

import com.example.data.model.Artwork
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

@JsonClass(generateAdapter = true)
data class ArticResponse(
    val data: List<ArticItem>,
    val config: ArticConfig? = null
)

@JsonClass(generateAdapter = true)
data class ArticSingleResponse(
    val data: ArticItem,
    val config: ArticConfig? = null
)

@JsonClass(generateAdapter = true)
data class ArticConfig(
    @Json(name = "iiif_url") val iiifUrl: String? = "https://www.artic.edu/iiif/2"
)

@JsonClass(generateAdapter = true)
data class ArticItem(
    val id: Long,
    val title: String?,
    @Json(name = "artist_display") val artistDisplay: String?,
    @Json(name = "date_display") val dateDisplay: String?,
    @Json(name = "medium_display") val mediumDisplay: String?,
    @Json(name = "place_of_origin") val placeOfOrigin: String?,
    val dimensions: String?,
    val description: String?,
    @Json(name = "image_id") val imageId: String?
)

interface ArtApiEndpoint {
    @GET("artworks")
    suspend fun getArtworks(
        @Query("limit") limit: Int = 20,
        @Query("fields") fields: String = "id,title,artist_display,date_display,medium_display,place_of_origin,dimensions,description,image_id"
    ): Response<ArticResponse>

    @GET("artworks/search")
    suspend fun searchArtworks(
        @Query("q") query: String,
        @Query("limit") limit: Int = 20,
        @Query("fields") fields: String = "id,title,artist_display,date_display,medium_display,place_of_origin,dimensions,description,image_id"
    ): Response<ArticResponse>

    @GET("artworks/{id}")
    suspend fun getArtworkById(
        @Path("id") id: Long,
        @Query("fields") fields: String = "id,title,artist_display,date_display,medium_display,place_of_origin,dimensions,description,image_id"
    ): Response<ArticSingleResponse>
}

class ApiService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.artic.edu/api/v1/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val api = retrofit.create(ArtApiEndpoint::class.java)

    suspend fun fetchArtworks(): Result<List<Artwork>> {
        return try {
            val response = api.getArtworks()
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()!!
                val iiifBase = body.config?.iiifUrl ?: "https://www.artic.edu/iiif/2"
                val mapped = body.data.mapNotNull { item -> mapToArtwork(item, iiifBase) }
                if (mapped.isNotEmpty()) {
                    Result.success(mapped)
                } else {
                    Result.success(CuratedArtData.curatedArtworks)
                }
            } else {
                Result.success(CuratedArtData.curatedArtworks)
            }
        } catch (e: Exception) {
            Result.success(CuratedArtData.curatedArtworks)
        }
    }

    suspend fun searchArtworks(query: String): Result<List<Artwork>> {
        if (query.isBlank()) return fetchArtworks()
        return try {
            val response = api.searchArtworks(query)
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()!!
                val iiifBase = body.config?.iiifUrl ?: "https://www.artic.edu/iiif/2"
                val mapped = body.data.mapNotNull { item -> mapToArtwork(item, iiifBase) }
                Result.success(mapped)
            } else {
                val filtered = CuratedArtData.curatedArtworks.filter {
                    it.title.contains(query, ignoreCase = true) ||
                    it.artistName.contains(query, ignoreCase = true) ||
                    it.movement.contains(query, ignoreCase = true)
                }
                Result.success(filtered)
            }
        } catch (e: Exception) {
            val filtered = CuratedArtData.curatedArtworks.filter {
                it.title.contains(query, ignoreCase = true) ||
                it.artistName.contains(query, ignoreCase = true) ||
                it.movement.contains(query, ignoreCase = true)
            }
            Result.success(filtered)
        }
    }

    suspend fun fetchArtworkById(id: String): Result<Artwork> {
        val curatedMatch = CuratedArtData.curatedArtworks.find { it.id == id }
        if (curatedMatch != null) return Result.success(curatedMatch)

        return try {
            val numericId = id.toLongOrNull() ?: return Result.failure(Exception("Invalid ID"))
            val response = api.getArtworkById(numericId)
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()!!
                val iiifBase = body.config?.iiifUrl ?: "https://www.artic.edu/iiif/2"
                val mapped = mapToArtwork(body.data, iiifBase)
                if (mapped != null) {
                    Result.success(mapped)
                } else {
                    Result.failure(Exception("Artwork data incomplete"))
                }
            } else {
                Result.failure(Exception("Artwork not found"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun mapToArtwork(item: ArticItem, iiifBase: String): Artwork? {
        val imgUrl = if (!item.imageId.isNullOrBlank()) {
            "$iiifBase/${item.imageId}/full/843,/0/default.jpg"
        } else null ?: return null

        val cleanDesc = item.description?.replace(Regex("<[^>]*>"), "")?.trim()
            ?: "Exhibited piece from the permanent collection."

        return Artwork(
            id = item.id.toString(),
            title = item.title ?: "Untitled Artwork",
            artistName = item.artistDisplay ?: "Unknown Artist",
            creationYear = item.dateDisplay ?: "Circa Unknown",
            medium = item.mediumDisplay ?: "Mixed Medium",
            dimensions = item.dimensions ?: "Dimensions unrecorded",
            location = item.placeOfOrigin ?: "Art Institute of Chicago",
            description = cleanDesc,
            imageUrl = imgUrl,
            thumbnailUrl = imgUrl,
            movement = "Historical Collection"
        )
    }
}
