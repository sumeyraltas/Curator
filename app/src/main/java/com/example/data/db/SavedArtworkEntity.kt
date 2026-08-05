package com.example.data.db

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import com.example.data.model.Artwork
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "saved_artworks")
data class SavedArtworkEntity(
    @PrimaryKey val id: String,
    val title: String,
    val artistName: String,
    val creationYear: String,
    val medium: String,
    val dimensions: String,
    val location: String,
    val description: String,
    val imageUrl: String,
    val thumbnailUrl: String,
    val movement: String,
    val personalNotes: String = "",
    val savedTimestamp: Long = System.currentTimeMillis()
) {
    fun toArtwork(): Artwork {
        return Artwork(
            id = id,
            title = title,
            artistName = artistName,
            creationYear = creationYear,
            medium = medium,
            dimensions = dimensions,
            location = location,
            description = description,
            imageUrl = imageUrl,
            thumbnailUrl = thumbnailUrl,
            movement = movement,
            isFavorite = true
        )
    }

    companion object {
        fun fromArtwork(artwork: Artwork, notes: String = ""): SavedArtworkEntity {
            return SavedArtworkEntity(
                id = artwork.id,
                title = artwork.title,
                artistName = artwork.artistName,
                creationYear = artwork.creationYear,
                medium = artwork.medium,
                dimensions = artwork.dimensions,
                location = artwork.location,
                description = artwork.description,
                imageUrl = artwork.imageUrl,
                thumbnailUrl = artwork.thumbnailUrl,
                movement = artwork.movement,
                personalNotes = notes
            )
        }
    }
}

@Dao
interface SavedArtworkDao {
    @Query("SELECT * FROM saved_artworks ORDER BY savedTimestamp DESC")
    fun getAllSavedArtworks(): Flow<List<SavedArtworkEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM saved_artworks WHERE id = :id)")
    fun isSaved(id: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtwork(entity: SavedArtworkEntity)

    @Query("DELETE FROM saved_artworks WHERE id = :id")
    suspend fun removeArtwork(id: String)

    @Query("UPDATE saved_artworks SET personalNotes = :notes WHERE id = :id")
    suspend fun updateNotes(id: String, notes: String)
}
