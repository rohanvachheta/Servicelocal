package com.example.lenovo.myapplication.Newsfeed;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.Activity.Service_form;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Serviceprovider.RecyclerAdapter;
import com.example.lenovo.myapplication.Serviceprovider.Serviceproviderjson;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyviewHolder> {

    Context context;
    List<Serviceproviderjson> movieList;

    public NewsAdapter(Context context, List<Serviceproviderjson> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieList(List<Serviceproviderjson> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_adapter_serviceprovider,parent,false);
        return new RecyclerAdapter.MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyviewHolder holder, int position) {
//        holder.email.setText(movieList.get(position).getUserid().getEmail());
//        holder.location.setText(movieList.get(position).getLocation());
//        holder.created_at.setText(movieList.get(position).getCreatedAt());
//        holder.address.setText(movieList.get(position).getAddress());
//        holder.services.setText(movieList.get(position).getServices().toString());
//        holder.name.setText(movieList.get(position).getName().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), Service_form.class);

                Toast.makeText(context, ""+movieList.get(position).getServices(), Toast.LENGTH_SHORT).show();
                intent.putExtra("serviceProviderId",movieList.get(position).getId());
                intent.putExtra("list",movieList.get(position).getServices().toString());
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();


    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {
        TextView email,created_at,location,address,services,name;


        public MyviewHolder(View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            email = (TextView)itemView.findViewById(R.id.email);
            created_at = (TextView)itemView.findViewById(R.id.created_at);
            location = (TextView)itemView.findViewById(R.id.location);
            address = (TextView)itemView.findViewById(R.id.address);
            services = (TextView)itemView.findViewById(R.id.services);

        }
    }
}