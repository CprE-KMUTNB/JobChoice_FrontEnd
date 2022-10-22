package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class setting_screen : Fragment() {

    lateinit var theme_btn : Button
    lateinit var language_btn : Button
    lateinit var support_btn : Button
    lateinit var about_btn : Button
    lateinit var logout_btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater!!.inflate(R.layout.activity_setting_screen,container,false)
        theme_btn = v.findViewById(R.id.theme_btn)
        language_btn = v.findViewById(R.id.language_btn)
        support_btn = v.findViewById(R.id.support_btn)
        about_btn = v.findViewById(R.id.about_btn)
        logout_btn = v.findViewById(R.id.logout_btn)

        theme_btn.setOnClickListener{
            val showPopUp = themePopUp_screen()
            showPopUp.show((activity as AppCompatActivity).supportFragmentManager,"showPopUp")
        }

        language_btn.setOnClickListener{
            val showPopUp = languagePopUp_screen()
            showPopUp.show((activity as AppCompatActivity).supportFragmentManager,"showPopUp")
        }

        support_btn.setOnClickListener{
            val showPopUp = supportPopUp_screen()
            showPopUp.show((activity as AppCompatActivity).supportFragmentManager,"showPopUp")
        }

        about_btn.setOnClickListener{
            val showPopUp = aboutPopUp_screen()
            showPopUp.show((activity as AppCompatActivity).supportFragmentManager,"showPopUp")
        }

        logout_btn.setOnClickListener{
            val intent = Intent(this@setting_screen.requireContext(),MainActivity::class.java)
            Toast.makeText(activity, "Log out Successful", Toast.LENGTH_SHORT).show();
            startActivity(intent)
        }

        return v;
    }

}