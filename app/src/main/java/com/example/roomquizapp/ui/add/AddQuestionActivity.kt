package com.example.roomquizapp.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.roomquizapp.R
import com.example.roomquizapp.model.Question
import kotlinx.android.synthetic.main.activity_add_question.*

class AddQuestionActivity : AppCompatActivity() {
    private lateinit var viewModel: AddQuestionViewModel
    private lateinit var answer: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)

        viewModel = ViewModelProviders.of(this).get(AddQuestionViewModel::class.java)

        prepareSpinner()


        add_btn.setOnClickListener {
            val question = editTextTextQuestion.text.toString()
            val optionA = editTextText2.text.toString()
            val optionB = editTextText3.text.toString()
            val optionC = editTextText4.text.toString()

            viewModel.insert(
                Question(
                    question = question,
                    optionA = optionA,
                    optionB = optionB,
                    optionC = optionC,
                    answerr = if(answer=="A") optionA
                                else if (answer=="B") optionB
                                else optionC

                )
            )
        }
        Toast.makeText(this,"Succesfull",Toast.LENGTH_SHORT).show()

    }

    private fun prepareSpinner() {
        val optList = mutableListOf("A", "B", "C")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, optList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter= adapter
        spinner2.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                answer= parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}