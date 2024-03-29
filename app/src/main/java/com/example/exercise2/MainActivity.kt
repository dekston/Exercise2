package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            CalculateBMI()
        }
        buttonReset.setOnClickListener{
            Reset()
        }

    }

    private fun Reset() {
        editTextHeight.text.clear()
        editTextWeight.text.clear()
    }

    private fun CalculateBMI(){
        if(editTextWeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            return
        }
        if(editTextHeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            return
        }
        val weight=editTextWeight.text.toString().toFloat()
        val height=editTextHeight.text.toString().toFloat()
        val bmi=weight/(height/100).pow(2)

        if(bmi<18.5){
            textViewBMI.text=String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.under))
            imageView.setImageResource(R.drawable.under)
        }
        else if(bmi>=18.5&&bmi<=24.9){
            textViewBMI.text=String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.normal))
            imageView.setImageResource(R.drawable.normal)
        }
        else if(bmi>=25){
            textViewBMI.text=String.format("%s %.2f (%s)",getString(R.string.bmi),bmi,getString(R.string.over))
            imageView.setImageResource(R.drawable.over)
        }
    }
}
