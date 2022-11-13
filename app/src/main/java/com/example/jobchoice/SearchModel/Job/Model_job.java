package com.example.jobchoice.SearchModel.Job;

import java.util.Comparator;

public class Model_job {
    private String user,JobTitle,ability,details,salaryNeed,contact,file;

    public String getFullname(){
        return user;
    }

    public void setFullname(String user){
        this.user = user;
    }

    public String getJobTitle(){
        return JobTitle;
    }

    public void setJobTitle(String jobTitle){
        this.JobTitle = jobTitle;
    }


    public String getAbility(){ return ability; }

    public void setAbility(String ability){ this.ability = ability; }


    public String getDetails(){ return details; }

    public void setDetails(String details){ this.details = details; }

    public String getSalaryNeed(){ return salaryNeed; }

    public void setSalaryNeed(String salaryNeed){ this.salaryNeed = salaryNeed; }

    public String getContact(){ return contact; }

    public void setContact(String contact){ this.contact = contact; }

    public String getFile(){
        return file;
    }

    public void setFile(String file){
        this.file = file;
    }

    public static final Comparator<Model_job> By_TITLE_ASCENDING = new Comparator<Model_job>() {
        @Override
        public int compare(Model_job model1, Model_job model2) {
            return model1.getJobTitle().compareTo(model2.getJobTitle());
        }
    };

    public static final Comparator<Model_job> By_TITLE_DESCENDING = new Comparator<Model_job>() {
        @Override
        public int compare(Model_job model1, Model_job model2) {
            return model2.getJobTitle().compareTo(model1.getJobTitle());
        }
    };


}
