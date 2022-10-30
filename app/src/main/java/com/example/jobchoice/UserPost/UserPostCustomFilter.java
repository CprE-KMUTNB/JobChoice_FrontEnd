package com.example.jobchoice.UserPost;

import android.widget.Filter;

import java.util.ArrayList;

public class UserPostCustomFilter extends Filter {

    ArrayList<UserPostModel> filterList;
    UserAdapter userAdapter;

    public UserPostCustomFilter(ArrayList<UserPostModel> filterList, UserAdapter userAdapter) {
        this.filterList = filterList;
        this.userAdapter = userAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        if(charSequence != null && charSequence.length() > 0){
            charSequence = charSequence.toString().toUpperCase();
            ArrayList<UserPostModel> filterModels = new ArrayList<>();
            for(int i = 0; i < filterList.size(); i++){
                if(filterList.get(i).getCompanyName().toUpperCase().contains(charSequence)){
                    filterModels.add(filterList.get(i));
                }
            }
            results.count = filterModels.size();
            results.values = filterModels;
        }
        else{
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        userAdapter.userPostModels = (ArrayList<UserPostModel>) filterResults.values;
        userAdapter.notifyDataSetChanged();
    }
}
