package com.example.jobchoice

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.jobchoice.api.EditProfileImage
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class changeprofilePopUp_screen : DialogFragment() {
    lateinit var image_view : ImageView
    lateinit var uploadImage_btn : Button
    lateinit var save_btn : Button
    lateinit var simpleAPI: SimpleAPI
    lateinit var uri : Uri
    var path = ""

    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_changeprofile_pop_up_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = this.arguments
        val email = args?.get("email")
        val email_str = email.toString()

        image_view = view.findViewById(R.id.image_view)
        uploadImage_btn= view.findViewById(R.id.uploadImage_btn)
        uploadImage_btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(intent, changeprofilePopUp_screen.IMAGE_REQUEST_CODE)
        }

        save_btn= view.findViewById(R.id.save_btn)
        save_btn.setOnClickListener{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://jobchoice-app.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            simpleAPI = retrofit.create(SimpleAPI::class.java)
            val post = EditProfileImage(path)
            val call = simpleAPI.editprofileimagepushPut(email_str,post)
            call.enqueue(object : Callback<EditProfileImage> {
                override fun onResponse(call: Call<EditProfileImage>, response: Response<EditProfileImage>) {
                    if(response.isSuccessful){
                        val intent = Intent(context,AfterLogin::class.java)
                        intent.putExtra("email",email_str)
                        startActivity(intent)
                    }else{ 1

                    }
                }

                override fun onFailure(call: Call<EditProfileImage>, t: Throwable) {
                }
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == changeprofilePopUp_screen.IMAGE_REQUEST_CODE && resultCode == AppCompatActivity.RESULT_OK){
            uri = data?.data!!
            path = RealPathUtil.getRealPath(context,uri)
            val bitmap = BitmapFactory.decodeFile(path)
            image_view.setImageBitmap(bitmap)
        }
    }
}