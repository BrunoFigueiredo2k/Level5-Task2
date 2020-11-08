package com.example.level5_task2.model

import androidx.room.*
import java.util.*

/** Data class called game which has a String representing the game **/
@Entity(tableName = "gameTable")
data class Game(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "platform")
    var platform: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: Date,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)
