package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.jobchoice.api.LoginPost
import com.example.jobchoice.api.ProfileGet
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class profile_screen : Fragment() {
    lateinit var Edit_btn : Button
    lateinit var deleteAccount_btn : Button
    lateinit var firstname_txt: TextView
    lateinit var lastname_txt: TextView
    lateinit var email_txt: TextView
    lateinit var password_txt: TextView
    lateinit var aboutme_txt: TextView
    lateinit var simpleAPI: SimpleAPI
    lateinit var proflie : ProfileGet
    var email : String? = ""

    var profileEdit_screen = profileEdit_screen()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater!!.inflate(R.layout.activity_profile_screen,container,false)

        val args = this.arguments
        val email = args?.get("email")
        val email_str = email.toString()

        firstname_txt = v.findViewById(R.id.firstname_txt)
        lastname_txt = v.findViewById(R.id.lastname_txt)
        email_txt = v.findViewById(R.id.email_txt)
        password_txt = v.findViewById(R.id.password_txt)
        aboutme_txt = v.findViewById(R.id.aboutme_txt)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        val call = simpleAPI.profilepushGet(email_str)
        call.enqueue(object : Callback<ProfileGet> {
            override fun onResponse(call: Call<ProfileGet>, response: Response<ProfileGet>) {
                if(response.isSuccessful){
                    System.out.println(response.body())
                    proflie = response.body()!!
                    firstname_txt.setText(proflie.firstname)
                    lastname_txt.setText(proflie.lastname)
                    email_txt.setText(proflie.email)
                    password_txt.setText(proflie.password)
                    aboutme_txt.setText(proflie.aboutme)
                }else{

                }
            }

            override fun onFailure(call: Call<ProfileGet>, t: Throwable) {
            }
        })

        Edit_btn = v.findViewById(R.id.Edit_btn)
        deleteAccount_btn = v.findViewById(R.id.deleteAccount_btn)
        Edit_btn.setOnClickListener{
            EditProfile(email_str)
        }

        deleteAccount_btn.setOnClickListener{
            DeleteAccount(email_str)
        }
        return v;
    }
    private fun EditProfile(email : String){
        val intent = Intent(this@profile_screen.requireContext(),profileEdit_screen::class.java)
        intent.putExtra("email",email)
        startActivity(intent)
    }
    private fun DeleteAccount(email: String){
        val showPopUp = accountdeletedPopUp_screen()
        val bundle = Bundle()
        bundle.putString("email",email)
        showPopUp.arguments = bundle
        showPopUp.show((activity as AppCompatActivity).supportFragmentManager,"showPopUp")
    }
}