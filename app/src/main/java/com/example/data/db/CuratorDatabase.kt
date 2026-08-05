package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SavedArtworkEntity::class], version = 1, exportSchema = false)
abstract class CuratorDatabase : RoomDatabase() {
    abstract fun savedArtworkDao(): SavedArtworkDao

    companion object {
        @Volatile
        private var INSTANCE: CuratorDatabase? = null

        fun getDatabase(context: Context): CuratorDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CuratorDatabase::class.java,
                    "curator_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
