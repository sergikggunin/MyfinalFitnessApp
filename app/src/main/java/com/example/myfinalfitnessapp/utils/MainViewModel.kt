package com.example.myfinalfitnessapp.utils

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myfinalfitnessapp.adapters.ExerciseModel

class MainViewModel : ViewModel() {
    val mutableListExercise = MutableLiveData<ArrayList<ExerciseModel>>()
    var pref: SharedPreferences? = null
    var currentDay = 0

    fun savePref(key: String, value: Int){
        pref?.edit()?.putInt(key, value)?.apply()
    }

    fun getExerciseCount(): Int{
        return pref?.getInt(currentDay.toString(), 0) ?: 0
    }
}