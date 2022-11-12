package com.example.jobchoice.api;

public class ProfileGet {
    private String firstname, lastname, email, password,aboutme,file;

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

    public String getAboutme() {return aboutme;}

    public String getFile() {return file;}

    public void setFirstname(String firstname){ this.firstname = firstname;}

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setAboutme(String aboutme){
        this.aboutme = aboutme;
    }

    public void setFile(String file) { this.file = file; }

}
