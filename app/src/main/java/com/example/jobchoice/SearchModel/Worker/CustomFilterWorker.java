package com.example.jobchoice.SearchModel.Worker;
import android.widget.Filter;
import java.util.ArrayList;

public class CustomFilterWorker extends Filter {

    ArrayList<Model_worker> model_workers;
    MyAdapter_worker myAdapter_worker;

    public CustomFilterWorker(ArrayList<Model_worker> model_workers, MyAdapter_worker myAdapter_worker) {
        this.model_workers = model_workers;
        this.myAdapter_worker = myAdapter_worker;
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        FilterResults results = new FilterResults();
        if(charSequence != null && charSequence.length() > 0){
            charSequence = charSequence.toString().toUpperCase();
            ArrayList<Model_worker> filterModels = new ArrayList<>();
            for(int i = 0; i < model_workers.size(); i++){
                if(model_workers.get(i).getCompanyName().toUpperCase().contains(charSequence)){
                    filterModels.add(model_workers.get(i));
                }
            }
            results.count = filterModels.size();
            results.values = filterModels;
        }
        else{
            results.count = model_workers.size();
            results.values = model_workers;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        myAdapter_worker.model_workers = (ArrayList<Model_worker>) filterResults.values;
        myAdapter_worker.notifyDataSetChanged();
    }
}
