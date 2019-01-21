package com.example.lenovo.myapplication.ServiceProviderside;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.ApiClient;
import com.example.lenovo.myapplication.ApiInterface;
import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Requestinformation.Showyourrequeststatus;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Reportsave extends AppCompatActivity {
    @BindView(R.id.towing)
    TextView towing;
    @BindView(R.id.User_id) TextView User_id;
    @BindView(R.id.payment) TextView payment;
    @BindView(R.id.service_provider) TextView service_provider;
    @BindView(R.id.review) TextView review;
    @BindView(R.id.status) TextView status;
    @BindView(R.id.requestid) TextView requestid;
    JSONObject paramObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportsave);
        ButterKnife.bind(this);
        Button report=findViewById(R.id.asss);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JsonObject payerReg = new JsonObject();
                payerReg = new JsonObject();
                payerReg.addProperty("userid","5c41baac7310b8139494f2fd"
                );
                payerReg.addProperty("payment","5c41baac7310b8139494f2fd"
                );
                payerReg.addProperty("towing","5c41baac7310b8139494f2fd"
                );
                payerReg.addProperty("service_provider","5c41baac7310b8139494f2fd"
                );
                payerReg.addProperty("requestid","5c41baac7310b8139494f2fd"
                );




                JSONObject paramObject;
                try {
                    paramObject = new JSONObject();
                    paramObject.put("User_id", "5c42e20d1261be5380b09ad8");
                    paramObject.put("requestid", "5c42e40c5cd7e70130c2c628");
                    paramObject.put("service_provider", "5c42e40c5cd7e70130c2c628");
                    paramObject.put("towing", "5c42e40c5cd7e70130c2c628");
                    paramObject.put("payment", "5c42e40c5cd7e70130c2c628");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
                Call<List<Example>> calllocation = service.report(payerReg);
                calllocation.enqueue(new Callback<List<Example>>() {
                    @Override
                    public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                        Toast.makeText(Reportsave.this, "done", Toast.LENGTH_SHORT).show();
                        Log.e("show", "onResponse: " );
                    }

                    @Override
                    public void onFailure(Call<List<Example>> call, Throwable t) {
                        Log.e("show", "onFailure: "+t );
                    }
                });

            }
        });





    }
    private JsonObject ApiJsonMap() {

        JsonObject gsonObject = new JsonObject();
        try {
            JSONObject jsonObj_ = new JSONObject();
            jsonObj_.put("User_id", "5c44a75139b89a509c15afff");
            jsonObj_.put("requestid", "5c42e40c5cd7e70130c2c628");
            jsonObj_.put("service_provider", "5c42e40c5cd7e70130c2c628");
            jsonObj_.put("towing", "5c42e40c5cd7e70130c2c628");
            jsonObj_.put("payment", "5c42e40c5cd7e70130c2c628");


            JsonParser jsonParser = new JsonParser();
            gsonObject = (JsonObject) jsonParser.parse(jsonObj_.toString());

            //print parameter
            Log.e("show", "AS PARAMETER  " + gsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return gsonObject;
    }

}
