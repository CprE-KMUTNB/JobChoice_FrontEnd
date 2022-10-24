package com.example.jobchoice

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class ThirdRecommend_screen : AppCompatActivity() {
    lateinit var location_btn: Button
    lateinit var location_txt: TextView
    lateinit var companyName_txt: TextView
    lateinit var jobtitles_txt: TextView
    lateinit var requirement_txt: TextView
    lateinit var salary_txt: TextView
    lateinit var contact_txt: TextView
    lateinit var imageView: ImageView
    var value = arrayOf(
        "True Corporation Co., Ltd.",
        "18 Ratchadaphisek Road, HuaiKhwang, KhetHuaiKhwang, Bangkok 10310",
        "Sales area management and customer care officer",
        "- Male/Female\n- Age not over 35 years\n- M.6 - bachelor's degree\n- Interested in technology\n- Likes sales and service work",
        "18,000 - 20,000++ baht",
        "Facebook : True Careers",
        "18 Ratchadaphisek Road, HuaiKhwang, KhetHuaiKhwang, Bangkok 10310"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_recommend_screen)
        location_btn = findViewById(R.id.location_btn)
        imageView = findViewById(R.id.image)
        companyName_txt = findViewById(R.id.company_name_field)
        location_txt = findViewById(R.id.location_txt)
        jobtitles_txt = findViewById(R.id.jobTitles_txt)
        requirement_txt = findViewById(R.id.requirement_txt)
        salary_txt = findViewById(R.id.salary_txt)
        contact_txt = findViewById(R.id.contact_txt)
        imageView.setImageResource(R.drawable.true_staff)
        companyName_txt.setText(value[0])
        location_txt.setText(value[1])
        jobtitles_txt.setText(value[2])
        requirement_txt.setText(value[3])
        salary_txt.setText(value[4])
        contact_txt.setText(value[5])
        location_btn.setOnClickListener(View.OnClickListener {
            latLag
            openMap()
        })
    }

    private val latLag: Unit
        private get() {
            val geocoder = Geocoder(this)
            val addressList: List<Address>?
            try {
                addressList = geocoder.getFromLocationName(value[6], 1)
                if (addressList != null) {
                    latitude = addressList[0].latitude
                    longtitude = addressList[0].longitude
                } else {
                    Toast.makeText(this, "Cannot fine location", Toast.LENGTH_SHORT).show()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

    fun openMap() {
        val intent = Intent(this, recomMap_screen::class.java)
        intent.putExtra("CASE", 3)
        startActivity(intent)
    }

    fun ReturnLat(): Double {
        return latitude
    }

    fun ReturnLong(): Double {
        return longtitude
    }

    companion object {
        var latitude = 0.0
        var longtitude = 0.0
    }
}