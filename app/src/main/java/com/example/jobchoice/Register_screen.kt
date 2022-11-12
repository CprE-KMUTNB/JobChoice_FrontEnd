package com.example.jobchoice

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.jobchoice.api.RegisterPost
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Register_screen : AppCompatActivity() {
    private lateinit var image_view: ImageView;
    private lateinit var email_edittxt:EditText
    private lateinit var password_edittxt:EditText
    private lateinit var firstname_edittxt:EditText
    private lateinit var lastname_edittxt:EditText
    private lateinit var aboutme_edittxt:EditText
    private lateinit var register_btn: Button
    lateinit var simpleAPI: SimpleAPI
    lateinit var uri : Uri
    lateinit var path: String

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        val uploadImage_btn = findViewById<View>(R.id.uploadImage_btn) as Button

        image_view = findViewById<View>(R.id.image_view) as ImageView
        email_edittxt = findViewById<View>(R.id.email_edittxt) as EditText
        password_edittxt = findViewById<View>(R.id.password_edittxt) as EditText
        firstname_edittxt = findViewById<View>(R.id.firstname_edittxt) as EditText
        lastname_edittxt = findViewById<View>(R.id.lastname_edittxt) as EditText
        aboutme_edittxt = findViewById<View>(R.id.aboutme_edittxt) as EditText

        uploadImage_btn.setOnClickListener(View.OnClickListener {
            if(ContextCompat.checkSelfPermission(applicationContext,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                intent.setAction(Intent.ACTION_GET_CONTENT)
                startActivityForResult(intent, Register_screen.IMAGE_REQUEST_CODE)
            }else{
                ActivityCompat.requestPermissions(
                    this, arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ), 1
                )
            }
        })

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
            if (TextUtils.isEmpty(aboutme_edittxt.text.toString())) {
                Toast.makeText(
                    this@Register_screen,
                    "About me cannot be null or empty",
                    Toast.LENGTH_LONG
                ).show()
                return@OnClickListener
            }
            Register(
                email_edittxt.text.toString(),
                password_edittxt.text.toString(),
                firstname_edittxt.text.toString(),
                lastname_edittxt.text.toString(),
                aboutme_edittxt.text.toString()
            )
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == Register_screen.IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            uri = data?.data!!
            path = RealPathUtil.getRealPath(this,uri)
            val bitmap: Bitmap = BitmapFactory.decodeFile(path)
            image_view.setImageBitmap(bitmap)
        }
    }

    private fun Register(email: String, password: String,firstname : String, lastname : String, aboutme : String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        val post = RegisterPost(email, password, firstname, lastname, aboutme,path)
        val call = simpleAPI.registerpushPost(post)
        call.enqueue(object : Callback<RegisterPost> {
            override fun onResponse(call: Call<RegisterPost>, response: Response<RegisterPost>) {
                if(response.isSuccessful){
                    System.out.println(response)
                    Toast.makeText(this@Register_screen, "Register Success", Toast.LENGTH_LONG).show()
                    intent = Intent(this@Register_screen,MainActivity::class.java)
                    startActivity(intent)
                }else{
                    System.out.println(response)
                    Toast.makeText(this@Register_screen, "Cannot create user", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterPost>, t: Throwable) {
            }
        })
    }
}
