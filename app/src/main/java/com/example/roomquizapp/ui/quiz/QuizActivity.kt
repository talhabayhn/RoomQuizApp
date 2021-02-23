package com.example.roomquizapp.ui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roomquizapp.R
import com.example.roomquizapp.model.Question
import com.example.roomquizapp.ui.result.ResultActivity
import com.example.roomquizapp.util.Constants
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    private lateinit var viewModel: QuizViewModel
    private  var questionList:List<Question> = arrayListOf()
    private var qIndex: Int= 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        viewModel = ViewModelProviders.of(this).get(QuizViewModel::class.java)
        viewModel.allQuestion.observe(this, Observer {
                if(it.isNotEmpty()){
                    questionList= it
                    setView()

                    next_btn.setOnClickListener {
                        val answer= findViewById<Chip>(chip_group.checkedChipId)
                        chip_group.clearCheck()

                        checkAnswer(answer)
                        qIndex++
                        if(qIndex<questionList.size){setView()}
                        else{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.EXTRA_RESUT,score)
                            intent.putExtra(Constants.EXTRA_LIST_SIZE,questionList.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
        })
    }
    private fun checkAnswer(answer: Chip){
        if(questionList[qIndex].answerr==answer.text){
            Toast.makeText(this,"Correct answer.",Toast.LENGTH_SHORT).show()
            score++
        }
        else{
            Toast.makeText(this,"Wrong answer!!\n${questionList[qIndex].answerr}",Toast.LENGTH_SHORT).show()

        }
    }

    private  fun setView(){
        question_tv.text= questionList[qIndex].question
        option_a_chip.text= questionList[qIndex].optionA
        option_b_chip.text= questionList[qIndex].optionB
        option_c_chip.text= questionList[qIndex].optionC
    }

}