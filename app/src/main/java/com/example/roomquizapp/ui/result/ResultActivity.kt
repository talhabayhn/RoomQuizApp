package com.example.roomquizapp.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomquizapp.R
import com.example.roomquizapp.util.Constants
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        intent.extras.let { //if different from null
            val result= intent.extras?.getInt(Constants.EXTRA_RESUT)
            val listSize= intent.extras?.getInt(Constants.EXTRA_LIST_SIZE)
            result_tv.text="$result/$listSize correct."
        }
    }
}