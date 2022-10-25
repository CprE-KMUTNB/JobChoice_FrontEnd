package com.example.jobchoice.api;

public class ProfileGet {
    private String firstname, lastname, email, password,contact;

    public ProfileGet(String firstname, String lastname, String email, String password,String contact){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getContact(){
        return contact;
    }
}
