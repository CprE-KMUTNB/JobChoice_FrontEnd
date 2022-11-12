package com.example.jobchoice.UserPost.Worker;

import android.widget.Filter;

import java.util.ArrayList;

public class UserCustomFilterWorker extends Filter {

    ArrayList<UserModel_worker> userModel_workers;
    UserAdapter_worker userAdapter_worker;

    public UserCustomFilterWorker(ArrayList<UserModel_worker> filterList, UserAdapter_worker userAdapter_worker) {
        this.userModel_workers = filterList;
        this.userAdapter_worker = userAdapter_worker;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        if(charSequence != null && charSequence.length() > 0){
            charSequence = charSequence.toString().toUpperCase();
            ArrayList<UserModel_worker> filterModels = new ArrayList<>();
            for(int i = 0; i < userModel_workers.size(); i++){
                if(userModel_workers.get(i).getCompanyName().toUpperCase().contains(charSequence)){
                    filterModels.add(userModel_workers.get(i));
                }
            }
            results.count = filterModels.size();
            results.values = filterModels;
        }
        else{
            results.count = userModel_workers.size();
            results.values = userModel_workers;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        userAdapter_worker.userModel_workers = (ArrayList<UserModel_worker>) filterResults.values;
        userAdapter_worker.notifyDataSetChanged();
    }
}