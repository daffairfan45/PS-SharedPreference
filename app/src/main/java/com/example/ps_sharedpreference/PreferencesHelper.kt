package com.example.ps_sharedpreference

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    private val PREF_NAME = "sharedPreferenceKotlin123"
    private val sharedPref : SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPref.edit()
    }

    fun put(key: String, value: String){
        editor.putString(key, value)
            .apply()
    }

    fun getString(key: String) :String?{
        return sharedPref.getString(key, null)
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, false)
            .apply()
    }

    fun getBoolean(key: String) : Boolean{
        return sharedPref.getBoolean(key, false)
    }

    fun clear(){
        editor.clear()
            .apply()
    }
}