package com.example.jobchoice.SearchModel;

import java.util.Comparator;

public class Model {
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

    public static final Comparator<Model> By_TITLE_ASCENDING = new Comparator<Model>() {
        @Override
        public int compare(Model model1, Model model2) {
            return model1.getCompanyName().compareTo(model2.getCompanyName());
        }
    };

    public static final Comparator<Model> By_TITLE_DESCENDING = new Comparator<Model>() {
        @Override
        public int compare(Model model1, Model model2) {
            return model2.getCompanyName().compareTo(model1.getCompanyName());
        }
    };


}
