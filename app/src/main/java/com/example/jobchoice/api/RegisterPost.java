package com.example.jobchoice.api;

public class RegisterPost {
    private String email,password, firstname, lastname,aboutme,file;

    public RegisterPost(String email, String password ,String firstname, String lastname,String aboutme,String file){
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.aboutme = aboutme;
        this.file = file;
    }

    public String getUsername(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public String getContact(){
        return aboutme;
    }

    public String getFile(){
        return file;
    }

}
