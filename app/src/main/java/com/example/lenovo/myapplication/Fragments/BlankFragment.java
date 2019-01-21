package com.example.lenovo.myapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.myapplication.Newsfeed.ItemObject;
import com.example.lenovo.myapplication.Newsfeed.Newsfeed;
import com.example.lenovo.myapplication.Newsfeed.RecyclerViewAdapter;
import com.example.lenovo.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private LinearLayoutManager lLayout;

    private ArrayList<String> mCustomObjects=new ArrayList<>();

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);
        mCustomObjects.add("ahmdabda is a greate city to live");
        mCustomObjects.add("vadodara is a greate city to live");
        mCustomObjects.add("surat is a greate city to live");
        mCustomObjects.add("rajkot is a greate city to live");
        mCustomObjects.add("gandhinage is a greate city to live");

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(getContext());

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(getContext(), rowListItem,mCustomObjects);
        rView.setAdapter(rcAdapter);


        return  view;
    }

    private List<ItemObject> getAllItemList() {
        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Ahmedabad", R.drawable.cloths_1));
        allItems.add(new ItemObject("vadodara", R.drawable.cloths_4));
        allItems.add(new ItemObject("surat", R.drawable.cloths_3));
        allItems.add(new ItemObject("rajkot", R.drawable.cloths_5));
        allItems.add(new ItemObject("gandhinagar", R.drawable.cloths_2));

        return allItems;
    }

}
