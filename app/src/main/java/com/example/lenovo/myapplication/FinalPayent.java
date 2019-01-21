package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.myapplication.Payment.Paymentconform;

public class FinalPayent extends AppCompatActivity {

    Button Payment ,conform;
    TextView paymentdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_payent);
        paymentdetails=findViewById(R.id.paymentdetails);
        Payment= findViewById(R.id.payment);
        Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(FinalPayent.this, Paymentconform.class);
                startActivityForResult(intent, 2);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String name=data.getStringExtra("name");
            String pin=data.getStringExtra("pin");
            String account=data.getStringExtra("account");
            paymentdetails.setText("details "+name +"pin "+pin+"account "+account);
            Toast.makeText(this, "details "+name +"pin "+pin+"account "+account, Toast.LENGTH_SHORT).show();

        }
    }
}
