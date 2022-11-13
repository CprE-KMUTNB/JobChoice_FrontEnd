package com.example.jobchoice

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class searchjob_detail_screen : AppCompatActivity() {
    lateinit var fullname_txtview: TextView
    lateinit var jobTitle_txtview: TextView
    lateinit var education_txtview: TextView
    lateinit var ability_txtview: TextView
    lateinit var salaryNeed_txtview: TextView
    lateinit var contact_txtview: TextView
    lateinit var image_view : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchjob_detail_screen)
        val actionBar = supportActionBar
        fullname_txtview = findViewById(R.id.fullname_txtview)
        jobTitle_txtview = findViewById(R.id.jobTitle_txtview)
        education_txtview = findViewById(R.id.education_txtview)
        ability_txtview = findViewById(R.id.ability_txtview)
        salaryNeed_txtview = findViewById(R.id.salaryNeed_txtview)
        contact_txtview = findViewById<TextView>(R.id.contact_txtview)
        image_view = findViewById(R.id.image_view)

        val intent = intent
        val fullname_str = intent.getStringExtra("fullname")
        val jobTitle_str = intent.getStringExtra("jobTitle")
        val education_str = intent.getStringExtra("education")
        val ability_str = intent.getStringExtra("ability")
        val salaryNeed_str = intent.getStringExtra("salaryNeed")
        val contact_str = intent.getStringExtra("contact")
        val file_str = intent.getStringExtra("file")


        actionBar!!.setTitle(fullname_str)
        fullname_txtview.setText(fullname_str)
        jobTitle_txtview.setText(jobTitle_str)
        education_txtview.setText(education_str)
        ability_txtview.setText(ability_str)
        salaryNeed_txtview.setText(salaryNeed_str)
        contact_txtview.setText(contact_str)

        val bitmap: Bitmap = BitmapFactory.decodeFile(file_str)
        image_view.setImageBitmap(bitmap)
    }
}