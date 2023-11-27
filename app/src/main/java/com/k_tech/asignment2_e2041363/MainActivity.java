package com.k_tech.asignment2_e2041363;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //intialize buttons
    Button btnaddVehicle,btncheckList,btndrivingTips,btnaddServiceRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set xml View
        setContentView(R.layout.activity_main);

        //Get button IDs
        btnaddVehicle = (Button) findViewById(R.id.btnaddVehicle);
        btncheckList = (Button) findViewById(R.id.btncheckList);
        btndrivingTips = (Button) findViewById(R.id.btndrivingTips);
        btnaddServiceRecord = (Button) findViewById(R.id.btnaddServiceRecord);
        //btnaddVehicle = (Button) findViewById(R.id.btnaddVehicle);

        btnaddVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(getApplicationContext(),VehicleList.class);
                Intent i = new Intent("com.k_tech.asignment2_e2041363.VehicleList");
                startActivity(i);
            }
        });
        btncheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(getApplicationContext(),MonthlyChecklist.class);
                Intent i = new Intent("com.k_tech.asignment2_e2041363.MonthlyChecklist");
                startActivity(i);
            }
        });
        btndrivingTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(getApplicationContext(),DrivingTips.class);
                Intent i = new Intent("com.k_tech.asignment2_e2041363.DrivingTips");
                startActivity(i);
            }
        });
        btnaddServiceRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(getApplicationContext(),ServiceRecods.class);
                Intent i = new Intent("com.k_tech.asignment2_e2041363.ServiceRecods");
                startActivity(i);
            }
        });

    }


}