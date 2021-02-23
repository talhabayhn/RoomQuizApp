package com.example.roomquizapp.ui.quiz

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomquizapp.model.Question

class QuizViewModel(application: Application):AndroidViewModel(application) {
    private val repository:QuizRepository by lazy { QuizRepository(application) }

    val allQuestion: LiveData<List<Question>> by lazy { repository.getAllQuestions() }
}