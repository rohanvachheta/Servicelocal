package com.example.lenovo.myapplication.Newsfeed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.R;

public class RecyclerViewHolders  extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView countryName ,citycontent;
    public Button share, explore;
    public ImageView countryPhoto;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        countryName = (TextView)itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView)itemView.findViewById(R.id.country_photo);
        citycontent=itemView.findViewById(R.id.citycontent);
        share=itemView.findViewById(R.id.share);
        explore=itemView.findViewById(R.id.explor);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Country Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}