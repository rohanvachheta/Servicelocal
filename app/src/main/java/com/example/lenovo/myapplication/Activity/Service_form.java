package com.example.lenovo.myapplication.Activity;

import android.animation.Animator;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.lenovo.myapplication.R;
import com.example.lenovo.myapplication.Serviceprovider.Getserviceprovider;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static android.view.View.GONE;

public class Service_form extends AppCompatActivity  implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Intent intent=getIntent();;
    String[] countryNames = {"chain", "tier", "clutch", "gear", "tube", "wheel"};
    int flags[] = {R.drawable.cloths_2, R.drawable.cloths_1, R.drawable.cloths_3, R.drawable.cloths_4, R.drawable.cloths_5, R.drawable.cloths_4};
    int flags2[] = {R.drawable.cloths_2, R.drawable.cloths_5, R.drawable.cloths_4};
//    ApiInterface apiInterface;
    Button btnDatePicker, btnTimePicker;
    EditText txtDate, txtTime;
    TextView services;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Spinner spin = (Spinner) findViewById(R.id.simpleSpinner);
        Button button=findViewById(R.id.btn_signup);
        Switch first = findViewById(R.id.twowheel);
//        Intent intent=getIntent();
//        String arrayList= intent.getStringExtra("list");
//        String serviceproviderid= intent.getStringExtra("serviceProviderId");
//////
//        String[] ary = arrayList.split(",");
//        Log.e("service", "onCreate: "+ary+"and "+arrayList );

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);
        services=(TextView)findViewById(R.id.servicec);
        services.setText("");
        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ApiInterface.URL_BASE)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        apiInterface = retrofit.create(ApiInterface.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Service_form.this, Getserviceprovider.class);
                startActivity(intent);
                start();
            }
        });

        // prepare call in Retrofit 2.0



        first.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    spin.setOnItemSelectedListener(Service_form.this);
                    CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), flags2, countryNames);
                    spin.setAdapter(customAdapter);
                } else {
                    spin.setOnItemSelectedListener(Service_form.this);

                    CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), flags, countryNames);
                    spin.setAdapter(customAdapter);
                }
            }
        });
        spin.setOnItemSelectedListener(Service_form.this);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), flags, countryNames);
        spin.setAdapter(customAdapter);


    }

    private void start() {
        try {
            JSONObject paramObject = new JSONObject();
            paramObject.put("text", "rohan@gmail.com");
//            paramObject.put("pass", "4384984938943");

//            Call<Todo> userCall = apiInterface.getUser(paramObject.toString());
//            userCall.enqueue(   this);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "stop"+e.toString(), Toast.LENGTH_LONG).show();
            Log.e("Service", "onCreate: "+e.toString() );
        }
    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), countryNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(View view) {
        if (view == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }

//    @Override
//    public void onResponse(Call<Todo> call, Response<Todo> response) {
//        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onFailure(Call<Todo> call, Throwable t) {
//        Toast.makeText(this, "ro"+t, Toast.LENGTH_SHORT).show();
//    }
}