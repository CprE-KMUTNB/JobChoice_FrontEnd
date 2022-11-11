package com.example.jobchoice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.jobchoice.api.LoginPost
import com.example.jobchoice.api.SimpleAPI
import com.example.jobchoice.api.WorkerFindingPost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorkerFinding_screen : AppCompatActivity() {
    private lateinit var companyName_edittxt:EditText
    private lateinit var jobTitle_edittxt:EditText
    private lateinit var requirement_edittxt:EditText
    private lateinit var details_edittxt:EditText
    private lateinit var salary_edittxt:EditText
    private lateinit var contact_edittxt:EditText
    lateinit var simpleAPI: SimpleAPI
    private var selectedImage : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_finding_screen)

        val add_btn = findViewById<View>(R.id.add_btn) as Button
        val uploadImage_btn = findViewById<View>(R.id.uploadImage_btn) as Button

        companyName_edittxt = findViewById<View>(R.id.companyName_edittxt) as EditText
        jobTitle_edittxt = findViewById<View>(R.id.jobTitle_edittxt) as EditText
        requirement_edittxt = findViewById<View>(R.id.requirement_edittxt) as EditText
        details_edittxt = findViewById<View>(R.id.details_edittxt) as EditText
        salary_edittxt = findViewById<View>(R.id.salary_edittxt) as EditText
        contact_edittxt = findViewById<View>(R.id.contact_edittxt) as EditText

        val intent = getIntent()
        val email = intent.getStringExtra("email")
        val email_str = email.toString()

        uploadImage_btn.setOnClickListener(View.OnClickListener {
            uploadImage()
        })

        add_btn.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(companyName_edittxt.text.toString())) {
                Toast.makeText(
                    this@WorkerFinding_screen,
                    "Company name cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(jobTitle_edittxt.text.toString())) {
                Toast.makeText(
                    this@WorkerFinding_screen,
                    "Job title cannot be null or empty",
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
            if (TextUtils.isEmpty(details_edittxt.text.toString())) {
                Toast.makeText(
                    this@WorkerFinding_screen,
                    "Details cannot be null or empty",
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
            if (TextUtils.isEmpty(contact_edittxt.text.toString())) {
                Toast.makeText(
                    this@WorkerFinding_screen,
                    "Contact cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            Add(email_str,
                companyName_edittxt.text.toString(),
                jobTitle_edittxt.text.toString(),
                requirement_edittxt.text.toString(),
                details_edittxt.text.toString(),
                salary_edittxt.text.toString(),
                contact_edittxt.text.toString())
        })
    }
    private fun Add(email : String ,companyName : String ,jobTitle : String, requirement : String,details : String ,salary : String ,contact : String ){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        val post = WorkerFindingPost(email,companyName,jobTitle,requirement,details,salary,contact)
        val call = simpleAPI.workerFindingpushPost(post)
        call.enqueue(object : Callback<WorkerFindingPost> {
            override fun onResponse(call: Call<WorkerFindingPost>, response: Response<WorkerFindingPost>) {
                if(response.isSuccessful){
                    Toast.makeText(this@WorkerFinding_screen, "Add success", Toast.LENGTH_LONG).show()
                    intent = Intent(this@WorkerFinding_screen,AfterLogin::class.java)
                    intent.putExtra("email",email)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@WorkerFinding_screen, "Cannot add", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<WorkerFindingPost>, t: Throwable) {
            }
        })
    }

    private fun uploadImage(){
        if(selectedImage == null){
            return
        }
    }
}