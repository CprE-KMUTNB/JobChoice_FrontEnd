package com.example.jobchoice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.jobchoice.api.JobFindingPost
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JobFinding_screen : AppCompatActivity() {
    private lateinit var fullname_edittxt:EditText
    private lateinit var jobTitle_edittxt:EditText
    private lateinit var ability_edittxt:EditText
    private lateinit var education_edittxt:EditText
    private lateinit var salaryNeeded_edittxt:EditText
    private lateinit var contact_edittxt:EditText

    lateinit var simpleAPI: SimpleAPI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_finding_screen)

        val add_btn = findViewById<View>(R.id.add_btn) as Button

        fullname_edittxt = findViewById<View>(R.id.fullname_edittxt) as EditText
        jobTitle_edittxt = findViewById<View>(R.id.jobTitle_edittxt) as EditText
        ability_edittxt = findViewById<View>(R.id.ability_edittxt) as EditText
        education_edittxt = findViewById<View>(R.id.education_edittxt) as EditText
        salaryNeeded_edittxt = findViewById<View>(R.id.salaryNeeded_edittxt) as EditText
        contact_edittxt = findViewById<View>(R.id.contact_edittxt) as EditText

        add_btn.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(fullname_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "Fullname cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(jobTitle_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "Job Title cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(ability_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "Ability cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(education_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "Education cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(salaryNeeded_edittxt.text.toString())) {
                Toast.makeText(
                    this@JobFinding_screen,
                    "Salary needed cannot be null or empty",
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
            Add(fullname_edittxt.text.toString(),
                jobTitle_edittxt.text.toString(),
                ability_edittxt.text.toString(),
                education_edittxt.text.toString(),
                salaryNeeded_edittxt.text.toString(),
                contact_edittxt.text.toString())
        })
    }
    private fun Add(fullname : String, jobTitle : String , ability : String, education : String, salaryNeeded : String, contact : String){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        val post = JobFindingPost(fullname,jobTitle,ability,education,salaryNeeded,contact)
        val call = simpleAPI.jobFindingpushPost(post)
        call.enqueue(object : Callback<JobFindingPost> {
            override fun onResponse(call: Call<JobFindingPost>, response: Response<JobFindingPost>) {
                if(response.isSuccessful){
                    System.out.println(response)
                    Toast.makeText(this@JobFinding_screen, "Add success", Toast.LENGTH_LONG).show()
                    intent = Intent(this@JobFinding_screen,AfterLogin::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@JobFinding_screen, "Cannot add", Toast.LENGTH_LONG).show()

                }
            }
            override fun onFailure(call: Call<JobFindingPost>, t: Throwable) {
            }
        })
    }

}