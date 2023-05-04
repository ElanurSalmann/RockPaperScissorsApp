package com.elanursalmanzada.rockpaperscissorsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.elanursalmanzada.rockpaperscissorsapp.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        imageChecker(binding.pic1)
        imageChecker(binding.pic2)
        imageChecker(binding.pic3)

        binding.btnPlay.setOnClickListener {

            if (binding.chooseImage.visibility == View.VISIBLE)
                play()
            else {
                Toast.makeText(
                    applicationContext,
                    "You should choose an item to start the game!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.playagaintext.setOnClickListener {
            resetGame()
        }
        setContentView(binding.root)
    }

    fun resetGame() {
        enableBtn()
        binding.playagaintext.visibility = View.INVISIBLE
        binding.chooseImage.visibility = View.INVISIBLE
        binding.compImage.visibility = View.INVISIBLE
        binding.resultText.text = "Your Result : "
    }

    fun imageChecker(imageView: ImageView) {
        imageView.setOnClickListener {
            binding.btnPlay.isEnabled = true
            if (imageView.id == R.id.pic1) {
                binding.chooseImage.setImageResource(R.drawable.scissors)
                binding.chooseImage.visibility = View.VISIBLE
            } else if (imageView.id == R.id.pic2) {
                binding.chooseImage.setImageResource(R.drawable.rock)
                binding.chooseImage.visibility = View.VISIBLE
            } else {
                binding.chooseImage.setImageResource(R.drawable.paper)
                binding.chooseImage.visibility = View.VISIBLE
            }
        }
    }

    fun play() {
        val random = (1..3).random()
        if (binding.chooseImage.visibility == View.VISIBLE) {
            if (random == 1) {
                binding.compImage.setImageResource(R.drawable.scissors)
                binding.compImage.visibility = View.VISIBLE
            } else if (random == 2) {
                binding.compImage.setImageResource(R.drawable.rock)
                binding.compImage.visibility = View.VISIBLE

            } else if (random == 3) {
                binding.compImage.setImageResource(R.drawable.paper)
                binding.compImage.visibility = View.VISIBLE
            }
        }

        if (binding.chooseImage.drawable != null) {

            if ((random == 1 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.scissors
                )!!.constantState) || (random == 2 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.rock
                )!!.constantState) || (random == 3 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.paper
                )!!.constantState)
            ) {
                binding.resultText.text = "Result: Draw"
                binding.playagaintext.visibility = View.VISIBLE
                disableBtn()

            } else if ((random == 1 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.rock
                )!!.constantState) || (random == 2 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.paper
                )!!.constantState) || (random == 3 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.scissors
                )!!.constantState)
            ) {
                binding.resultText.text = "Result: YOU WON"
                binding.playagaintext.visibility = View.VISIBLE
                disableBtn()
            } else if ((random == 2 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.scissors
                )!!.constantState) || (random == 1 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.paper
                )!!.constantState) || (random == 3 && binding.chooseImage.drawable.constantState == ContextCompat.getDrawable(
                    this,
                    R.drawable.rock
                )!!.constantState)
            ) {
                binding.resultText.text = "Result: YOU LOST"
                binding.playagaintext.visibility = View.VISIBLE
                disableBtn()
            }
        }
    }
    fun enableBtn() {
        binding.btnPlay.isEnabled = true
    }

    fun disableBtn() {
        binding.btnPlay.isEnabled = false
    }
}