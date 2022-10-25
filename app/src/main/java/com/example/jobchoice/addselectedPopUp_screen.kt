package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class addselectedPopUp_screen : DialogFragment() {

    lateinit var okay_btn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addselected_pop_up_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val okay_btn = view.findViewById(R.id.okay_btn) as Button
        val jobFinding_checkbox = view.findViewById(R.id.jobFinding_checkbox) as CheckBox
        val workerFinding_checkbox = view.findViewById(R.id.workerFinding_checkbox) as CheckBox

        okay_btn.setOnClickListener{
            val checkbox1 = jobFinding_checkbox.isChecked
            val checkbox2 = workerFinding_checkbox.isChecked
            if (checkbox1 && checkbox2){
                Toast.makeText(context, "Check box cannot selected more than 1", Toast.LENGTH_LONG).show()
            }else if(checkbox1){
                Toast.makeText(context, "Select Job Finding", Toast.LENGTH_LONG).show()
                val intent = Intent(context,JobFinding_screen::class.java)
                startActivity(intent)
            }else if(checkbox2){
                Toast.makeText(context, "Select Worker Finding", Toast.LENGTH_LONG).show()
                val intent = Intent(context,WorkerFinding_screen::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(context, "Check box cannot be null", Toast.LENGTH_LONG).show()
            }
        }
    }

}