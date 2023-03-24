package com.example.a7minusworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.a7minusworkout.databinding.ActivityExcerciseBinding

class ExcerciseActivity : AppCompatActivity() {
    private var binding: ActivityExcerciseBinding? = null
    private var timer: CountDownTimer? = null
    private var progressValue: Int = 0
    private val progressMaxValue: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExcerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarExcercise)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarExcercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        setProgressTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        if (timer != null) {
            timer?.cancel()
            timer = null
        }
    }

    private fun setProgressTimer() {
        progressValue = 0
        binding?.progressBar?.progress = progressMaxValue
        binding?.progressBar?.max = progressMaxValue
        binding?.tvTimer?.text = progressMaxValue.toString()
        timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                progressValue ++
                val progress = progressMaxValue - progressValue
                binding?.progressBar?.progress = progress
                binding?.tvTimer?.text = progress.toString()
            }

            override fun onFinish() {
                Toast.makeText(this@ExcerciseActivity, "Here now we will start the exercise.", Toast.LENGTH_LONG).show()
            }
        }
        timer?.start()
    }
}