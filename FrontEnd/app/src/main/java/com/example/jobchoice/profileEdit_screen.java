package com.example.jobchoice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profileEdit_screen extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fragmentManager;
    Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit_screen);

        save_btn = findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save();
            }
        });
    }
    private void  Save(){
        EditText fullname_edittxt = findViewById(R.id.fullname_edittxt);
        EditText phone_edittxt = findViewById(R.id.phone_edittxt);
        EditText email_edittxt = findViewById(R.id.email_edittxt);
        EditText education_edittxt = findViewById(R.id.education_edittxt);
        EditText aboutme_edittxt = findViewById(R.id.aboutme_edittxt);

        Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AfterLogin.class);
        startActivity(intent);
    }
}