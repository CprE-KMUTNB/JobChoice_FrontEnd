package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jobchoice.network.repository.Repository

class MainActivity() : AppCompatActivity() {
    lateinit var email_edittxt: EditText
    lateinit var password_edittxt:EditText
    lateinit var login_btn: Button
    lateinit var register_btn:Button
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        email_edittxt = findViewById<View>(R.id.email_edittxt) as EditText
        password_edittxt = findViewById<View>(R.id.password_edittxt) as EditText
        login_btn = findViewById<View>(R.id.login_btn) as Button
        register_btn = findViewById<View>(R.id.register_btn) as Button

        login_btn.setOnClickListener {
            Login(
                email_edittxt.text.toString(),
                password_edittxt.text.toString()
            )

        }

        register_btn.setOnClickListener {
            intent = Intent(this,Register_screen::class.java)
            startActivity(intent)
        }
    }
    private fun Login(email: String, password: String) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email cannot be null or empty", Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password cannot be null or empty", Toast.LENGTH_LONG).show()
            return
        }

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.pushPost(email,password)
        viewModel.myResponse.observe(this, Observer { response ->
            System.out.println(response)
            if(response.isSuccessful){
                val intend = Intent(this, AfterLogin::class.java)
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(intend)
                Toast.makeText(this, response.message(), Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this, response.message(), Toast.LENGTH_SHORT).show()
            }
        })
}}