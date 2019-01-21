package com.example.lenovo.myapplication.ServiceProviderside;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.myapplication.ApiClient;
import com.example.lenovo.myapplication.ApiInterface;
import com.example.lenovo.myapplication.Newsfeed.Adaptationnews;
import com.example.lenovo.myapplication.Newsfeed.Newsjsonpojo;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Requestinformation.Showyourrequeststatus;
import com.example.lenovo.myapplication.Serviceprovider.Serviceproviderjson;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterServicerequest  extends RecyclerView.Adapter<AdapterServicerequest.MyviewHolder>{
    Context context;
    List<Showyourrequeststatus> list;

    public AdapterServicerequest(Context context, List<Showyourrequeststatus > list) {
        this.context = context;
        this.list = list;
    }
    public void setMovieList(List<Showyourrequeststatus> movieList) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterServicerequest.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.servicerequest,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterServicerequest.MyviewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getId());
        holder.textView2.setText(list.get(position).getAddress());

        holder.Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Reportsave.class);
                context.startActivity(intent);
            }
        });
        holder.conformm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonObject payerReg = new JsonObject();
                payerReg.addProperty("requestid",list.get(position).getId()
                );

                Toast.makeText(context, "hello"+list.get(position).getId(), Toast.LENGTH_SHORT).show();
                ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
                Call<List<Showyourrequeststatus>> calllocation = service.acceptrequest(payerReg);
                calllocation.enqueue(new Callback<List<Showyourrequeststatus>>() {
                    @Override
                    public void onResponse(Call<List<Showyourrequeststatus>> call, Response<List<Showyourrequeststatus>> response) {
                        Toast.makeText(context, "conform request", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<Showyourrequeststatus>> call, Throwable t) {
                        Toast.makeText(context, "failed to request", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

    @Override
    public int getItemCount() {

        return  list.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public TextView textView2;
        public Button conformm;
        public Button Report;

        public MyviewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.post_text1);
            textView2=(TextView)itemView.findViewById(R.id.post_description1);
            conformm=itemView.findViewById(R.id.conformm);
            Report=itemView.findViewById(R.id.report);



        }
    }

}
