package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.jobchoice.api.LoginPost
import com.example.jobchoice.api.SimpleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class profile_screen : Fragment() {
    lateinit var Edit_btn : Button
    lateinit var firstname_txt: TextView
    lateinit var lastname_txt: TextView
    lateinit var email_txt: TextView
    lateinit var password_txt: TextView
    lateinit var contact_txt: TextView
    lateinit var simpleAPI: SimpleAPI


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

        firstname_txt = v.findViewById(R.id.firstname_txt)
        lastname_txt = v.findViewById(R.id.lastname_txt)
        email_txt = v.findViewById(R.id.email_txt)
        password_txt = v.findViewById(R.id.password_txt)
        contact_txt = v.findViewById(R.id.contact_txt)

        val email = arguments?.getString("email")

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        /*val post = LoginPost(email)
        val call = simpleAPI.loginpushPost(post)
        call.enqueue(object : Callback<LoginPost> {
            override fun onResponse(call: Call<LoginPost>, response: Response<LoginPost>) {
                if(response.isSuccessful){
                }else{
                }
            }

            override fun onFailure(call: Call<LoginPost>, t: Throwable) {
            }
        })*/

        Edit_btn = v.findViewById(R.id.Edit_btn)
        Edit_btn.setOnClickListener{
            EditProfile(email)
        }
        return v;
    }
    private fun EditProfile(email : String?){
        val intent = Intent(this@profile_screen.requireContext(),profileEdit_screen::class.java)
        intent.putExtra("email",email)
        startActivity(intent)
    }
}