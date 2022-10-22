package com.example.jobchoice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class recommend_screen : Fragment() {

    lateinit var image_1btn : Button
    lateinit var image_2btn : Button
    lateinit var image_3btn : Button
    lateinit var image_4btn : Button
    lateinit var image_5btn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v : View = inflater!!.inflate(R.layout.activity_recommend_screen,container,false)
        image_1btn = v.findViewById(R.id.image_1btn)
        image_1btn.setOnClickListener{
            val intent = Intent(this@recommend_screen.requireContext(),FirstRecommend_screen::class.java)
            startActivity(intent)
        }

        image_2btn = v.findViewById(R.id.image_2btn)
        image_2btn.setOnClickListener{
            val intent = Intent(this@recommend_screen.requireContext(),SecondRecommend_screen::class.java)
            startActivity(intent)
        }

        image_3btn = v.findViewById(R.id.image_3btn)
        image_3btn.setOnClickListener{
            val intent = Intent(this@recommend_screen.requireContext(),ThirdRecommend_screen::class.java)
            startActivity(intent)
        }

        image_4btn = v.findViewById(R.id.image_4btn)
        image_4btn.setOnClickListener{
            val intent = Intent(this@recommend_screen.requireContext(),FourthRecommend_screen::class.java)
            startActivity(intent)
        }

        image_5btn = v.findViewById(R.id.image_5btn)
        image_5btn.setOnClickListener{
            val intent = Intent(this@recommend_screen.requireContext(),FifthRecommend_screen::class.java)
            startActivity(intent)
        }
        return v
    }
}