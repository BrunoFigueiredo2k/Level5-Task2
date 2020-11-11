package com.example.level5_task2.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.level5_task2.R
import com.example.level5_task2.model.Game
import kotlinx.android.synthetic.main.fragment_add_game.*
import java.util.*

class AddGameFragment : Fragment() {

    private val viewModel: GameViewmodel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Set title and backarrow in fragment
        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.add_game_title)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

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

        // Date values
        val daysInMonth = 31
        val monthInYear = 12
        val currentYear = 2020

        // Check if submitted unput is not empty
        if (title.isBlank() && platform.isBlank() && day.isBlank() && month.isBlank() && year.isBlank()){
            Toast.makeText(activity, R.string.no_input, Toast.LENGTH_SHORT).show()
        } else if (day.toInt() < 1 || day.toInt() > daysInMonth){
            Toast.makeText(activity, R.string.day_error, Toast.LENGTH_SHORT).show()
        } else if (month.toInt() < 1 || month.toInt() > monthInYear){
            Toast.makeText(activity, R.string.month_error, Toast.LENGTH_SHORT).show()
        } else if (year.toInt() < 1 || year.toInt() > currentYear){
            Toast.makeText(activity, R.string.year_error, Toast.LENGTH_SHORT).show()
        }else {
            val cal = Calendar.getInstance()
            cal[Calendar.YEAR] = year.toInt()
            cal[Calendar.MONTH] = month.toInt()
            cal[Calendar.DAY_OF_MONTH] = day.toInt()
            val releaseDate = cal.time

            viewModel.insertGame(Game(title, platform, releaseDate))

            // Destroy current fragment to go back to home fragment (gamesFragment.kt)
            findNavController().popBackStack()
        }
    }
}