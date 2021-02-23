package com.example.roomquizapp.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomquizapp.model.Question

@Database(entities = arrayOf(Question::class),version = 1)
abstract class QuestionDb:RoomDatabase() {
    abstract  fun questionDao(): QuestionDao

    companion object{
        @Volatile
        var INSTANCE: QuestionDb?= null

        @Synchronized
        fun getInstance(context:Context):QuestionDb{
            if(INSTANCE== null){
                INSTANCE=Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDb::class.java,
                    "question_db"
                )
                    .addCallback(roomDbCallback)
                    .build()
            }

            return INSTANCE as QuestionDb
        }

        private val roomDbCallback=object :RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsyncTask(INSTANCE).execute()
            }
        }
        class PopulateAsyncTask(private val db: QuestionDb?): AsyncTask<Void,Void,Void>(){ // 15:50
            private val dao: QuestionDao? by lazy { db?.questionDao() }

            override fun doInBackground(vararg params: Void?): Void? {
                var question = Question(
                    question = "Which one is rpg game",
                    optionA = " The Witcher",
                    optionB = "Assasins Creed",
                    optionC = "Warhammer II",
                    answerr = "The Witcher"
                )
                    dao?.addQuestion(question)

                 question = Question(
                    question = "Which one is Strategy game",
                    optionA = " The Witcher",
                    optionB = "Assasins Creed",
                    optionC = "Warhammer II",
                    answerr = "Warhammer II"
                )
                dao?.addQuestion(question)


                 question = Question(
                    question = "Which one is sneak game",
                    optionA = " The Witcher",
                    optionB = "Assasins Creed",
                    optionC = "Warhammer II",
                    answerr = "Assasins Creed"
                )
                dao?.addQuestion(question)

                return null
            }



        }
    }
}