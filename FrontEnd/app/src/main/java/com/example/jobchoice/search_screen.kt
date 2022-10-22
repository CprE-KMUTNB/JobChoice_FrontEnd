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

class search_screen : Fragment() {

    lateinit var add_btn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater!!.inflate(R.layout.activity_search_screen,container,false)
        add_btn = v.findViewById(R.id.add_btn)
        add_btn.setOnClickListener {
            val showPopUp = addselectedPopUp_screen()
            showPopUp.show((activity as AppCompatActivity).supportFragmentManager,"showPopUp")
        }
        return v;
    }

}