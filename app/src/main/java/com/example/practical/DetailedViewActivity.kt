package com.example.practical

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewActivity : AppCompatActivity() {
    private lateinit var btn_back: Button
    private lateinit var tv_details: TextView
    private lateinit var tvHoursAM: TextView
    private lateinit var tvHoursPM: TextView
    private lateinit var tvHoursNotes: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)

        btn_back = findViewById(R.id.btn_back)
        tv_details = findViewById(R.id.tv_details)
        tvHoursAM = findViewById(R.id.tvHoursAM)
        tvHoursPM = findViewById(R.id.tvHoursPM)
        tvHoursNotes = findViewById(R.id.tvHoursNotes)


        val dateArray = intent.getFloatArrayExtra("dateArray")?.toList() ?: emptyList()
        val timeArrayMorning = intent.getFloatArrayExtra("timeArrayMorning")?.toList() ?: emptyList()
        val timeArrayAfternoon = intent.getFloatArrayExtra("timeArrayAfternoon")?.toList() ?: emptyList()
        val notesArray = intent.getStringArrayExtra("notesArray") ?: emptyArray()


        val dated = StringBuilder()
        for((index,date) in dateArray.withIndex()){
            dated.append("Day ${index + 1}: $date\n}")
        }

        val hoursAM = StringBuilder()
        for((index,time) in timeArrayMorning.withIndex()){
            hoursAM.append("Morning $index: $time \n")
        }

        val hoursPM = StringBuilder()
        for((index,time) in timeArrayAfternoon.withIndex()){
            hoursPM.append("Afternoon $index: $time")
        }

        val noted = StringBuilder()
        for ((index,note) in notesArray.withIndex()){
            noted.append("Note $index: $note \n")
        }

        tv_details.text = dated.toString()
        tvHoursAM.text = hoursAM.toString()
        tvHoursPM.text = hoursPM.toString()
        tvHoursNotes.text = noted.toString()

        btn_back.setOnClickListener {
            finish()
    }
}
}
