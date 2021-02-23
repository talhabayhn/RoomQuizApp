package com.example.roomquizapp.ui.add

import android.content.Context
import android.os.AsyncTask
import com.example.roomquizapp.data.QuestionDao
import com.example.roomquizapp.data.QuestionDb
import com.example.roomquizapp.model.Question

class AddQuestionRepository(context: Context) {
    private  val db by lazy { QuestionDb.getInstance(context) }
    private val dao by lazy { db.questionDao() }

    fun insertQuestion(question:Question){
        InsertAsynTask(dao).execute(question)
    }

    private class InsertAsynTask(val dao:QuestionDao):AsyncTask<Question,Void,Void>(){
        override fun doInBackground(vararg params: Question?): Void? {
            dao.addQuestion(params[0]!!)
            return null
        }

    }
}