package com.example.jobchoice

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class searchjob_detail_screen : AppCompatActivity() {
    lateinit var fullname_txtView: TextView
    lateinit var jobTitle_txtView: TextView
    lateinit var education_txtView: TextView
    lateinit var ability_txtView: TextView
    lateinit var image_view : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchjob_detail_screen)
        val actionBar = supportActionBar
        fullname_txtView = findViewById(R.id.fullname_txtview)
        jobTitle_txtView = findViewById(R.id.jobTitle_txtview)
        education_txtView = findViewById(R.id.education_txtview)
        ability_txtView = findViewById(R.id.ability_txtview)
        image_view = findViewById(R.id.image_view)

        val intent = intent
        val fullname_str = intent.getStringExtra("fullname")
        val jobTitle_str = intent.getStringExtra("jobTitle")
        val education_str = intent.getStringExtra("education")
        val ability_str = intent.getStringExtra("ability")
        val file_str = intent.getStringExtra("file")


        actionBar!!.setTitle(fullname_str)
        fullname_txtView.setText(fullname_str)
        jobTitle_txtView.setText(jobTitle_str)
        education_txtView.setText(education_str)
        ability_txtView.setText(ability_str)

        val bitmap: Bitmap = BitmapFactory.decodeFile(file_str)
        image_view.setImageBitmap(bitmap)
    }
}