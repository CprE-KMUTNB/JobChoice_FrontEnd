package com.example.jobchoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.jobchoice.api.ProfileGet
import com.example.jobchoice.api.SimpleAPI
import com.example.jobchoice.api.WokerFindingSearchBox
import com.example.jobchoice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class search_screen : Fragment() {
    lateinit var simpleAPI: SimpleAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.activity_search_screen, container, false)
        val args = this.arguments
        val email = args?.get("email")
        val email_str = email.toString()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jobchoice-app.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        simpleAPI = retrofit.create(SimpleAPI::class.java)
        val call = simpleAPI.workerfindingsearchGet()
        call.enqueue(object : Callback<WokerFindingSearchBox> {
            override fun onResponse(call: Call<WokerFindingSearchBox>, response: Response<WokerFindingSearchBox>) {
                if(response.isSuccessful){
                    System.out.println(response.body())

                }else{

                }
            }

            override fun onFailure(call: Call<WokerFindingSearchBox>, t: Throwable) {
            }
        })



        val add_btn =  v.findViewById(R.id.add_btn) as Button
        add_btn.setOnClickListener {
            val showPopUp = addselectedPopUp_screen()
            val bundle = Bundle()
            bundle.putString("email",email_str)
            showPopUp.arguments = bundle
            showPopUp.show((activity as AppCompatActivity).supportFragmentManager,"showPopUp")
        }
        return v
    }
}