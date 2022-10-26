package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.jobchoice.api.EditProfilePut
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class profileEdit_screen : AppCompatActivity() {
    lateinit var firstname_edittxt: EditText
    lateinit var lastname_edittxt: EditText
    lateinit var email_edittxt: EditText
    lateinit var password_edittxt: EditText
    lateinit var aboutme_edittxt: EditText
    lateinit var save_btn: Button
    lateinit var simpleAPI: SimpleAPI
    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_edit_screen)

        firstname_edittxt = findViewById<View>(R.id.firstname_edittxt) as EditText
        lastname_edittxt = findViewById(R.id.lastname_edittxt) as EditText
        email_edittxt = findViewById(R.id.email_edittxt) as EditText
        password_edittxt = findViewById(R.id.password_edittxt) as EditText
        aboutme_edittxt = findViewById(R.id.aboutme_edittxt) as EditText

        save_btn = findViewById(R.id.save_btn)
        save_btn.setOnClickListener(View.OnClickListener {
            Save(firstname_edittxt.getText().toString(),
                lastname_edittxt.getText().toString(),
                email_edittxt.getText().toString(),
                password_edittxt.getText().toString(),
                aboutme_edittxt.getText().toString()

            )
        })
    }

    private fun Save(firstname: String,lastname: String,email: String,password: String,aboutme: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        val post = EditProfilePut(aboutme,email,firstname, lastname, password)
        val call = simpleAPI.editprofilepushPut("63584d59066d890016d10a5e", post)
        call.enqueue(object : Callback<EditProfilePut> {
            override fun onResponse(call: Call<EditProfilePut>?, response: Response<EditProfilePut>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@profileEdit_screen, "SAVED", Toast.LENGTH_SHORT).show()
                    intent = Intent(this@profileEdit_screen,AfterLogin::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@profileEdit_screen, "SAVED FAIL", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<EditProfilePut>?, t: Throwable) {}
        })
    }
}