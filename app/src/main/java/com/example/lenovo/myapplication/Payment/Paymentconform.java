package com.example.lenovo.myapplication.Payment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.myapplication.R;


public class Paymentconform extends AppCompatActivity {

    EditText input_name,input_pin,input_account;
    Button conform;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentconform);
        input_name=findViewById(R.id.input_name);
        input_pin=findViewById(R.id.input_pin);
        input_account=findViewById(R.id.input_account);
        conform=findViewById(R.id.btn_signup);
        conform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=input_name.getText().toString();
                String pin=input_pin.getText().toString();
                String account =input_account.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("name",name);
                intent.putExtra("pin",pin);
                intent.putExtra("account",account);
                setResult(2,intent);
                finish();//finishing activity
            }
        });
    }
}
