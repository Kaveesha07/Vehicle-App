package com.k_tech.asignment2_e2041363;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DrivingTips extends AppCompatActivity {
    //ImageView imgStart;
    //intialize buttons
    Button  btnbackHome;
    TextView stopV,signalV,GearV,startV;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set xml View
        setContentView(R.layout.activity_drivingtips);

        //Get button IDs
        startV =(TextView) findViewById(R.id.startV);
        GearV  =(TextView) findViewById(R.id.GearV);
        signalV =(TextView) findViewById(R.id.signalV);
        stopV =(TextView) findViewById(R.id.stopV);
        btnbackHome = (Button) findViewById(R.id.btnbackHome);
        //imgStart =(ImageView) findViewById(R.id.imgStart);
        //imgStart.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
               // Intent i = new Intent("com.k_tech.asignment2_e2041363.VehicleStart");
                //startActivity(i);
            //}
        //});

        //Back Start Tip View Function
        startV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.k_tech.asignment2_e2041363.VehicleStart");
                startActivity(i);
            }
        });

        //Back Gear Tip View Function
        GearV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.k_tech.asignment2_e2041363.ChangeGear");
                startActivity(i);
            }
        });

        //Back signal Tip View Function
        signalV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.k_tech.asignment2_e2041363.ChangeSignal");
                startActivity(i);
            }
        });
        //Back Stop Tip View Function
        stopV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.k_tech.asignment2_e2041363.VehicleStop");
                startActivity(i);
            }
        });

        //Back Button Function
        btnbackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(mainActivityIntent);;
            }
        });

    }
}

