package com.example.jobchoice.api;

public class LoginPost {
    private String email, password;

    public LoginPost(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
