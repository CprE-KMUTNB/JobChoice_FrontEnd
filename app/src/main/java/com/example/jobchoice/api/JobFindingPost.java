package com.example.jobchoice.api;

public class JobFindingPost {
    private String user,JobTitle,ability,details,SalaryNeed,contact;

    public JobFindingPost(String user, String JobTitle, String ability, String details, String SalaryNeed,String contact){
        this.user = user;
        this.JobTitle = JobTitle;
        this.ability = ability;
        this.details = details;
        this.SalaryNeed = SalaryNeed;
        this.contact = contact;
    }

    public String getFullname(){ return user;}

    public String getJobTitle(){
        return JobTitle;
    }

    public String getAbility(){
        return ability;
    }

    public String getEducation(){
        return details;
    }

    public String getSalaryNeeded(){
        return SalaryNeed;
    }

    public String getContact(){
        return contact;
    }

}
