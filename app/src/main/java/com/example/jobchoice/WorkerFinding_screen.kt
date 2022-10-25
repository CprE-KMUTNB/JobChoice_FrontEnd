package com.example.jobchoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorkerFinding_screen : AppCompatActivity() {
    lateinit var simpleAPI: SimpleAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_finding_screen)

        val add_btn = findViewById<View>(R.id.add_btn) as Button
        val jobTitle_edittxt = findViewById<View>(R.id.jobTitle_edittxt) as EditText
        val salary_edittxt = findViewById<View>(R.id.salary_edittxt) as EditText
        val requirement_edittxt = findViewById<View>(R.id.requirement_edittxt) as EditText

        val jobTitle_str = jobTitle_edittxt.text.toString()
        val salary_str = salary_edittxt.text.toString()
        val requirement_str = requirement_edittxt.text.toString()

        add_btn.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(jobTitle_edittxt.text.toString())) {
                Toast.makeText(
                    this@WorkerFinding_screen,
                    "Job Title cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(salary_edittxt.text.toString())) {
                Toast.makeText(
                    this@WorkerFinding_screen,
                    "Salary cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(requirement_edittxt.text.toString())) {
                Toast.makeText(
                    this@WorkerFinding_screen,
                    "Requirement cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            Add(jobTitle_str,salary_str,requirement_str)
        })
    }
    private fun Add(jobTitle : String, salary : String , requirement : String){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        Toast.makeText(this, "ADD", Toast.LENGTH_LONG).show()
        val intent = Intent(this,AfterLogin::class.java)
        startActivity(intent)
    }
}