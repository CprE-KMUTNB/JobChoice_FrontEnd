package com.example.jobchoice.SearchModel;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobchoice.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView companyName_txtview;
        TextView jobTitle_txtview;
        TextView requirement_txtview;
        TextView salary_txtview;
        ItemClickListener itemClickListener;

        MyHolder(@NonNull View itemView){
            super(itemView);
            companyName_txtview = itemView.findViewById(R.id.companyName_txtview);
            jobTitle_txtview = itemView.findViewById(R.id.jobTitle_txtview);
            requirement_txtview = itemView.findViewById(R.id.requirement_txtview);
            salary_txtview = itemView.findViewById(R.id.salary_txtview);

            itemView.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClickListener(view,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
    }
}
