package com.example.ps_sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.android.synthetic.main.activity_main.btn_login
import kotlinx.android.synthetic.main.activity_main.editPassword
import kotlinx.android.synthetic.main.activity_main.editUsername

class MainActivity : AppCompatActivity() {

    lateinit var sharedPref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref = PreferencesHelper(this)

        btn_login.setOnClickListener{
            if (editUsername.text.isNotEmpty() && editUsername.text.isNotEmpty()){
                sharedPref.put( Constant.PREF_USERNAME, editUsername.text.toString() )
                sharedPref.put( Constant.PREF_USERNAME, editPassword.text.toString() )
                sharedPref.put( Constant.PREF_IS_LOGIN, true )
                Toast.makeText(applicationContext, "berhasil login", Toast.LENGTH_SHORT).show()
                moveIntent()
            }
        }

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivities(Intent(this, UserActivity::class.java))
        finish()
    }
}