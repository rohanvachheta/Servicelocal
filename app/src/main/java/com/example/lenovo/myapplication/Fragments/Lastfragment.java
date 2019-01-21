package com.example.lenovo.myapplication.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.myapplication.Activity.Service_form;
import com.example.lenovo.myapplication.ApiClient;
import com.example.lenovo.myapplication.ApiInterface;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Serviceprovider.Getserviceprovider;
import com.example.lenovo.myapplication.Serviceprovider.RecyclerAdapter;
import com.example.lenovo.myapplication.Serviceprovider.Serviceproviderjson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lastfragment extends Fragment {
    private RecyclerAdapter adapter;
    List<Serviceproviderjson> photoList;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    private ArrayList<Serviceproviderjson> mExampleList_Full;
    private ArrayList<Serviceproviderjson> mExampleList;
    ApiInterface service;
    View view;


    public Lastfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_lastfragment, container, false);
        mExampleList = new ArrayList<>();
        mExampleList_Full = new ArrayList<>();
        mExampleList_Full = new ArrayList<>(mExampleList);
        EditText editText = view.findViewById(R.id.edittext);
        progressDoalog = new ProgressDialog(getContext());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        createlist();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        return view;
    }


    private void filter(String text) {
        ArrayList<Serviceproviderjson> filteredList = new ArrayList<>();

        for(Serviceproviderjson item : photoList)
        { if (item.getAddress().toLowerCase().contains(text.toLowerCase()))
        { filteredList.add(item); }
        }

        adapter.filterList(filteredList);
        mExampleList = new ArrayList<>(filteredList);

    }
    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Serviceproviderjson> photoList) {
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        adapter = new RecyclerAdapter(getContext(),photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void createlist(){
        service = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Serviceproviderjson>> call = service.getserviceproviders();
        call.enqueue(new Callback<List<Serviceproviderjson>>() {
            @Override
            public void onResponse(Call<List<Serviceproviderjson>> call, Response<List<Serviceproviderjson>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
                photoList=response.body();

                Log.e("tab", "on success: "+response.body());
            }

            @Override
            public void onFailure(Call<List<Serviceproviderjson>> call, Throwable t) {
                progressDoalog.dismiss();
                Log.e("tab", "onFailure: "+t );
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
