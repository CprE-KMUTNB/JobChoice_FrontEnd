package com.example.jobchoice;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jobchoice.SearchModel.Model;
import com.example.jobchoice.SearchModel.MyAdapter;

import java.util.ArrayList;


public class search_screen extends Fragment {
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_search_screen, container, false);
        recyclerView = v.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new MyAdapter(getContext(),getMyList());
        recyclerView.setAdapter(myAdapter);
        return v;
    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();
        Model model = new Model();
        model.setCompanyName("BTS Company");
        model.setJobTitle("Programmer");
        model.setRequirement("Male");
        model.setSalary("30,000");
        models.add(model);

        return models;
    }
}