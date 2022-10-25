package com.example.jobchoice.api;

public class EditProfilePut {
    private String firstname, lastname, email, password,aboutme;

    public EditProfilePut(String firstname, String lastname, String email, String password,String aboutme){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.aboutme = aboutme;
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
        return aboutme;
    }

}
