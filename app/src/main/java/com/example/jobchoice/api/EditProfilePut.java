package com.example.jobchoice.api;

public class EditProfilePut {
    private String old_email,firstname, lastname, email, password,contact;

    public EditProfilePut(String old_email,String firstname, String lastname, String email, String password,String contact){
        this.old_email = old_email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    public String getOld_email(){ return  old_email;}

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
