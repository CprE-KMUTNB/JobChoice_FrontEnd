package com.example.jobchoice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jobchoice.DeletePostPopup.workerpost_deletedPopUp_screen;

public class user_all_workerpost_detail_screen extends AppCompatActivity {
    TextView companyName_txtView, jobTitle_txtView, requirement_txtView, salary_txtView;
    Button deletePost_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_all_workerpost_detail_screen);

        ActionBar actionBar = getSupportActionBar();

        deletePost_btn = findViewById(R.id.deletePost_btn);
        companyName_txtView = findViewById(R.id.companyName_txtview);
        jobTitle_txtView = findViewById(R.id.jobTitle_txtview);
        requirement_txtView = findViewById(R.id.requirement_txtview);
        salary_txtView = findViewById(R.id.salary_txtview);

        Intent intent = getIntent();
        String email_str = intent.getStringExtra("email");
        String companyName_str = intent.getStringExtra("companyName");
        String jobTitle_str = intent.getStringExtra("jobTitle");
        String requirement_str = intent.getStringExtra("requirement");
        String salary_str = intent.getStringExtra("salary");

        actionBar.setTitle(companyName_str);
        companyName_txtView.setText(companyName_str);
        jobTitle_txtView.setText(jobTitle_str);
        requirement_txtView.setText(requirement_str);
        salary_txtView.setText(salary_str);

        deletePost_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workerpost_deletedPopUp_screen showPopUp = new workerpost_deletedPopUp_screen();
                Bundle bundle = new Bundle();
                bundle.putString("email",email_str);
                bundle.putString("user",companyName_str);
                bundle.putString("jobTitle",jobTitle_str);
                showPopUp.setArguments(bundle);
                showPopUp.show(user_all_workerpost_detail_screen.this.getSupportFragmentManager(), "showPopUp");
            }
        });


    }
}