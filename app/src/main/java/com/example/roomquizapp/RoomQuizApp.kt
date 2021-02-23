package com.example.roomquizapp

import android.app.Application
import com.facebook.stetho.Stetho

class RoomQuizApp :Application(){
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}