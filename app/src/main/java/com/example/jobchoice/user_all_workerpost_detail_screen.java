package com.example.jobchoice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jobchoice.DeletePostPopup.workerpost_deletedPopUp_screen;

public class user_all_workerpost_detail_screen extends AppCompatActivity {
    TextView companyName_txtview, jobTitle_txtview, requirement_txtview, salary_txtview,detail_txtview,contact_txtview;
    ImageView image_view;
    Button deletePost_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_all_workerpost_detail_screen);

        ActionBar actionBar = getSupportActionBar();

        deletePost_btn = findViewById(R.id.deletePost_btn);
        companyName_txtview = findViewById(R.id.companyName_txtview);
        jobTitle_txtview = findViewById(R.id.jobTitle_txtview);
        requirement_txtview = findViewById(R.id.requirement_txtview);
        salary_txtview = findViewById(R.id.salary_txtview);
        detail_txtview = findViewById(R.id.detail_txtview);
        contact_txtview = findViewById(R.id.contact_txtview);
        image_view = findViewById(R.id.image_view);

        Intent intent = getIntent();
        String email_str = intent.getStringExtra("email");
        String companyName_str = intent.getStringExtra("companyName");
        String jobTitle_str = intent.getStringExtra("jobTitle");
        String requirement_str = intent.getStringExtra("requirement");
        String salary_str = intent.getStringExtra("salary");
        String detail_str = intent.getStringExtra("detail");
        String contact_str = intent.getStringExtra("contact");
        String file_str = intent.getStringExtra("file");

        actionBar.setTitle(companyName_str);
        companyName_txtview.setText(companyName_str);
        jobTitle_txtview.setText(jobTitle_str);
        requirement_txtview.setText(requirement_str);
        salary_txtview.setText(salary_str);
        detail_txtview.setText(detail_str);
        contact_txtview.setText(contact_str);
        Bitmap bitmap = BitmapFactory.decodeFile(file_str);
        image_view.setImageBitmap(bitmap);

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