package com.example.jobchoice.UserPost.Job;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobchoice.R;

public class UserHolder_job extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView fullname_txtview;
    TextView jobTitle_txtview;
    TextView education_txtview;
    TextView ability_txtview;
    UserItemClickListener_job userItemClickListener_job;

    UserHolder_job(@NonNull View itemView){
        super(itemView);
        fullname_txtview = itemView.findViewById(R.id.fullname_txtview);
        jobTitle_txtview = itemView.findViewById(R.id.jobTitle_txtview);
        education_txtview = itemView.findViewById(R.id.education_txtview);
        ability_txtview = itemView.findViewById(R.id.ability_txtview);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.userItemClickListener_job.onItemClickListener_job(view,getLayoutPosition());
    }

    public void setItemClickListener(UserItemClickListener_job ic){
        this.userItemClickListener_job = ic;
    }
}
