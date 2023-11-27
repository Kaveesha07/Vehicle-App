package com.k_tech.asignment2_e2041363;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class VehicleList extends AppCompatActivity {
    //intialize buttons
    Button btnaddVehicle, btnremoveVehicle, btnbackHome;
    //intialize List View
    ListView list;
    //intialize DBObject
    VehicleManagerDB vehicleManagerDB;
    //intialize ArrayList
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set xml View
        setContentView(R.layout.activity_vehiclelist);

        //Get button IDs
        btnaddVehicle = (Button) findViewById(R.id.btnaddVehicle);
        btnremoveVehicle = (Button) findViewById(R.id.btnremoveVehicle);
        btnbackHome = (Button) findViewById(R.id.btnbackHome);

        //Get List IDs
        list = findViewById(R.id.list);
        listItem = new ArrayList<>();
        //viewData();
        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = list.getItemAtPosition(i).toString();
                Toast.makeText(VehicleList.this,""+text,Toast.LENGTH_SHORT).show();

        });*/

        {
            //Back Button Function
            btnbackHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                    mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(mainActivityIntent);
                    ;
                }
            });
            //Add Button Function
            btnaddVehicle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent("com.k_tech.asignment2_e2041363.VehicleInfo");
                    startActivity(i);
                }
            });
            //Db connectors
        /*private void viewData() {
            Cursor cursor = vehicleManagerDB.viewData();
            if (cursor.getCount() == 0){
                Toast.makeText(VehicleList.this,"No data show",Toast.LENGTH_SHORT).show();
            }
            else   {
                while(cursor.moveToNext() ) {
                    listItem.add(cursor.getString(1));

                }
                adapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, listItem);
                list.setAdapter(adapter);
            }
        }

         */

        }
    }

}
