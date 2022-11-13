package com.example.jobchoice

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class searchworker_detail_screen : AppCompatActivity() {
    lateinit var companyName_txtview: TextView
    lateinit var jobTitle_txtview: TextView
    lateinit var requirement_txtview: TextView
    lateinit var salary_txtview: TextView
    lateinit var detail_txtview : TextView
    lateinit var contact_txtview : TextView
    lateinit var image_view : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchworker_detail_screen)
        val actionBar = supportActionBar
        companyName_txtview = findViewById(R.id.companyName_txtview)
        jobTitle_txtview = findViewById(R.id.jobTitle_txtview)
        requirement_txtview = findViewById(R.id.requirement_txtview)
        salary_txtview = findViewById(R.id.salary_txtview)
        detail_txtview = findViewById(R.id.detail_txtview)
        contact_txtview = findViewById(R.id.contact_txtview)
        image_view = findViewById(R.id.image_view)

        val intent = intent
        val companyName_str = intent.getStringExtra("companyName")
        val jobTitle_str = intent.getStringExtra("jobTitle")
        val requirement_str = intent.getStringExtra("requirement")
        val salary_str = intent.getStringExtra("salary")
        val detail_str = intent.getStringExtra("detail")
        val contact_str = intent.getStringExtra("contact")
        val file_str = intent.getStringExtra("file")

        actionBar!!.setTitle(companyName_str)
        companyName_txtview.setText(companyName_str)
        jobTitle_txtview.setText(jobTitle_str)
        requirement_txtview.setText(requirement_str)
        salary_txtview.setText(salary_str)
        detail_txtview.setText(detail_str)
        contact_txtview.setText(contact_str)

        val bitmap: Bitmap = BitmapFactory.decodeFile(file_str)
        image_view.setImageBitmap(bitmap)
    }
}