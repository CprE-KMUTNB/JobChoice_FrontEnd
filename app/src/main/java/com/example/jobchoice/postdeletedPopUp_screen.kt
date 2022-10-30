package com.example.jobchoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.jobchoice.api.SimpleAPI

class postdeletedPopUp_screen : DialogFragment() {

    lateinit var simpleAPI: SimpleAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v : View = inflater!!.inflate(R.layout.fragment_postdeleted_pop_up_screen, container, false)
        return  v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val okay_btn = view.findViewById(R.id.okay_btn) as Button
        val deletePost_checkbox = view.findViewById(R.id.deletePost_checkbox) as CheckBox


        okay_btn.setOnClickListener{
            val checkbox = deletePost_checkbox.isChecked
            if(checkbox){
                dismiss();
            }else{
                Toast.makeText(context, "Check box cannot be null", Toast.LENGTH_LONG).show()
            }
        }
    }

}