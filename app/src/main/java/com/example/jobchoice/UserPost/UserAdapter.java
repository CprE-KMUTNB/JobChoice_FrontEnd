package com.example.jobchoice.UserPost;

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
import com.example.jobchoice.user_post_screen;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> implements Filterable {
    Context c;
    ArrayList<UserPostModel> userPostModels, filterList;
    UserPostCustomFilter userPostCustomFilter;

    public UserAdapter(Context c, ArrayList<UserPostModel> userPostModels){
        this.c = c;
        this.userPostModels = userPostModels;
        this.filterList = userPostModels;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.worker_row_items,null);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder UserHolder, int position) {
        UserHolder.companyName_txtview.setText(userPostModels.get(position).getCompanyName());
        UserHolder.jobTitle_txtview.setText(userPostModels.get(position).getJobTitle());
        UserHolder.requirement_txtview.setText(userPostModels.get(position).getRequirement());
        UserHolder.salary_txtview.setText(userPostModels.get(position).getSalary());

       UserHolder.setItemClickListener(new UserItemClickListener() {
           @Override
           public void onItemClickListener(View v, int position) {
               String companyName_str = userPostModels.get(position).getCompanyName();
               String jobTitle_str = userPostModels.get(position).getJobTitle();
               String requirement_str = userPostModels.get(position).getRequirement();
               String salary_str = userPostModels.get(position).getSalary();

               Intent intent = new Intent(c, user_post_screen.class);
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
        return userPostModels.size();
    }


    @Override
    public Filter getFilter() {
        if(userPostCustomFilter == null){
            userPostCustomFilter = new UserPostCustomFilter(filterList,this);
        }
        return  userPostCustomFilter;
    }
}
