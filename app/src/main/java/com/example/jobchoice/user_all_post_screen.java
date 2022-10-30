package com.example.jobchoice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.example.jobchoice.SearchModel.Model;
import com.example.jobchoice.SearchModel.MyAdapter;
import com.example.jobchoice.UserPost.UserAdapter;
import com.example.jobchoice.UserPost.UserPostModel;
import com.example.jobchoice.api.SimpleAPI;
import com.example.jobchoice.api.WokerFindingSearchBox;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class user_all_post_screen extends AppCompatActivity {
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    SharedPreferences preferences;
    SimpleAPI simpleAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_all_post_screen);

        recyclerView = findViewById(R.id.recycleView);
        preferences = this.getSharedPreferences("My_Pref", Context.MODE_PRIVATE);
        getMyList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.getFilter().filter(newText);
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
        Call<WokerFindingSearchBox> call = simpleAPI.workerfindingsearchGet();
        call.enqueue(new Callback<WokerFindingSearchBox>() {
            @Override
            public void onResponse(Call<WokerFindingSearchBox> call, Response<WokerFindingSearchBox> response) {
                if(response.isSuccessful()){
                    System.out.println(response.body());
                }else{

                }
            }
            @Override
            public void onFailure(Call<WokerFindingSearchBox> call, Throwable t) {

            }
        });

        ArrayList<UserPostModel> models = new ArrayList<>();
        UserPostModel model = new UserPostModel();
        model.setCompanyName("BTS Company");
        model.setJobTitle("Programmer");
        model.setRequirement("Male");
        model.setSalary("30,000");
        models.add(model);

        model = new UserPostModel();
        model.setCompanyName("Google");
        model.setJobTitle("Cleaning Staff");
        model.setRequirement("Male");
        model.setSalary("8,000");
        models.add(model);

        model = new UserPostModel();
        model.setCompanyName("True");
        model.setJobTitle("Security Guard");
        model.setRequirement("Male");
        model.setSalary("8,000");
        models.add(model);

        String SortSetting = preferences.getString("Sort","Ascending");
        if(SortSetting.equals("Ascending")){
            Collections.sort(models,UserPostModel.By_TITLE_ASCENDING);
        }
        else if(SortSetting.equals("Descending")){
            Collections.sort(models,UserPostModel.By_TITLE_DESCENDING);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this,models);
        recyclerView.setAdapter(userAdapter);
    }
}