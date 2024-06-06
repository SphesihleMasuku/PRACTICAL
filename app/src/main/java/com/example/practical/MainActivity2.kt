package com.example.practical

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var saveBtn : Button
    private lateinit var clearBtn : Button
    private lateinit var nextBtn : Button
    private lateinit var date : EditText
    private lateinit var  morningTime : EditText
    private lateinit var  afternoonTime : EditText
    private lateinit var notes : EditText
    private lateinit var tvMessage : TextView


    private val dateArray = mutableListOf<Float>()
    private val timeArrayMorning = mutableListOf<Float>()
    private val timeArrayAfternoon = mutableListOf<Float>()
    private val notesArray = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        saveBtn=findViewById(R.id.saveBtn)
        clearBtn=findViewById(R.id.clearBtn)
        nextBtn=findViewById(R.id.nextBtn)
        date=findViewById(R.id.date)
        morningTime=findViewById(R.id.morningTime)
        afternoonTime=findViewById(R.id.afternoonTime)
        notes=findViewById(R.id.notes)
        tvMessage=findViewById(R.id.tvMessage)

        clearBtn.setOnClickListener {
            date.setText("")
            notes.setText("")
            morningTime.setText("")
            afternoonTime.setText("")
        }

        saveBtn.setOnClickListener {
           val screenTimeDate = date.text.toString()
            val screenTimeMorning = morningTime.text.toString()
            val screenTimeAfternoon = afternoonTime.text.toString()
            val screenNotes = notes.text.toString()

            if (screenTimeDate.isNotEmpty() && screenTimeMorning.isNotEmpty() && screenTimeAfternoon.isNotEmpty() && screenNotes.isNotEmpty())
                try {
                    dateArray.add(screenTimeDate.toFloat())
                    timeArrayMorning.add(screenTimeMorning.toFloat())
                    timeArrayAfternoon.add(screenTimeAfternoon.toFloat())
                    notesArray.add((screenNotes))
                    date.text.clear()
                    morningTime.text.clear()
                    afternoonTime.text.clear()
                    notes.text.clear()
                } catch (e:NumberFormatException) {
                    tvMessage.text = "Please enter a valid number"
                } else {
                    tvMessage.text = "Input cannot be empty"
            }
        }

        nextBtn.setOnClickListener {
           val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putExtra("dateArray", dateArray.toFloatArray())
            intent.putExtra("timeArrayMorning", timeArrayMorning.toFloatArray())
            intent.putExtra("timeArrayAfternoon", timeArrayAfternoon.toFloatArray())
            intent.putExtra("notesArray", notesArray.toTypedArray())
            startActivity(intent)
        }








    }
}