package com.example.level5_task2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.level5_task2.dao.GameDao
import com.example.level5_task2.database.ReminderRoomDatabase
import com.example.level5_task2.model.Note


public class NoteRepository(context: Context) {

    private var reminderDao: GameDao

    init {
        val reminderRoomDatabase = ReminderRoomDatabase.getDatabase(context)
        reminderDao = reminderRoomDatabase!!.reminderDao()
    }

    fun getAllReminders() : LiveData<List<Note>> {
        return reminderDao?.getAllReminders() ?: MutableLiveData(emptyList())
    }

    suspend fun insertReminder(reminder: Note) {
        reminderDao.insertReminder(reminder)
    }

    suspend fun deleteReminder(reminder: Note) {
        reminderDao.deleteReminder(reminder)
    }


    suspend fun updateReminder(reminder: Note) {
        reminderDao.updateReminder(reminder)
    }
}
