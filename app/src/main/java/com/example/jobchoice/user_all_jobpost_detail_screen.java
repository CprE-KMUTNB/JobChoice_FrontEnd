package com.example.jobchoice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jobchoice.DeletePostPopup.jobpost_deletedPopUp_screen;
import com.example.jobchoice.DeletePostPopup.workerpost_deletedPopUp_screen;

public class user_all_jobpost_detail_screen extends AppCompatActivity {
    TextView fullname_txtView, jobTitle_txtView, education_txtView, ability_txtView;
    Button deletePost_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_all_jobpost_detail_screen);

        ActionBar actionBar = getSupportActionBar();

        deletePost_btn = findViewById(R.id.deletePost_btn);
        fullname_txtView = findViewById(R.id.fullname_txtview);
        jobTitle_txtView = findViewById(R.id.jobTitle_txtview);
        education_txtView = findViewById(R.id.education_txtview);
        ability_txtView = findViewById(R.id.ability_txtview);

        Intent intent = getIntent();
        String email_str = intent.getStringExtra("email");
        String fullname_str = intent.getStringExtra("companyName");
        String jobTitle_str = intent.getStringExtra("jobTitle");
        String education_str = intent.getStringExtra("requirement");
        String ability_str = intent.getStringExtra("salary");

        actionBar.setTitle(fullname_str);
        fullname_txtView.setText(fullname_str);
        jobTitle_txtView.setText(jobTitle_str);
        education_txtView.setText(education_str);
        ability_txtView.setText(ability_str);

        deletePost_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jobpost_deletedPopUp_screen showPopUp = new jobpost_deletedPopUp_screen();
                Bundle bundle = new Bundle();
                bundle.putString("email",email_str);
                bundle.putString("user",fullname_str);
                bundle.putString("jobTitle",jobTitle_str);
                showPopUp.setArguments(bundle);
                showPopUp.show(user_all_jobpost_detail_screen.this.getSupportFragmentManager(), "showPopUp");
            }
        });


    }
}