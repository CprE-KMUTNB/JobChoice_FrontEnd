package com.example.jobchoice.api;

public class WokerFindingSearchBox {
    private String user,JobTitle,requirement,Salary;

    public WokerFindingSearchBox(String user, String JobTitle, String requirement, String Salary){
        this.user = user;
        this.JobTitle = JobTitle;
        this.requirement = requirement;
        this.Salary = Salary;
    }


    public String getFullname(){ return user; }

    public String getJobTitle(){
        return JobTitle;
    }

    public String getRequirement(){
        return requirement;
    }

    public String getSalary(){
        return Salary;
    }

}
