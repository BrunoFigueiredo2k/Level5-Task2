package com.example.level5_task1.model

import androidx.room.*

/** Data class called Reminder which has a String representing the reminder **/
@Entity(tableName = "reminderTable")
data class Note(

    @ColumnInfo(name = "reminder")
    var reminderText: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)
