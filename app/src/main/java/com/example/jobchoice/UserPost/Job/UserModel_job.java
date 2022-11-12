package com.example.jobchoice.UserPost.Job;
import java.util.Comparator;

public class UserModel_job {
    private String email,user,JobTitle,ability,details;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

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

    public static final Comparator<UserModel_job> By_TITLE_ASCENDING = new Comparator<UserModel_job>() {
        @Override
        public int compare(UserModel_job model1, UserModel_job model2) {
            return model1.getJobTitle().compareTo(model2.getJobTitle());
        }
    };

    public static final Comparator<UserModel_job> By_TITLE_DESCENDING = new Comparator<UserModel_job>() {
        @Override
        public int compare(UserModel_job model1, UserModel_job model2) {
            return model2.getJobTitle().compareTo(model1.getJobTitle());
        }
    };


}