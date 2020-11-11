package com.example.level5_task2.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.level5_task2.model.Game

@Dao
interface GameDao {

    // Select all games from db with newest games first
    @Query("SELECT * FROM gameTable ORDER BY releaseDate DESC")
    fun getAllGames(): LiveData<List<Game>>

    // Delete all games from list
    @Query("DELETE FROM gameTable")
    fun removeAllGames()

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)

}