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
import com.example.jobchoice.api.EditProfilePut;
import com.example.jobchoice.api.LoginPost;
import com.example.jobchoice.api.SimpleAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class profileEdit_screen extends AppCompatActivity {

    EditText firstname_edittxt, lastname_edittxt, email_edittxt, password_edittxt,aboutme_edittxt;
    String firstname_str, lastname_str, email_str, password_str, aboutme_str;
    SimpleAPI simpleAPI;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit_screen);
        firstname_edittxt = findViewById(R.id.firstname_edittxt);
        lastname_edittxt = findViewById(R.id.lastname_edittxt);
        email_edittxt = findViewById(R.id.email_edittxt);
        password_edittxt = findViewById(R.id.password_edittxt);
        aboutme_edittxt = findViewById(R.id.aboutme_edittxt);

        firstname_str = firstname_edittxt.getText().toString();
        lastname_str = lastname_edittxt.getText().toString();
        email_str = email_edittxt.getText().toString();
        password_str = password_edittxt.getText().toString();
        aboutme_str = aboutme_edittxt.getText().toString();

        String old_email = getIntent().getStringExtra("email");

        save_btn = findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save(old_email,firstname_str,lastname_str,email_str,password_str,aboutme_str);
            }
        });
    }
    private void  Save(String id, String firstname, String lastname, String email, String password, String aboutme){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jobchoice-app.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        simpleAPI = retrofit.create(SimpleAPI.class);
        EditProfilePut post = new EditProfilePut(firstname,lastname,email,password,aboutme);
        Call call = simpleAPI.editprofilepushPut("6358196e1be06c5db40e0cce",post);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    SaveSuccess();
                }else{
                    SaveFailure();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
    private void SaveFailure(){
        Toast.makeText(this, "SAVED FAIL", Toast.LENGTH_SHORT).show();
    }

    private void SaveSuccess(){
        Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AfterLogin.class);
        startActivity(intent);
    }

}