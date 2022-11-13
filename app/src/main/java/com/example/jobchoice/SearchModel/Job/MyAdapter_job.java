package com.example.jobchoice.SearchModel.Job;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jobchoice.R;
import com.example.jobchoice.searchjob_detail_screen;

import java.util.ArrayList;

public class MyAdapter_job extends RecyclerView.Adapter<MyHolder_job> implements Filterable {
    Context c;
    ArrayList<Model_job> model_jobs, filterList;
    CustomFilterJob customFilterJob;

    public MyAdapter_job(Context c, ArrayList<Model_job> model_job){
        this.c = c;
        this.model_jobs = model_job;
        this.filterList = model_job;
    }

    @NonNull
    @Override
    public MyHolder_job onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.job_row_items,null);
        return new MyHolder_job(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder_job myHolder, int position) {
        myHolder.fullname_txtview.setText(model_jobs.get(position).getFullname());
        myHolder.jobTitle_txtview.setText(model_jobs.get(position).getJobTitle());
        myHolder.education_txtview.setText(model_jobs.get(position).getDetails());
        myHolder.ability_txtview.setText(model_jobs.get(position).getAbility());

        myHolder.setItemClickListener(new ItemClickListener_job() {
            @Override
            public void onItemClickListener_job(View v, int position) {
                String fullname_str = model_jobs.get(position).getFullname();
                String jobTitle_str = model_jobs.get(position).getJobTitle();
                String education_str = model_jobs.get(position).getDetails();
                String ability_str = model_jobs.get(position).getAbility();
                String salaryNeed_str = model_jobs.get(position).getSalaryNeed();
                String contact_str = model_jobs.get(position).getContact();
                String file_str = model_jobs.get(position).getFile();


                Intent intent = new Intent(c, searchjob_detail_screen.class);
                intent.putExtra("fullname",fullname_str);
                intent.putExtra("jobTitle",jobTitle_str);
                intent.putExtra("education",education_str);
                intent.putExtra("ability",ability_str);
                intent.putExtra("salaryNeed",salaryNeed_str);
                intent.putExtra("contact",contact_str);
                intent.putExtra("file",file_str);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model_jobs.size();
    }


    @Override
    public Filter getFilter() {
        if(customFilterJob == null){
            customFilterJob = new CustomFilterJob(filterList,this);
        }
        return  customFilterJob;
    }
}
