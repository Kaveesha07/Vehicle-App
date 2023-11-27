package com.k_tech.asignment2_e2041363;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChangeGear extends AppCompatActivity {
    //intialize buttons
    Button btnbackHomeActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set xml View
        setContentView(R.layout.activity_changegear);

        //Get button IDs
        btnbackHomeActivity = (Button) findViewById(R.id.btnbackHomeActivity);

        //Back Button Function
        btnbackHomeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), DrivingTips.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(mainActivityIntent);;
            }
        });

    }

}
