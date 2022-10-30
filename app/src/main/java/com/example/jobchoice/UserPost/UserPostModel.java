package com.example.jobchoice.UserPost;
import java.util.Comparator;

public class UserPostModel {
    private String companyName, jobTitle, requirement,salary;

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }


    public String getRequirement(){
        return requirement;
    }

    public void setRequirement(String requirement){
        this.requirement = requirement;
    }


    public String getSalary(){
        return salary;
    }

    public void setSalary(String salary){
        this.salary = salary;
    }

    public static final Comparator<UserPostModel> By_TITLE_ASCENDING = new Comparator<UserPostModel>() {
        @Override
        public int compare(UserPostModel model1, UserPostModel model2) {
            return model1.getCompanyName().compareTo(model2.getCompanyName());
        }
    };

    public static final Comparator<UserPostModel> By_TITLE_DESCENDING = new Comparator<UserPostModel>() {
        @Override
        public int compare(UserPostModel model1, UserPostModel model2) {
            return model2.getCompanyName().compareTo(model1.getCompanyName());
        }
    };


}
