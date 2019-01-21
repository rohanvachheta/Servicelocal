package com.example.lenovo.myapplication.Serviceprovider;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.Activity.Service_form;
import com.example.lenovo.myapplication.FinalPayent;
import com.example.lenovo.myapplication.Newsfeed.Adaptationnews;
import com.example.lenovo.myapplication.Newsfeed.Newsfeed;
import com.example.lenovo.myapplication.Newsfeed.Newsjsonpojo;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Requestinformation.Showyourrequeststatus;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<Adaptationnews.MyviewHolder>{
    Context context;
    List<Serviceproviderjson> list;

    public RecyclerAdapter(Context context, List<Serviceproviderjson> list) {
        this.context = context;
        this.list = list;
    }
    public void setMovieList(List<Serviceproviderjson> movieList) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Adaptationnews.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_liveservicereport,parent,false);
        return new Adaptationnews.MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptationnews.MyviewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getName());
        holder.textView2.setText(list.get(position).getAddress().toString());
//        Glide.with(context)
//                .load(list.get(position).getPhotolink())
//                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,Service_form.class);
//                intent.putExtra("title",list.get(position).getName());
//                intent.putExtra("dec",list.get(position).getPhone());
//
//                intent.putExtra("photo",list.get(position).getEmail());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return  list.size();
    }

    public void filterList(ArrayList<Serviceproviderjson> filteredList) {
        list = filteredList;
        notifyDataSetChanged();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public  TextView textView2;
        public  ImageView imageView;

        public MyviewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.post_text1);
            textView2=(TextView)itemView.findViewById(R.id.post_description1);
            imageView= (ImageView) itemView.findViewById(R.id.post_image1);

        }
    }

}
