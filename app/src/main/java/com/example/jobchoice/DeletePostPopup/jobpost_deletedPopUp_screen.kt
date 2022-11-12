package com.example.jobchoice.DeletePostPopup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.jobchoice.AfterLogin
import com.example.jobchoice.MainActivity
import com.example.jobchoice.R
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class jobpost_deletedPopUp_screen : DialogFragment() {

    lateinit var simpleAPI: SimpleAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater!!.inflate(R.layout.fragment_jobpost_deleted_pop_up_screen, container, false)
        return  v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val okay_btn = view.findViewById(R.id.okay_btn) as Button
        val deletePost_checkbox = view.findViewById(R.id.deletePost_checkbox) as CheckBox

        val args = this.arguments
        val email = args?.get("email")
        val email_str = email.toString()

        val user = args?.get("user")
        val user_str = user.toString()

        val jobTitle = args?.get("jobTitle")
        val jobTitle_str = jobTitle.toString()
        System.out.println("Email : " + email_str + " User : " + user_str + " JobTitle : " + jobTitle_str)

        okay_btn.setOnClickListener{
            val checkbox = deletePost_checkbox.isChecked
            if(checkbox){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jobchoice-app.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                simpleAPI = retrofit.create(SimpleAPI::class.java)
                val call = simpleAPI.userjobpostDelete(email_str,user_str,jobTitle_str)
                call.enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Toast.makeText(context, "Your post has been deleted.", Toast.LENGTH_LONG).show()
                            System.out.println(response)
                            val intent = Intent(context, AfterLogin::class.java)
                            intent.putExtra("email",email_str);
                            startActivity(intent)
                        } else {
                            Toast.makeText(context, "Delete Failed", Toast.LENGTH_LONG).show()

                        }
                    }
                    override fun onFailure(call: Call<Void>, t: Throwable) {
                    }
                })
            }else{
                Toast.makeText(context, "Check box cannot be null", Toast.LENGTH_LONG).show()
            }
        }
    }

}