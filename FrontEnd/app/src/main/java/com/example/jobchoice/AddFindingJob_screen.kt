package com.example.jobchoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast


class AddFindingJob_screen : AppCompatActivity() {
    lateinit var add_btn : Button
    lateinit var firstname_edittxt : EditText
    lateinit var lastname_edittxt : EditText
    lateinit var age_edittxt : EditText
    lateinit var location_edittxt : EditText
    lateinit var education_edittxt : EditText
    lateinit var contact_edittxt : EditText
    lateinit var other_edittxt : EditText

    var firstname_str = ""
    var lastname_str = ""
    var age_str = ""
    var location_str = ""
    var education_str = ""
    var contact_str = ""
    var other_str = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_finding_job_screen)

        firstname_edittxt = findViewById(R.id.firstname_edittxt)
        lastname_edittxt = findViewById(R.id.lastname_edittxt)
        age_edittxt = findViewById(R.id.age_edittxt)
        location_edittxt = findViewById(R.id.location_edittxt)
        education_edittxt = findViewById(R.id.education_edittxt)
        contact_edittxt = findViewById(R.id.contact_edittxt)
        other_edittxt = findViewById(R.id.other_edittxt)

        firstname_str = firstname_edittxt.text.toString()
        lastname_str = lastname_edittxt.text.toString()
        age_str = age_edittxt.text.toString()
        location_str = location_edittxt.text.toString()
        education_str = education_edittxt.text.toString()
        contact_str = contact_edittxt.text.toString()
        other_str = other_edittxt.text.toString()


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