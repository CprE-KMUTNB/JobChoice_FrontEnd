package com.example.jobchoice.api;

public class LoginPost {
    private String id,email, password;

    public LoginPost(String email, String password){
        this.email = email;
        this.password = password;
    }
    public String getID(){ return  id;}

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
}
