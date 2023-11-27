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

public class VehicleInfo extends AppCompatActivity {
    //intialize buttons
    Button btnsubmit,btnBack;
    //intialize Edit text
    EditText vehicleNo,vehicleModel;
    //intialize Spinner View
    Spinner s1,s2;
    //intialize String Array
    String [] vehicleType,fuelType;
    //intialize Counter
    long Value;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set xml View
        setContentView(R.layout.activity_vehicleinfo);

        //Get button IDs
        vehicleType = getResources().getStringArray(R.array.vehicleType);
        fuelType = getResources().getStringArray(R.array.fuelType);
        btnsubmit =(Button) findViewById(R.id.btnsubmit);
        btnBack =(Button) findViewById(R.id.btnBack);
        vehicleNo = (EditText) findViewById(R.id.VehicleNo);
        vehicleModel = (EditText) findViewById(R.id.VehicleModel);

        //Back Button Function
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), VehicleList.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(mainActivityIntent);;;
            }
        });
        s1 = (Spinner) findViewById(R.id.sVehicleType);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vehicleType);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                int index = arg0.getSelectedItemPosition();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) { }
        });
        s2 = (Spinner) findViewById(R.id.FuelType);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fuelType);
        s2.setAdapter(adapter2);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3)
            {
                int index = arg0.getSelectedItemPosition();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) { }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String VehicleNo = vehicleNo.getText().toString().trim();
                String VehicleBrand = vehicleModel.getText().toString().trim();

                String vehicleTypes = vehicleType[s1.getSelectedItemPosition()];
                String fuelTypes = fuelType[s1.getSelectedItemPosition()];

                try {
                    VehicleManagerDB db = new VehicleManagerDB(getApplicationContext());
                    db.open();
                    Value = db.createEntry(VehicleNo,vehicleTypes,VehicleBrand,fuelTypes);
                    db.close();
                    Toast.makeText(getApplicationContext(), "Successfully Entered: " + Value, Toast.LENGTH_SHORT).show();
                }
                catch(SQLException ex)
                {
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
