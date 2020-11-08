package com.example.level5_task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.level5_task2.R
import com.example.level5_task2.model.Game
import kotlinx.android.synthetic.main.fragment_add_game.*

class AddGameFragment : Fragment() {

    // TODO: fix error here
//    private val viewModel: NotepadViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_game, container, false)   
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddGame.setOnClickListener {
            onAddgame()
        }
    }

    private fun onAddgame(){
        // Get the user input
        val title = etTitle.text.toString()
        val platform = etPlatform.text.toString()
        val day = etDay.text.toString()
        val month = etMonth.text.toString()
        val year = etYear.text.toString()

        // Check if submitted unput is not empty
        if (title.isNotBlank() && platform.isNotBlank() && day.isNotBlank() && month.isNotBlank() && year.isNotBlank()){
//            viewModel.insertGame(Game(gameText))

            // Destroy current fragment to go back to home fragment (gamesFragment.kt)
            findNavController().popBackStack()
        } else {
            Toast.makeText(activity, R.string.no_input, Toast.LENGTH_SHORT).show()
        }
    }
}