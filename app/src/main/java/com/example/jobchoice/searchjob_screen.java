package com.example.jobchoice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.Button;
import android.widget.SearchView;

import com.example.jobchoice.SearchModel.Job.Model_job;
import com.example.jobchoice.SearchModel.Job.MyAdapter_job;
import com.example.jobchoice.api.GetPostCount;
import com.example.jobchoice.api.JobFindingSearchBox;
import com.example.jobchoice.api.SimpleAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class searchjob_screen extends Fragment {
    RecyclerView recyclerView;
    MyAdapter_job myAdapter_job;
    SharedPreferences preferences;
    SimpleAPI simpleAPI;
    List<JobFindingSearchBox> jobFindingSearchBoxList;
    GetPostCount getPostCase;
    private int count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_searchjob_screen, container, false);

        Bundle args = this.getArguments();
        Object email = args.get("email");
        String email_str = email.toString();

        recyclerView = v.findViewById(R.id.recycleView);
        preferences = getContext().getSharedPreferences("My_Pref", Context.MODE_PRIVATE);
        getMyList();

        Button add_btn = v.findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addselectedPopUp_screen showPopUp = new addselectedPopUp_screen();
                Bundle bundle = new Bundle();
                bundle.putString("email",email_str);
                showPopUp.setArguments(bundle);
                showPopUp.show(getActivity().getSupportFragmentManager(), "showPopUp");
            }
        });

        Button yourpost_btn = v.findViewById(R.id.yourpost_btn);
        yourpost_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),user_all_jobpost_screen.class);
                intent.putExtra("email",email_str);
                startActivity(intent);
            }
        });
        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_job_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myAdapter_job.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (myAdapter_job != null){
                    myAdapter_job.getFilter().filter(newText);
                }
                return false;
            }
        });
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sorting) {
            sortDailog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jobchoice-app.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        simpleAPI = retrofit.create(SimpleAPI.class);
        Call<GetPostCount> call1 = simpleAPI.jobfindingpostcountGet();
        call1.enqueue(new Callback<GetPostCount>() {
            @Override
            public void onResponse(Call<GetPostCount> call, Response<GetPostCount> response) {
                if(response.isSuccessful()){
                    getPostCase = response.body();
                    count = Integer.parseInt(getPostCase.getCount());
                    System.out.println("Get count");
                    Call<List<JobFindingSearchBox>> call2 = simpleAPI.jobfindingsearchGet();
                    call2.enqueue(new Callback<List<JobFindingSearchBox>>() {
                        @Override
                        public void onResponse(Call<List<JobFindingSearchBox>> call, Response<List<JobFindingSearchBox>> response) {
                            if(response.isSuccessful()){
                                System.out.println("Get data");
                                jobFindingSearchBoxList = response.body();
                                SearchPost();
                            }else{
                                System.out.println("Cannot get data");
                            }
                        }
                        @Override
                        public void onFailure(Call<List<JobFindingSearchBox>> call, Throwable t) {
                            System.out.println("Cannot get data : " + t.getCause());
                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<GetPostCount> call, Throwable t) {
                System.out.println("Cannot get count : " + t.getCause());
            }
        });

    }

    public void SearchPost(){
        ArrayList<Model_job> model_jobs = new ArrayList<>();

        for(int i = 0 ; i <= count - 1 ; i++){
            System.out.println(jobFindingSearchBoxList.get(i));
            Model_job model_job = new Model_job();
            model_job.setFullname(jobFindingSearchBoxList.get(i).getFullname());
            model_job.setJobTitle(jobFindingSearchBoxList.get(i).getJobTitle());
            model_job.setDetails(jobFindingSearchBoxList.get(i).getEducation());
            model_job.setAbility(jobFindingSearchBoxList.get(i).getAbility());
            model_job.setSalaryNeed(jobFindingSearchBoxList.get(i).getSalaryNeeded());
            model_job.setContact(jobFindingSearchBoxList.get(i).getContact());
            model_job.setFile(jobFindingSearchBoxList.get(i).getFile());
            model_jobs.add(model_job);
        }

        /*String SortSetting = preferences.getString("Sort","Ascending");
        if(SortSetting.equals("Ascending")){
            Collections.sort(model_jobs,Model_job.By_TITLE_ASCENDING);
        }
        else if(SortSetting.equals("Descending")){
            Collections.sort(model_jobs,Model_job.By_TITLE_DESCENDING);
        }*/

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter_job= new MyAdapter_job(getContext(),model_jobs);
        recyclerView.setAdapter(myAdapter_job);
    }
}