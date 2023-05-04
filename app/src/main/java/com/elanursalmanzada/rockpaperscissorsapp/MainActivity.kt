package com.elanursalmanzada.rockpaperscissorsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.elanursalmanzada.rockpaperscissorsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)


        binding.playBtn.setOnClickListener {
            makeIntent()
        }

        setContentView(binding.root)
    }
    fun makeIntent(){
        val intent= Intent(this,GameActivity::class.java)
        startActivity(intent)
    }



}