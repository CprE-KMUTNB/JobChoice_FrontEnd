package com.example.jobchoice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class search_more_screen extends AppCompatActivity {
    TextView companyName_txtView, jobTitle_txtView, requirement_txtView, salary_txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_more_screen);

        ActionBar actionBar = getSupportActionBar();

        companyName_txtView = findViewById(R.id.companyName_txtview);
        jobTitle_txtView = findViewById(R.id.jobTitle_txtview);
        requirement_txtView = findViewById(R.id.requirement_txtview);
        salary_txtView = findViewById(R.id.salary_txtview);

        Intent intent = getIntent();
        String companyName_str = intent.getStringExtra("companyName");
        String jobTitle_str = intent.getStringExtra("jobTitle");
        String requirement_str = intent.getStringExtra("requirement");
        String salary_str = intent.getStringExtra("salary");

        actionBar.setTitle(companyName_str);
        companyName_txtView.setText(companyName_str);
        jobTitle_txtView.setText(jobTitle_str);
        requirement_txtView.setText(requirement_str);
        salary_txtView.setText(salary_str);
    }
}