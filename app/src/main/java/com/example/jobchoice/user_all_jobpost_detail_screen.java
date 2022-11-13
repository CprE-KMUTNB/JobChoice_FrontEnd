package com.example.jobchoice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jobchoice.DeletePostPopup.jobpost_deletedPopUp_screen;
import com.example.jobchoice.DeletePostPopup.workerpost_deletedPopUp_screen;

public class user_all_jobpost_detail_screen extends AppCompatActivity {
    TextView fullname_txtview, jobTitle_txtview, education_txtview, ability_txtview,salaryNeed_txtview,contact_txtview;
    ImageView image_view;
    Button deletePost_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_all_jobpost_detail_screen);

        ActionBar actionBar = getSupportActionBar();

        deletePost_btn = findViewById(R.id.deletePost_btn);
        fullname_txtview = findViewById(R.id.fullname_txtview);
        jobTitle_txtview = findViewById(R.id.jobTitle_txtview);
        education_txtview = findViewById(R.id.education_txtview);
        ability_txtview = findViewById(R.id.ability_txtview);
        salaryNeed_txtview = findViewById(R.id.salaryNeed_txtview);
        contact_txtview = findViewById(R.id.contact_txtview);
        image_view = findViewById(R.id.image_view);

        Intent intent = getIntent();
        String email_str = intent.getStringExtra("email");
        String fullname_str = intent.getStringExtra("companyName");
        String jobTitle_str = intent.getStringExtra("jobTitle");
        String education_str = intent.getStringExtra("requirement");
        String ability_str = intent.getStringExtra("ability");
        String salaryNeed_str = intent.getStringExtra("salaryNeed");
        String contact_str = intent.getStringExtra("contact");
        String file_str = intent.getStringExtra("file");

        actionBar.setTitle(fullname_str);
        fullname_txtview.setText(fullname_str);
        jobTitle_txtview.setText(jobTitle_str);
        education_txtview.setText(education_str);
        ability_txtview.setText(ability_str);
        salaryNeed_txtview.setText(salaryNeed_str);
        contact_txtview.setText(contact_str);

        Bitmap bitmap = BitmapFactory.decodeFile(file_str);
        image_view.setImageBitmap(bitmap);

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