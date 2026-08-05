package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.api.CuratedArtData
import com.example.data.db.SavedArtworkDao
import com.example.data.db.SavedArtworkEntity
import com.example.data.model.ArtMovement
import com.example.data.model.Artwork
import com.example.data.model.Museum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class ArtworkRepository(
    private val apiService: ApiService,
    private val savedArtworkDao: SavedArtworkDao
) {

    val savedArtworks: Flow<List<SavedArtworkEntity>> = savedArtworkDao.getAllSavedArtworks()

    suspend fun getMasterpieceOfTheDay(): Artwork {
        val masterpiece = CuratedArtData.masterpieceOfTheDay
        val isFav = savedArtworkDao.isSaved(masterpiece.id).first()
        return masterpiece.copy(isFavorite = isFav)
    }

    suspend fun getArtworks(): Result<List<Artwork>> {
        val result = apiService.fetchArtworks()
        return if (result.isSuccess) {
            val list = result.getOrNull() ?: CuratedArtData.curatedArtworks
            val savedIds = savedArtworks.first().map { it.id }.toSet()
            val updated = list.map { it.copy(isFavorite = savedIds.contains(it.id)) }
            Result.success(updated)
        } else {
            Result.success(CuratedArtData.curatedArtworks)
        }
    }

    suspend fun searchArtworks(query: String): Result<List<Artwork>> {
        val result = apiService.searchArtworks(query)
        return if (result.isSuccess) {
            val list = result.getOrNull() ?: emptyList()
            val savedIds = savedArtworks.first().map { it.id }.toSet()
            val updated = list.map { it.copy(isFavorite = savedIds.contains(it.id)) }
            Result.success(updated)
        } else {
            Result.failure(result.exceptionOrNull() ?: Exception("Search error"))
        }
    }

    suspend fun getArtworkById(id: String): Result<Artwork> {
        val result = apiService.fetchArtworkById(id)
        return if (result.isSuccess) {
            val artwork = result.getOrNull()!!
            val isFav = savedArtworkDao.isSaved(id).first()
            Result.success(artwork.copy(isFavorite = isFav))
        } else {
            val fallback = CuratedArtData.curatedArtworks.find { it.id == id }
            if (fallback != null) {
                val isFav = savedArtworkDao.isSaved(id).first()
                Result.success(fallback.copy(isFavorite = isFav))
            } else {
                Result.failure(Exception("Artwork not found"))
            }
        }
    }

    fun isSaved(id: String): Flow<Boolean> = savedArtworkDao.isSaved(id)

    suspend fun toggleFavorite(artwork: Artwork, notes: String = "") {
        val isFav = savedArtworkDao.isSaved(artwork.id).first()
        if (isFav) {
            savedArtworkDao.removeArtwork(artwork.id)
        } else {
            savedArtworkDao.saveArtwork(SavedArtworkEntity.fromArtwork(artwork, notes))
        }
    }

    suspend fun updateNotes(id: String, notes: String) {
        savedArtworkDao.updateNotes(id, notes)
    }

    fun getArtMovements(): List<ArtMovement> = CuratedArtData.artMovements

    fun getMuseums(): List<Museum> = CuratedArtData.museums
}
