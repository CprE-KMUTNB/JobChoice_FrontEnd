package com.example.jobchoice.api;

public class JobFindingSearchBox {
    private String email,user,JobTitle,ability,details,SalaryNeed,contact,file;

    public JobFindingSearchBox(String email, String user, String JobTitle, String ability, String details, String SalaryNeed,String contact,String file){
        this.email = email;
        this.user = user;
        this.JobTitle = JobTitle;
        this.ability = ability;
        this.details = details;
        this.SalaryNeed = SalaryNeed;
        this.contact = contact;
        this.file = file;
    }
    public String getEmail(){ return email;}

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

    public String getFile(){
        return file;
    }

}
