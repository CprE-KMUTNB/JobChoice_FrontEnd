package com.example.jobchoice.SearchModel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jobchoice.R;
import com.example.jobchoice.search_more_screen;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder>{
    Context c;
    ArrayList<Model> models;

    public MyAdapter(Context c, ArrayList<Model> models){
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_items,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int position) {
        myHolder.companyName_txtview.setText(models.get(position).getCompanyName());
        myHolder.jobTitle_txtview.setText(models.get(position).getJobTitle());
        myHolder.requirement_txtview.setText(models.get(position).getRequirement());
        myHolder.salary_txtview.setText(models.get(position).getSalary());

        myHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String companyName_str = models.get(position).getCompanyName();
                String jobTitle_str = models.get(position).getJobTitle();
                String requirement_str = models.get(position).getRequirement();
                String salary_str = models.get(position).getSalary();

                Intent intent = new Intent(c, search_more_screen.class);
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
        return models.size();
    }


}
