package com.example.jobchoice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.jobchoice.SearchModel.Model;
import com.example.jobchoice.SearchModel.MyAdapter;

import java.util.ArrayList;
import java.util.Collections;


public class search_screen extends Fragment {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_search_screen, container, false);
        recyclerView = v.findViewById(R.id.recycleView);
        preferences = getContext().getSharedPreferences("My_Pref", Context.MODE_PRIVATE);
        getMyList();
        return v;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sorting) {
            sortDailog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sortDailog(){
        String[] options = {"Ascending","Descending"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.MyDialogTheme);

        builder.setTitle("Sort by");
        builder.setIcon(R.drawable.ic_baseline_sort_24);

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i == 0){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Sort","Ascending");
                    editor.apply();
                    getMyList();
                }
                if(i == 1){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Sort","Descending");
                    editor.apply();
                    getMyList();
                }

            }
        });
        builder.create().show();
    }

    private void getMyList(){
        ArrayList<Model> models = new ArrayList<>();
        Model model = new Model();
        model.setCompanyName("BTS Company");
        model.setJobTitle("Programmer");
        model.setRequirement("Male");
        model.setSalary("30,000");
        models.add(model);
        
        model = new Model();
        model.setCompanyName("Google");
        model.setJobTitle("Cleaning Staff");
        model.setRequirement("Male");
        model.setSalary("8,000");
        models.add(model);

        model = new Model();
        model.setCompanyName("True");
        model.setJobTitle("Security Guard");
        model.setRequirement("Male");
        model.setSalary("8,000");
        models.add(model);

        String SortSetting = preferences.getString("Sort","Ascending");
        if(SortSetting.equals("Ascending")){
            Collections.sort(models,Model.By_TITLE_ASCENDING);
        }
        else if(SortSetting.equals("Descending")){
            Collections.sort(models,Model.By_TITLE_DESCENDING);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter = new MyAdapter(getContext(),models);
        recyclerView.setAdapter(myAdapter);
    }
}