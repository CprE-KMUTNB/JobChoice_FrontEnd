package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jobchoice.api.RegisterPost
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Register_screen : AppCompatActivity() {
    private lateinit var email_edittxt:EditText
    private lateinit var password_edittxt:EditText
    private lateinit var firstname_edittxt:EditText
    private lateinit var lastname_edittxt:EditText
    private lateinit var contact_edittxt:EditText
    private lateinit var register_btn: Button
    lateinit var simpleAPI: SimpleAPI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        email_edittxt = findViewById<View>(R.id.email_edittxt) as EditText
        password_edittxt = findViewById<View>(R.id.password_edittxt) as EditText
        firstname_edittxt = findViewById<View>(R.id.firstname_edittxt) as EditText
        lastname_edittxt = findViewById<View>(R.id.lastname_edittxt) as EditText
        contact_edittxt = findViewById<View>(R.id.contact_edittxt) as EditText

        register_btn = findViewById(R.id.register_btn)
        register_btn.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(email_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "Email cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(password_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "Password cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(firstname_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "First name cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(lastname_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "Last name cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            if (TextUtils.isEmpty(contact_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "Contact cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            Register(
                email_edittxt.text.toString(),
                password_edittxt.text.toString(),
                firstname_edittxt.text.toString(),
                lastname_edittxt.text.toString(),
                contact_edittxt.text.toString()
            )
        })
    }
    private fun Register(email: String, password: String,firstname : String, lastname : String, contact : String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        val post = RegisterPost(email, password, firstname, lastname, contact)
        val call = simpleAPI.registerpushPost(post)
        call.enqueue(object : Callback<RegisterPost> {
            override fun onResponse(call: Call<RegisterPost>, response: Response<RegisterPost>) {
                if(response.isSuccessful){
                    System.out.println(response)
                    RegisterSuccess();
                }else{
                    if(response.code() == 500){
                        CannotCreate()
                    }
                }
            }

            override fun onFailure(call: Call<RegisterPost>, t: Throwable) {
            }
        })
    }

    private fun CannotCreate(){
        Toast.makeText(this, "Cannot create user", Toast.LENGTH_LONG).show()
    }

    private fun RegisterSuccess(){
        Toast.makeText(this, "Register Success", Toast.LENGTH_LONG).show()
        intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
