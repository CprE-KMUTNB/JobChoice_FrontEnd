package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class accountdeletedPopUp_screen : DialogFragment() {

    lateinit var simpleAPI: SimpleAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater!!.inflate(R.layout.fragment_accountdeleted_pop_up_screen, container, false)
        return  v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val okay_btn = view.findViewById(R.id.okay_btn) as Button
        val deleteAccount_checkbox = view.findViewById(R.id.deleteAccount_checkbox) as CheckBox

        val args = this.arguments
        val email = args?.get("email")
        val email_str = email.toString()

        okay_btn.setOnClickListener{
            val checkbox = deleteAccount_checkbox.isChecked
            if(checkbox){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jobchoice-app.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                simpleAPI = retrofit.create(SimpleAPI::class.java)
                val call = simpleAPI.userpushDelete(email_str)
                call.enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            Toast.makeText(context, "Your account has been deleted.", Toast.LENGTH_LONG).show()
                            System.out.println(response)
                            val intent = Intent(context,MainActivity::class.java)
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