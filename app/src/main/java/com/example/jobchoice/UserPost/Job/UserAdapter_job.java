package com.example.jobchoice.UserPost.Job;

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
import com.example.jobchoice.user_all_jobpost_detail_screen;

import java.util.ArrayList;

public class UserAdapter_job extends RecyclerView.Adapter<UserHolder_job> implements Filterable {
    Context c;
    ArrayList<UserModel_job> userModel_jobs, filterList;
    UserCustomFilterJob userCustomFilterJob;

    public UserAdapter_job(Context c, ArrayList<UserModel_job> userModel_jobs){
        this.c = c;
        this.userModel_jobs = userModel_jobs;
        this.filterList = userModel_jobs;
    }

    @NonNull
    @Override
    public UserHolder_job onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.job_row_items,null);
        return new UserHolder_job(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder_job userHolder_job, int position) {
        userHolder_job.fullname_txtview.setText(userModel_jobs.get(position).getFullname());
        userHolder_job.jobTitle_txtview.setText(userModel_jobs.get(position).getJobTitle());
        userHolder_job.education_txtview.setText(userModel_jobs.get(position).getDetails());
        userHolder_job.ability_txtview.setText(userModel_jobs.get(position).getAbility());

        userHolder_job.setItemClickListener(new UserItemClickListener_job() {
            @Override
            public void onItemClickListener_job(View v, int position) {
                String email_str = userModel_jobs.get(position).getEmail();
                String fullname_str =  userModel_jobs.get(position).getFullname();
                String jobTitle_str =  userModel_jobs.get(position).getJobTitle();
                String education_str =  userModel_jobs.get(position).getDetails();
                String ability_str =  userModel_jobs.get(position).getAbility();

                Intent intent = new Intent(c, user_all_jobpost_detail_screen.class);
                intent.putExtra("email",email_str);
                intent.putExtra("companyName",fullname_str);
                intent.putExtra("jobTitle",jobTitle_str);
                intent.putExtra("requirement",education_str);
                intent.putExtra("salary",ability_str);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  userModel_jobs.size();
    }


    @Override
    public Filter getFilter() {
        if(userCustomFilterJob == null){
            userCustomFilterJob = new UserCustomFilterJob(filterList,this);
        }
        return  userCustomFilterJob;
    }
}
