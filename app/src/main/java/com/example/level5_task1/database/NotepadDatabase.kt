package com.example.level5_task1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.level5_task1.dao.NotepadDao
import com.example.level5_task1.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class ReminderRoomDatabase : RoomDatabase() {

    abstract fun reminderDao(): NotepadDao

    companion object {
        private const val DATABASE_NAME = "REMINDER_DATABASE"

        @Volatile
        private var reminderRoomDatabaseInstance: ReminderRoomDatabase? = null

        fun getDatabase(context: Context): ReminderRoomDatabase? {
            if (reminderRoomDatabaseInstance == null) {
                synchronized(ReminderRoomDatabase::class.java) {
                    if (reminderRoomDatabaseInstance == null) {
                        reminderRoomDatabaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            ReminderRoomDatabase::class.java,
                            DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return reminderRoomDatabaseInstance
        }
    }

}
