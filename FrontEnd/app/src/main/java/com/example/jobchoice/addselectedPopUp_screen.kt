package com.example.jobchoice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class addselectedPopUp_screen : DialogFragment() {

    lateinit var okay_btn : Button
    lateinit var checkbox1 : CheckBox
    lateinit var checkbox2 : CheckBox
    var checkboxID1 = false
    var checkboxID2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addselected_pop_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkbox1 = view.findViewById(R.id.findingJob_checkbox)
        checkbox2 = view.findViewById(R.id.findingWorker_checkbox)

        okay_btn= view.findViewById(R.id.okay_btn)
        okay_btn.setOnClickListener{
            checkboxID1 = checkbox1.isChecked
            checkboxID2 = checkbox2.isChecked
            if (checkboxID1 && checkboxID2){
                Toast.makeText(context, "Cannot Selected more than 1.", Toast.LENGTH_SHORT).show();
            }else if(checkboxID1){
                val intent = Intent(context, AddFindingJob_screen::class.java)
                startActivity(intent)
            }else if(checkboxID2){
                val intent = Intent(context, AddFindingWorker_screen::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(context, "Check box cannot be null.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}