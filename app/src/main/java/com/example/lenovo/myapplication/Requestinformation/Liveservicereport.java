package com.example.lenovo.myapplication.Requestinformation;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.example.lenovo.myapplication.Serviceprovider.Getserviceprovider;
import com.example.lenovo.myapplication.Serviceprovider.RecyclerAdapter;
import com.example.lenovo.myapplication.Serviceprovider.Serviceproviderjson;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Liveservicereport extends AppCompatActivity {

    private LiveReportAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    JsonObject payerReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_report);

        Intent intent=getIntent();
        String city=intent.getStringExtra("city");
        Log.e("tag", "onCreate: "+city );
        progressDoalog = new ProgressDialog(Liveservicereport.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        Toast.makeText(this, ""+city, Toast.LENGTH_SHORT).show();
        Newsjsonpojo newsjsonpojo=new Newsjsonpojo(city);

        /*Create handle for the RetrofitInstance interface*/
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        city="ahmedabad";
        city=city.toLowerCase();
        if(city.equals("ahmedabad")| city.equals("vadodara") | city.equals("surat") | city.equals("rajkot") | city.equals("gandhinagar")) {
            payerReg = new JsonObject();
            payerReg.addProperty("userid","5c41baac7310b8139494f2fd"
            );


            Call<List<Showyourrequeststatus>> calllocation = service.showyourlive(payerReg);
            calllocation.enqueue(new Callback<List<Showyourrequeststatus>>() {
                @Override
                public void onResponse(Call<List<Showyourrequeststatus>> call, Response<List<Showyourrequeststatus>> response) {
                    progressDoalog.dismiss();
                    generateDataList(response.body());

                    Log.e("tab", "on success: " + response.body());
                }

                @Override
                public void onFailure(Call<List<Showyourrequeststatus>> call, Throwable t) {
                    Toast.makeText(Liveservicereport.this, "something went wrong", Toast.LENGTH_SHORT).show();
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
    private void generateDataList(List<Showyourrequeststatus> photoList) {
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new LiveReportAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Liveservicereport.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}