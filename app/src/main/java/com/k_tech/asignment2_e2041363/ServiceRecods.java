package com.k_tech.asignment2_e2041363;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceRecods extends AppCompatActivity {
    //intialize buttons
    Button btnaddServiceRecord,btnremoveServiceRecord,btnbackHome;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set xml View
        setContentView(R.layout.activity_servicerecords);

        //Get button IDs
        btnaddServiceRecord =(Button) findViewById(R.id.btnaddServiceRecord);
        btnremoveServiceRecord =(Button) findViewById(R.id.btnremoveServiceRecord);
        btnbackHome =(Button) findViewById(R.id.btnbackHome);

        //Back Button Function
        btnbackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(mainActivityIntent);;
            }
        });
        btnaddServiceRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.k_tech.asignment2_e2041363.ServiceInfo");
                startActivity(i);
            }
        });

    }
}
