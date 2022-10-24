package com.example.jobchoice;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient extends AppCompatActivity {
    private static Retrofit instance;
    public  static  Retrofit getInstance(){
        if(instance == null)
            instance = new Retrofit.Builder().baseUrl("https://localhost:5000/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return instance;
    }
}
