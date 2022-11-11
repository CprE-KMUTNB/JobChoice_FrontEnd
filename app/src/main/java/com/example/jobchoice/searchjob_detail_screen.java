package com.example.jobchoice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class searchjob_detail_screen extends AppCompatActivity {
    TextView fullname_txtView, jobTitle_txtView, education_txtView, ability_txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchjob_detail_screen);

        ActionBar actionBar = getSupportActionBar();

        fullname_txtView = findViewById(R.id.fullname_txtview);
        jobTitle_txtView = findViewById(R.id.jobTitle_txtview);
        education_txtView = findViewById(R.id.education_txtview);
        ability_txtView = findViewById(R.id.ability_txtview);

        Intent intent = getIntent();
        String fullname_str = intent.getStringExtra("fullname");
        String jobTitle_str = intent.getStringExtra("jobTitle");
        String education_str = intent.getStringExtra("education");
        String ability_str = intent.getStringExtra("ability");

        actionBar.setTitle(fullname_str);
        fullname_txtView.setText(fullname_str);
        jobTitle_txtView.setText(jobTitle_str);
        education_txtView.setText(education_str);
        ability_txtView.setText(ability_str);
    }
}