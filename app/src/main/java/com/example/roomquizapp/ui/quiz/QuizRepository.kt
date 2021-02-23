package com.example.roomquizapp.ui.quiz

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roomquizapp.data.QuestionDao
import com.example.roomquizapp.data.QuestionDb
import com.example.roomquizapp.model.Question

class QuizRepository(context: Context) {
    private val db:QuestionDb by lazy { QuestionDb.getInstance(context)}
    private val dao:QuestionDao by lazy { db.questionDao() }

    fun getAllQuestions(): LiveData<List<Question>> =
    dao.getQuestions()
}