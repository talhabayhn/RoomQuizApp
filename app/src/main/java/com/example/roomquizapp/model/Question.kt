package com.example.roomquizapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class Question (

    @PrimaryKey(autoGenerate = true)
    var qid: Int =0,

    var question:String,

    @ColumnInfo(name= "options_a")
    var optionA: String,

    @ColumnInfo(name= "options_b")
    var optionB: String,

    @ColumnInfo(name= "options_c")
    var optionC: String,

    var answerr:String

        )