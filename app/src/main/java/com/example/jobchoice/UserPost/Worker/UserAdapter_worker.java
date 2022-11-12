package com.example.jobchoice.UserPost.Worker;

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
import com.example.jobchoice.user_all_workerpost_detail_screen;

import java.util.ArrayList;

public class UserAdapter_worker extends RecyclerView.Adapter<UserHolder_worker> implements Filterable {
    Context c;
    ArrayList<UserModel_worker> userModel_workers, filterList;
    UserCustomFilterWorker userCustomFilterWorker;

    public UserAdapter_worker(Context c, ArrayList<UserModel_worker> userModel_workers){
        this.c = c;
        this.userModel_workers = userModel_workers;
        this.filterList = userModel_workers;
    }

    @NonNull
    @Override
    public UserHolder_worker onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.worker_row_items,null);
        return new UserHolder_worker(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder_worker userHolder_worker, int position) {
        userHolder_worker.companyName_txtview.setText( userModel_workers.get(position).getCompanyName());
        userHolder_worker.jobTitle_txtview.setText( userModel_workers.get(position).getJobTitle());
        userHolder_worker.requirement_txtview.setText( userModel_workers.get(position).getRequirement());
        userHolder_worker.salary_txtview.setText( userModel_workers.get(position).getSalary());

        userHolder_worker.setItemClickListener(new UserItemClickListener_worker() {
            @Override
            public void onItemClickListener_worker(View v, int position) {
                String email_str = userModel_workers.get(position).getEmail();
                String companyName_str =  userModel_workers.get(position).getCompanyName();
                String jobTitle_str =  userModel_workers.get(position).getJobTitle();
                String requirement_str =  userModel_workers.get(position).getRequirement();
                String salary_str =  userModel_workers.get(position).getSalary();

                Intent intent = new Intent(c, user_all_workerpost_detail_screen.class);
                intent.putExtra("email",email_str);
                intent.putExtra("companyName",companyName_str);
                intent.putExtra("jobTitle",jobTitle_str);
                intent.putExtra("requirement",requirement_str);
                intent.putExtra("salary",salary_str);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return  userModel_workers.size();
    }


    @Override
    public Filter getFilter() {
        if(userCustomFilterWorker == null){
            userCustomFilterWorker = new UserCustomFilterWorker(filterList,this);
        }
        return  userCustomFilterWorker;
    }
}
