package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register_screen : AppCompatActivity() {
    private lateinit var register_btn: Button
    private lateinit var username_edittxt: EditText
    private lateinit var firstname_edittxt:EditText
    private lateinit var lastname_edittxt:EditText
    private lateinit var email_edittxt:EditText
    private lateinit var contact_edittxt:EditText
    private lateinit var password_edittxt:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        firstname_edittxt = findViewById<View>(R.id.firstname_edittxt) as EditText
        lastname_edittxt = findViewById<View>(R.id.lastname_edittxt) as EditText
        email_edittxt = findViewById<View>(R.id.email_edittxt) as EditText
        contact_edittxt = findViewById<View>(R.id.contact_edittxt) as EditText
        password_edittxt = findViewById<View>(R.id.password_edittxt) as EditText
        register_btn = findViewById(R.id.register_btn)
        register_btn.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(username_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "Username cannot be null or empty",
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
            if (TextUtils.isEmpty(email_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "Username cannot be null or empty",
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
            if (TextUtils.isEmpty(password_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "Username cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            Register(
                username_edittxt.text.toString(),
                firstname_edittxt.text.toString(),
                lastname_edittxt.text.toString(),
                email_edittxt.text.toString(),
                contact_edittxt.text.toString(),
                password_edittxt.text.toString()
            )

        })
    }
    private fun Register(username: String, firstname : String, lastname : String,email: String, contact : String,password: String) {

        val intend = Intent(this, MainActivity::class.java)
        Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show();
        startActivity(intend)
    }

}
