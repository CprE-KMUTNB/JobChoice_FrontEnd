
package com.example.jobchoice.UserPost.Worker;
import java.util.Comparator;

public class UserModel_worker {
    private String email,companyName, jobTitle, requirement,salary,detail,contact,file;

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

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

    public String getFile(){
        return file;
    }

    public void setFile(String file){
        this.file = file;
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

    public String getDetail(){
        return detail;
    }

    public void setDetail(String detail){
        this.detail = detail;
    }

    public String getContact(){
        return contact;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public static final Comparator<UserModel_worker> By_TITLE_ASCENDING = new Comparator<UserModel_worker>() {
        @Override
        public int compare(UserModel_worker model1, UserModel_worker model2) {
            return model1.getCompanyName().compareTo(model2.getCompanyName());
        }
    };

    public static final Comparator<UserModel_worker> By_TITLE_DESCENDING = new Comparator<UserModel_worker>() {
        @Override
        public int compare(UserModel_worker model1, UserModel_worker model2) {
            return model2.getCompanyName().compareTo(model1.getCompanyName());
        }
    };


}