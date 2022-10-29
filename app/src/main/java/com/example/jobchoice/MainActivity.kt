package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jobchoice.api.LoginPost
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity() : AppCompatActivity() {
    lateinit var email_edittxt: EditText
    lateinit var password_edittxt:EditText
    lateinit var login_btn: Button
    lateinit var register_btn:Button
    lateinit var simpleAPI: SimpleAPI


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
    private fun Login(email: String, password: String){
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Email cannot be null or empty", Toast.LENGTH_LONG).show()
            return
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Password cannot be null or empty", Toast.LENGTH_LONG).show()
            return
        }
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        val post = LoginPost(email, password)
        val call = simpleAPI.loginpushPost(post)
        call.enqueue(object : Callback<LoginPost>{
            override fun onResponse(call: Call<LoginPost>, response: Response<LoginPost>) {
                if(response.isSuccessful){
                    System.out.println(response)
                    Toast.makeText(this@MainActivity, "Login.", Toast.LENGTH_LONG).show()
                    intent = Intent(this@MainActivity,AfterLogin::class.java)
                    intent.putExtra("email",email)
                    startActivity(intent)
                }else{
                    if(response.code() == 404){
                        Toast.makeText(this@MainActivity, "Email not found.", Toast.LENGTH_LONG).show()
                    }else if(response.code() == 400){
                        Toast.makeText(this@MainActivity, "Invalid password.", Toast.LENGTH_LONG).show()
                    }
                }
            }
            override fun onFailure(call: Call<LoginPost>, t: Throwable) {
            }
        })
}
}