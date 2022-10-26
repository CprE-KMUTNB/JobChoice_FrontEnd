package com.example.jobchoice.api;

public class EditProfilePut {
    private String firstname, lastname, email, password,aboutme;

    public EditProfilePut(String aboutme, String email, String firstname, String lastname, String password){
        this.aboutme = aboutme;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public String getAboume(){
        return aboutme;
    }

    public String getEmail(){ return email;}

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getPassword(){
        return password;
    }

}
