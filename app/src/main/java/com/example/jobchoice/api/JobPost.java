package com.example.jobchoice.api;

public class JobPost {
    private String education, contact,expectedSalary,aboutme;

    public JobPost(String education, String contact, String expectedSalary,String aboutme){
        this.education = education;
        this.contact = contact;
        this.expectedSalary = expectedSalary;
        this.aboutme = aboutme;
    }
    public String getEducation(){ return  education;}

    public String getContact(){
        return contact;
    }

    public String getExpectedSalary(){ return expectedSalary;}

    public String getAboutme(){ return aboutme;}

}
