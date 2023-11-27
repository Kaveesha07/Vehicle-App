package com.k_tech.asignment2_e2041363;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ServiceInfo extends AppCompatActivity {
    //intialize buttons
    Button btnsubmit,btnBack;

    //intialize EditText
    EditText serviceNo,serviceName,serviceDate,serviceDesc;
    long Value;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set xml View
        setContentView(R.layout.activity_serviceinfo);

        //Get button IDs
        serviceNo = (EditText) findViewById(R.id.serviceNo);
        serviceName = (EditText) findViewById(R.id.serviceName);
        btnsubmit =(Button) findViewById(R.id.btnsubmit);
        btnBack =(Button) findViewById(R.id.btnBack);
        serviceDate = (EditText) findViewById(R.id.serviceDate);
        serviceDesc = (EditText) findViewById(R.id.serviceDesc);

        //Back Button Function
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), ServiceRecods.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(mainActivityIntent);;;
            }
        });

        //Submit Button Function for service details
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ServiceNo = serviceNo.getText().toString().trim();
                String ServiceName = serviceName.getText().toString().trim();
                String ServiceDate = serviceDate.getText().toString().trim();
                String ServiceDesc = serviceDesc.getText().toString().trim();

                //error catch
                try {
                    VehicleManagerDB db = new VehicleManagerDB(getApplicationContext());
                    db.open();
                    Value = db.createEntry(ServiceNo,ServiceName,ServiceDate,ServiceDesc);
                    db.close();
                    Toast.makeText(getApplicationContext(), "Successfully Service Entry Entered: " + Value, Toast.LENGTH_SHORT).show();
                }
                catch(SQLException ex)
                {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
