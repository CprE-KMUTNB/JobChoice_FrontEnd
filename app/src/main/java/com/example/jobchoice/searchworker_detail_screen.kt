package com.example.jobchoice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class searchworker_detail_screen : AppCompatActivity() {
    lateinit var companyName_txtView: TextView
    lateinit var jobTitle_txtView: TextView
    lateinit var requirement_txtView: TextView
    lateinit var salary_txtView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchworker_detail_screen)
        val actionBar = supportActionBar
        companyName_txtView = findViewById(R.id.companyName_txtview)
        jobTitle_txtView = findViewById(R.id.jobTitle_txtview)
        requirement_txtView = findViewById(R.id.requirement_txtview)
        salary_txtView = findViewById(R.id.salary_txtview)

        val intent = intent
        val companyName_str = intent.getStringExtra("companyName")
        val jobTitle_str = intent.getStringExtra("jobTitle")
        val requirement_str = intent.getStringExtra("requirement")
        val salary_str = intent.getStringExtra("salary")

        actionBar!!.setTitle(companyName_str)
        companyName_txtView.setText(companyName_str)
        jobTitle_txtView.setText(jobTitle_str)
        requirement_txtView.setText(requirement_str)
        salary_txtView.setText(salary_str)
    }
}