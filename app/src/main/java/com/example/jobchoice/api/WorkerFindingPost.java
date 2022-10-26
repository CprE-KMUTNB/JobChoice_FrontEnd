package com.example.jobchoice.api;

public class WorkerFindingPost {
    private String user,JobTitle,requirement,details,Salary,contact;

    public WorkerFindingPost(String user, String JobTitle, String requirement, String details, String Salary,String contact){
        this.user = user;
        this.JobTitle = JobTitle;
        this.requirement = requirement;
        this.details = details;
        this.Salary = Salary;
        this.contact = contact;
    }

    public String getFullname(){
        return user;
    }

    public String getJobTitle(){
        return JobTitle;
    }

    public String getRequirement(){
        return requirement;
    }

    public String getEducation(){
        return details;
    }

    public String getSalary(){
        return Salary;
    }

    public String getContact(){
        return contact;
    }
}
