package com.example.lenovo.myapplication.Newsfeed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lenovo.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;
    private ArrayList<String> mCustomObjects;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList , ArrayList<String>  mCustomObjects) {
        this.itemList = itemList;
        this.context = context;
        this.mCustomObjects=mCustomObjects;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.citycontent.setText(mCustomObjects.get(position));
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent o=new Intent(context,Newsactivity.class);
                o.putExtra("city",itemList.get(position).getName());
                context.startActivity(o);
//                String city=itemList.get(position).getName();
//                Toast.makeText(context, city, Toast.LENGTH_SHORT).show();
//                Intent o=new Intent(context,Newsactivity.class);
//                o.putExtra("city",city);
//                context.startActivity(o);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}