package com.example.lenovo.myapplication.Newsfeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Newsfeed extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    private ArrayList<String> mCustomObjects=new ArrayList<>();
//    private  String[] a=new String[]
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        mCustomObjects.add("ahmdabda is a greate city to live");
        mCustomObjects.add("vadodara is a greate city to live");
        mCustomObjects.add("surat is a greate city to live");
        mCustomObjects.add("rajkot is a greate city to live");
        mCustomObjects.add("gandhinage is a greate city to live");

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(Newsfeed.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(Newsfeed.this, rowListItem,mCustomObjects);
        rView.setAdapter(rcAdapter);
    }
    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Ahmedabad", R.drawable.cloths_1));
        allItems.add(new ItemObject("vadodara", R.drawable.cloths_4));
        allItems.add(new ItemObject("surat", R.drawable.cloths_3));
        allItems.add(new ItemObject("rajkot", R.drawable.cloths_5));
        allItems.add(new ItemObject("gandhinagar", R.drawable.cloths_2));

        return allItems;
    }
}
