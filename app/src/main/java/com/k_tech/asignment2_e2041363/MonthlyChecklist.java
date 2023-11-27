package com.k_tech.asignment2_e2041363;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MonthlyChecklist extends AppCompatActivity {
    //intialize buttons
    Button btnupdate,btnGoBack;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set xml View
        setContentView(R.layout.activity_monthlychecklist);

        //Get button IDs
        btnupdate = (Button) findViewById(R.id.btnupdate);
        btnGoBack = (Button) findViewById(R.id.btnGoBack);

        //Back Button Function
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(mainActivityIntent);;
            }
        });
    }
}
