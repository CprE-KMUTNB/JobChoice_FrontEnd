package com.example.jobchoice.api;

public class Post {
    private String email, password;

    public Post(String email, String password){
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
