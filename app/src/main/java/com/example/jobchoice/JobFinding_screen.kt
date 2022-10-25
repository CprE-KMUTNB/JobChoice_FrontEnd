package com.example.jobchoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JobFinding_screen : AppCompatActivity() {
    lateinit var simpleAPI: SimpleAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_finding_screen)

        val add_btn = findViewById<View>(R.id.add_btn) as Button
        val education_edittxt = findViewById<View>(R.id.education_edittxt) as EditText
        val contact_edittxt = findViewById<View>(R.id.contact_edittxt) as EditText
        val expectedSalary_edittxt = findViewById<View>(R.id.expectedSalary_edittxt) as EditText
        val aboutme_edittxt = findViewById<View>(R.id.aboutme_edittxt) as EditText

        val education_str = education_edittxt.text.toString()
        val contact_str = contact_edittxt.text.toString()
        val expectedSalary_str = expectedSalary_edittxt.text.toString()
        val aboutme_str = aboutme_edittxt.text.toString()

        add_btn.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(education_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "Education cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(contact_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "Contact cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(expectedSalary_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "Expected Salary cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(aboutme_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "About me cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            Add(education_str,contact_str,expectedSalary_str,aboutme_str)
        })
    }
    private fun Add(education : String, contact : String , expectedSalary : String, aboutme : String){
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