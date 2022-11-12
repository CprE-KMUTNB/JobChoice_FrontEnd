package com.example.jobchoice.UserPost.Job;

import android.widget.Filter;

import java.util.ArrayList;

public class UserCustomFilterJob extends Filter {

    ArrayList<UserModel_job> userModel_jobs;
    UserAdapter_job userAdapter_job;

    public UserCustomFilterJob(ArrayList<UserModel_job> filterList, UserAdapter_job userAdapter_job) {
        this.userModel_jobs = filterList;
        this.userAdapter_job = userAdapter_job;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        if(charSequence != null && charSequence.length() > 0){
            charSequence = charSequence.toString().toUpperCase();
            ArrayList<UserModel_job> filterModels = new ArrayList<>();
            for(int i = 0; i < userModel_jobs.size(); i++){
                if(userModel_jobs.get(i).getJobTitle().toUpperCase().contains(charSequence)){
                    filterModels.add(userModel_jobs.get(i));
                }
            }
            results.count = filterModels.size();
            results.values = filterModels;
        }
        else{
            results.count = userModel_jobs.size();
            results.values = userModel_jobs;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        userAdapter_job.userModel_jobs = (ArrayList<UserModel_job>) filterResults.values;
        userAdapter_job.notifyDataSetChanged();
    }
}