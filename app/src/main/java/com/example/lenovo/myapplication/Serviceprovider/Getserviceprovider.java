package com.example.lenovo.myapplication.Serviceprovider;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.lenovo.myapplication.ApiClient;
import com.example.lenovo.myapplication.ApiInterface;
import com.example.lenovo.myapplication.Newsfeed.Adaptationnews;
import com.example.lenovo.myapplication.Newsfeed.Newsactivity;
import com.example.lenovo.myapplication.Newsfeed.Newsjsonpojo;
import com.example.lenovo.myapplication.R;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Getserviceprovider extends AppCompatActivity {
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    JsonObject payerReg;
    String city="ahmedabad";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_report);
        String city="ahmedabad";
        progressDoalog = new ProgressDialog(Getserviceprovider.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        Toast.makeText(this, ""+city, Toast.LENGTH_SHORT).show();
        Newsjsonpojo newsjsonpojo=new Newsjsonpojo(city);

        /*Create handle for the RetrofitInstance interface*/
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);

        city=city.toLowerCase();
        if(city.equals("ahmedabad")| city.equals("vadodara") | city.equals("surat") | city.equals("rajkot") | city.equals("gandhinagar")) {
            payerReg = new JsonObject();
            payerReg.addProperty("location",city.toString()
            );


            Call<List<Serviceproviderjson>> calllocation = service.getserviceproviders();
            calllocation.enqueue(new Callback<List<Serviceproviderjson>>() {
                @Override
                public void onResponse(Call<List<Serviceproviderjson>> call, Response<List<Serviceproviderjson>> response) {
                    progressDoalog.dismiss();
                    generateDataList(response.body());

                    Log.e("tab", "on success: " + response.body());
                }

                @Override
                public void onFailure(Call<List<Serviceproviderjson>> call, Throwable t) {
                    Toast.makeText(Getserviceprovider.this, "something went wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            Toast.makeText(this, "nai chalbe", Toast.LENGTH_SHORT).show();
        }
//        Call<List<Newsjsonpojo>> call = service.getnews();
//        call.enqueue(new Callback<List<Newsjsonpojo>>() {
//            @Override
//            public void onResponse(Call<List<Newsjsonpojo>> call, Response<List<Newsjsonpojo>> response) {
//                progressDoalog.dismiss();
//                generateDataList(response.body());
//
//                Log.e("tab", "on success: "+response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Newsjsonpojo>> call, Throwable t) {
//                progressDoalog.dismiss();
//                Log.e("tab", "onFailure: "+t );
//                Toast.makeText(Newsactivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Serviceproviderjson> photoList) {
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new RecyclerAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Getserviceprovider.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}