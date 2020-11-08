package com.example.level5_task2.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.level5_task2.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM reminderTable")
    fun getAllReminders(): LiveData<List<Note>>

    @Insert
    suspend fun insertReminder(reminder: Note)

    @Delete
    suspend fun deleteReminder(reminder: Note)

    @Update
    suspend fun updateReminder(reminder: Note)

}