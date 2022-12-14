package com.example.jobchoice
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import nl.joery.animatedbottombar.AnimatedBottomBar

class AfterLogin : AppCompatActivity() {
    lateinit var fragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_afterlogin)
        val animatedBottomBar = findViewById<AnimatedBottomBar>(R.id.animatedBottomBar)

        val email = intent.getStringExtra("email")
        if (savedInstanceState == null) {
            animatedBottomBar.selectTabById(R.id.profile, true)
            fragmentManager = supportFragmentManager
            val profilescreen = profile_screen()
            val bundle = Bundle()
            bundle.putString("email",email)
            profilescreen.arguments = bundle
            fragmentManager.beginTransaction().replace(R.id.fragment_container, profilescreen)
                .commit()
        }
        animatedBottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(lastIndex: Int, lastTab: AnimatedBottomBar.Tab?, newIndex: Int, newTab: AnimatedBottomBar.Tab) {
                var fragment: Fragment? = null
                when (newTab.id) {
                    R.id.profile -> {
                        fragment = profile_screen()
                    }
                    R.id.searchworker -> {
                        fragment = searchworker_screen()
                    }
                    R.id.searchjob -> {
                        fragment = searchjob_screen()
                    }
                    R.id.recommend -> {
                        fragment = recommend_screen()
                    }
                    R.id.setting -> {
                        fragment = setting_screen()
                    }
                }
                if (fragment != null) {
                    fragmentManager = supportFragmentManager
                    val bundle = Bundle()
                    bundle.putString("email",email)
                    fragment.arguments = bundle
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                        .commit()
                }
            }

        })
    }
}