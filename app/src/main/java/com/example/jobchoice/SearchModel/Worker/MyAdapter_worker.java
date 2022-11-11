package com.example.jobchoice.SearchModel.Worker;

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
import com.example.jobchoice.searchworker_detail_screen;

import java.util.ArrayList;

public class MyAdapter_worker extends RecyclerView.Adapter<MyHolder_worker> implements Filterable {
    Context c;
    ArrayList<Model_worker> model_workers, filterList;
    CustomFilterWorker customFilterWorker;

    public MyAdapter_worker(Context c, ArrayList<Model_worker> model_workers){
        this.c = c;
        this.model_workers = model_workers;
        this.filterList = model_workers;
    }

    @NonNull
    @Override
    public MyHolder_worker onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.worker_row_items,null);
        return new MyHolder_worker(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder_worker myHolder, int position) {
        myHolder.companyName_txtview.setText(model_workers.get(position).getCompanyName());
        myHolder.jobTitle_txtview.setText(model_workers.get(position).getJobTitle());
        myHolder.requirement_txtview.setText(model_workers.get(position).getRequirement());
        myHolder.salary_txtview.setText(model_workers.get(position).getSalary());

        myHolder.setItemClickListener(new ItemClickListener_worker() {
            @Override
            public void onItemClickListener_worker(View v, int position) {
                String companyName_str = model_workers.get(position).getCompanyName();
                String jobTitle_str = model_workers.get(position).getJobTitle();
                String requirement_str = model_workers.get(position).getRequirement();
                String salary_str = model_workers.get(position).getSalary();

                Intent intent = new Intent(c, searchworker_detail_screen.class);
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
        return model_workers.size();
    }


    @Override
    public Filter getFilter() {
        if(customFilterWorker == null){
            customFilterWorker = new CustomFilterWorker(filterList,this);
        }
        return  customFilterWorker;
    }
}
