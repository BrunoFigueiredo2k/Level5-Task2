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
import com.example.level5_task2.model.Note
import kotlinx.android.synthetic.main.fragment_add_reminder.*

class AddNoteFragment : Fragment() {

    private val viewModel: NotepadViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_reminder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddReminder.setOnClickListener {
            onAddReminder()
        }
    }

    private fun onAddReminder(){
        // Get the user input
        val reminderText = etReminderName.text.toString()

        // Check if submitted unput is not empty
        if (reminderText.isNotBlank()){
            viewModel.insertReminder(Note(reminderText))

            // Destroy current fragment to go back to home fragment (RemindersFragment.kt)
            findNavController().popBackStack()
        } else {
            Toast.makeText(activity,
                R.string.not_valid_reminder, Toast.LENGTH_SHORT).show()
        }
    }
}