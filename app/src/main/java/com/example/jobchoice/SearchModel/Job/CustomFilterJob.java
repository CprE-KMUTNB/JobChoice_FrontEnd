package com.example.jobchoice.SearchModel.Job;
import android.widget.Filter;
import java.util.ArrayList;

public class CustomFilterJob extends Filter {

    ArrayList<Model_job> model_jobs;
    MyAdapter_job myAdapter_job;

    public CustomFilterJob(ArrayList<Model_job> model_jobs, MyAdapter_job myAdapter_job) {
        this.model_jobs = model_jobs;
        this.myAdapter_job = myAdapter_job;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        if(charSequence != null && charSequence.length() > 0){
            charSequence = charSequence.toString().toUpperCase();
            ArrayList<Model_job> filterModels = new ArrayList<>();
            for(int i = 0; i < model_jobs.size(); i++){
                if(model_jobs.get(i).getJobTitle().toUpperCase().contains(charSequence)){
                    filterModels.add(model_jobs.get(i));
                }
            }
            results.count = filterModels.size();
            results.values = filterModels;
        }
        else{
            results.count = model_jobs.size();
            results.values = model_jobs;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        myAdapter_job.model_jobs = (ArrayList<Model_job>) filterResults.values;
        myAdapter_job.notifyDataSetChanged();
    }
}
