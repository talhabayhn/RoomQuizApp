package com.example.roomquizapp.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomquizapp.R
import com.example.roomquizapp.ui.add.AddQuestionActivity
import com.example.roomquizapp.ui.quiz.QuizActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

       start_quiz_btn.setOnClickListener {
          startActivity(Intent(this,QuizActivity::class.java))
           finish()

       }
        add_question_btn.setOnClickListener {
            startActivity(Intent(this,AddQuestionActivity::class.java))
        }
    }
}