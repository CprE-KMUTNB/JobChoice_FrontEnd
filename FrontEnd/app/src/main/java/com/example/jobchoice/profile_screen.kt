package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class profile_screen : Fragment() {
    lateinit var Edit_btn : Button
    lateinit var fullname_txt: TextView
    lateinit var phone_txt: TextView
    lateinit var email_txt: TextView
    lateinit var education_txt: TextView
    lateinit var aboutme_txt: TextView

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

        fullname_txt = v.findViewById(R.id.fullname_txt)
        phone_txt = v.findViewById(R.id.phone_txt)
        email_txt = v.findViewById(R.id.email_txt)
        education_txt = v.findViewById(R.id.education_txt)
        aboutme_txt = v.findViewById(R.id.aboutme_txt)

        Edit_btn = v.findViewById(R.id.Edit_btn)
        Edit_btn.setOnClickListener{
            EditProfile()
        }
        return v;
    }
    private fun EditProfile(){
        val intent = Intent(this@profile_screen.requireContext(),profileEdit_screen::class.java)
        startActivity(intent)
    }
}