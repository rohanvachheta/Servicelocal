package com.example.lenovo.myapplication.ServiceProviderside;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.myapplication.R;

public class Servicemainselect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicemainselect);
//        TextView textView=findViewById(R.id.serviceid);
        String service_id="";
        Button button=findViewById(R.id.button);

        Button button2=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Servicemainselect.this,Requestservice.class);
//                intent.putExtra("service_id",service_id);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Servicemainselect.this, Beserviceprovider.class);
                startActivity(intent);
            }
        });


    }
}
