package com.example.jobchoice.SearchModel;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    ArrayList<Model> filterList;
    MyAdapter myAdapter;

    public CustomFilter(ArrayList<Model> filterList, MyAdapter myAdapter) {
        this.filterList = filterList;
        this.myAdapter = myAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        if(charSequence != null && charSequence.length() > 0){
            charSequence = charSequence.toString().toUpperCase();
            ArrayList<Model> filterModels = new ArrayList<>();
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
        myAdapter.models = (ArrayList<Model>) filterResults.values;
        myAdapter.notifyDataSetChanged();
    }
}
