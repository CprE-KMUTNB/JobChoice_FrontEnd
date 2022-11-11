package com.example.jobchoice.SearchModel.Worker;

import java.util.Comparator;

public class Model_worker {
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

    public static final Comparator<Model_worker> By_TITLE_ASCENDING = new Comparator<Model_worker>() {
        @Override
        public int compare(Model_worker model_worker1, Model_worker model_worker2) {
            return model_worker1.getCompanyName().compareTo(model_worker2.getCompanyName());
        }
    };

    public static final Comparator<Model_worker> By_TITLE_DESCENDING = new Comparator<Model_worker>() {
        @Override
        public int compare(Model_worker model_worker1, Model_worker model_worker2) {
            return model_worker1.getCompanyName().compareTo(model_worker2.getCompanyName());
        }
    };


}
