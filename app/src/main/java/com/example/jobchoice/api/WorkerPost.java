package com.example.jobchoice.api;

public class WorkerPost {
    private String jobTitle, salary,requirement;

    public WorkerPost(String jobTitle, String salary, String requirement){
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.requirement = requirement;
    }
    public String getJobTitle(){ return  jobTitle;}

    public String getSalary(){
        return salary;
    }

    public String getRequirement(){
        return requirement;
    }
}
