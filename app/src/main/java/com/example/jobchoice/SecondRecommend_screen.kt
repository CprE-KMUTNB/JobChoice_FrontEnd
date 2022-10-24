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

class SecondRecommend_screen : AppCompatActivity() {
    lateinit var location_btn: Button
    lateinit var location_txt: TextView
    lateinit var companyName_txt: TextView
    lateinit var jobtitles_txt: TextView
    lateinit var requirement_txt: TextView
    lateinit var salary_txt: TextView
    lateinit var contact_txt: TextView
    lateinit var imageView: ImageView
    var value = arrayOf(
        "Central Ladprao",
        "No. 1691, Phaholyothin Road, Chatuchak, Chatuchak, Bangkok 10900",
        "- Cashier\n- Electrical and building maintenance technician\n- Loss prevention officer\n- Part time employee",
        "- High school qualification or above\n- Able to work in shifts",
        "Undefined",
        "065-929-0487 (Arm)\nLINE : 0659290487",
        "Central Ladprao"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_recommend_screen)
        location_btn = findViewById(R.id.location_btn)
        imageView = findViewById(R.id.image)
        companyName_txt = findViewById(R.id.company_name_field)
        location_txt = findViewById(R.id.location_txt)
        jobtitles_txt = findViewById(R.id.jobTitles_txt)
        requirement_txt = findViewById(R.id.requirement_txt)
        salary_txt = findViewById(R.id.salary_txt)
        contact_txt = findViewById(R.id.contact_txt)
        imageView.setImageResource(R.drawable.central_staff)
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
        intent.putExtra("CASE", 2)
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