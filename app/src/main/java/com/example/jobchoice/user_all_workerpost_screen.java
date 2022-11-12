package com.example.jobchoice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobchoice.UserPost.Worker.UserAdapter_worker;
import com.example.jobchoice.UserPost.Worker.UserModel_worker;
import com.example.jobchoice.api.GetPostCount;
import com.example.jobchoice.api.SimpleAPI;
import com.example.jobchoice.api.WokerFindingSearchBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class user_all_workerpost_screen extends AppCompatActivity {
    TextView alert_txtview;

    RecyclerView recyclerView;
    UserAdapter_worker userAdapter_worker;
    SharedPreferences preferences;
    SimpleAPI simpleAPI;
    List<WokerFindingSearchBox> wokerFindingSearchBoxList;
    GetPostCount getPostCase;
    public String email_str;
    private int count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_all_workerpost_screen);
        alert_txtview = findViewById(R.id.alert_txtview);

        Bundle extras = getIntent().getExtras();
        email_str = extras.getString("email");

        recyclerView = findViewById(R.id.recycleView);
        preferences = this.getSharedPreferences("My_Pref", Context.MODE_PRIVATE);
        getMyList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_worker_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userAdapter_worker.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (userAdapter_worker != null){
                    userAdapter_worker.getFilter().filter(newText);
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.MyDialogTheme);

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
        Call<GetPostCount> call1 = simpleAPI.userworkerfindingpostcountGet(email_str);
        call1.enqueue(new Callback<GetPostCount>() {
            @Override
            public void onResponse(Call<GetPostCount> call, Response<GetPostCount> response) {
                if(response.isSuccessful()){
                    getPostCase = response.body();
                    count = Integer.parseInt(getPostCase.getCount());
                    System.out.println("Get count");
                    if(count == 0){
                        alert_txtview.setText("(You don't have any post)");
                        Toast.makeText(user_all_workerpost_screen.this, "You don't have any post", Toast.LENGTH_SHORT).show();
                    }else{
                        Call<List<WokerFindingSearchBox>> call2 = simpleAPI.userworkerfindingpostGet(email_str);
                        call2.enqueue(new Callback<List<WokerFindingSearchBox>>() {
                            @Override
                            public void onResponse(Call<List<WokerFindingSearchBox>> call, Response<List<WokerFindingSearchBox>> response) {
                                if(response.isSuccessful()){
                                    System.out.println("Get data");
                                    wokerFindingSearchBoxList = response.body();
                                    UserWorkerPost();
                                }else{
                                    System.out.println("Cannot get data");
                                }
                            }
                            @Override
                            public void onFailure(Call<List<WokerFindingSearchBox>> call, Throwable t) {
                                System.out.println("Cannot get data : " + t.getCause());
                            }
                        });
                    }
                }
            }
            @Override
            public void onFailure(Call<GetPostCount> call, Throwable t) {
                alert_txtview.setText("(Cannot get your post)");
                System.out.println("Cannot get count : " + t.getCause());
            }
        });

    }

    public void UserWorkerPost(){
        ArrayList<UserModel_worker> userModel_workers = new ArrayList<>();

        for(int i = 0 ; i <= count - 1 ; i++){
            System.out.println(wokerFindingSearchBoxList.get(i));
            UserModel_worker userModel_worker = new UserModel_worker();
            userModel_worker.setEmail(wokerFindingSearchBoxList.get(i).getEmail());
            userModel_worker.setCompanyName(wokerFindingSearchBoxList.get(i).getUser());
            userModel_worker.setJobTitle(wokerFindingSearchBoxList.get(i).getJobTitle());
            userModel_worker.setRequirement(wokerFindingSearchBoxList.get(i).getRequirement());
            userModel_worker.setSalary(wokerFindingSearchBoxList.get(i).getSalary());
            userModel_workers.add(userModel_worker);
        }

        String SortSetting = preferences.getString("Sort","Ascending");
        if(SortSetting.equals("Ascending")){
            Collections.sort(userModel_workers,UserModel_worker.By_TITLE_ASCENDING);
        }
        else if(SortSetting.equals("Descending")){
            Collections.sort(userModel_workers,UserModel_worker.By_TITLE_DESCENDING);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter_worker = new UserAdapter_worker(this,userModel_workers);
        recyclerView.setAdapter(userAdapter_worker);
    }
}