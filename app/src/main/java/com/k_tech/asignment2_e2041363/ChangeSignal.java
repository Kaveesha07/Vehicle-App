package com.k_tech.asignment2_e2041363;

import android.appwidget.AppWidgetProvider;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChangeSignal extends AppCompatActivity {
    //intialize buttons
    Button btnbackHome;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set xml View
        setContentView(R.layout.activity_changsignal);

        //Get button IDs
        btnbackHome =(Button) findViewById(R.id.btnbackHome);

        //Back Button Function
        btnbackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), DrivingTips.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(mainActivityIntent);;
            }
        });
    }
}
