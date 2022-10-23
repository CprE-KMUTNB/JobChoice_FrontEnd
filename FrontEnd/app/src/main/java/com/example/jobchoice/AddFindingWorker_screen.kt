package com.example.jobchoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class AddFindingWorker_screen : AppCompatActivity() {
    lateinit var add_btn : Button
    lateinit var companyName_edittxt : EditText
    lateinit var location_edittxt : EditText
    lateinit var jobTitle_edittxt : EditText
    lateinit var requirement_edittxt : EditText
    lateinit var salary_edittxt : EditText
    lateinit var contact_edittxt : EditText

    var companyName_str = ""
    var location_str = ""
    var jobTitle_str = ""
    var requirement_str = ""
    var salary_str = ""
    var contact_str = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_finding_worker_screen)

        companyName_edittxt = findViewById(R.id.companyname_edittxt)
        location_edittxt = findViewById(R.id.location_edittxt)
        jobTitle_edittxt = findViewById(R.id.jobTitle_edittxt)
        requirement_edittxt = findViewById(R.id.requirement_edittxt)
        salary_edittxt = findViewById(R.id.salary_edittxt)
        contact_edittxt = findViewById(R.id.contact_edittxt)

        companyName_str = companyName_edittxt.text.toString()
        location_str = location_edittxt.text.toString()
        jobTitle_str = jobTitle_edittxt.text.toString()
        requirement_str = requirement_edittxt.text.toString()
        salary_str = salary_edittxt.text.toString()
        contact_str = contact_edittxt.text.toString()

        add_btn = findViewById(R.id.add_btn)
        add_btn.setOnClickListener {
            afterAdd()
        }
    }

    private fun afterAdd(){
        Toast.makeText(this, "ADD", Toast.LENGTH_SHORT).show();
        val intent = Intent(this, AfterLogin::class.java)
        startActivity(intent)
    }
}