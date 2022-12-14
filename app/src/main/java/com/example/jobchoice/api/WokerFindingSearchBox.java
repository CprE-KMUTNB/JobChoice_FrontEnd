package com.example.jobchoice.api;

public class WokerFindingSearchBox {
    private String email,user,JobTitle,requirement,details,Salary,contact,file;

    public WokerFindingSearchBox(String email,String user, String JobTitle, String requirement, String details, String Salary,String contact,String file){
        this.email = email;
        this.user = user;
        this.JobTitle = JobTitle;
        this.requirement = requirement;
        this.details = details;
        this.Salary = Salary;
        this.contact = contact;
        this.file = file;
    }
    public String getEmail(){
        return email;
    }

    public String getUser(){
        return user;
    }

    public String getJobTitle(){
        return JobTitle;
    }

    public String getRequirement(){
        return requirement;
    }

    public String getDetails(){
        return details;
    }

    public String getSalary(){
        return Salary;
    }

    public String getContact(){
        return contact;
    }

    public String getFile(){
        return file;
    }

}
