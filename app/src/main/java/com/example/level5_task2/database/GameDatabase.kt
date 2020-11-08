package com.example.level5_task2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.level5_task2.dao.GameDao
import com.example.level5_task2.model.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class GameRoomDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao

    companion object {
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var GameRoomDatabaseInstance: GameRoomDatabase? = null

        fun getDatabase(context: Context): GameRoomDatabase? {
            if (GameRoomDatabaseInstance == null) {
                synchronized(GameRoomDatabase::class.java) {
                    if (GameRoomDatabaseInstance == null) {
                        GameRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            GameRoomDatabase::class.java,
                            DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return GameRoomDatabaseInstance
        }
    }

}
