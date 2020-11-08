package com.example.level5_task2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.level5_task2.model.Game
import com.example.level5_task2.repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewmodel (application: Application): AndroidViewModel(application) {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val reminderRepository = GameRepository(application.applicationContext)

    val games: LiveData<List<Game>> = reminderRepository.getAllGames()

    fun insertGame(game: Game) {
        ioScope.launch {
            reminderRepository.insertGame(game)
        }
    }

    fun deleteGame(game: Game) {
        ioScope.launch {
            reminderRepository.deleteGame(game)
        }
    }
}