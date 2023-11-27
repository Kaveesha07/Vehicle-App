package com.k_tech.asignment2_e2041363;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class VehicleManagerDB {
    //Vehicle Table Fields
    public static final String KEY_VehicleId = "VehicleNo";
    public static final String KEY_Type = "sVehicleType";
    public static final String KEY_Brand = "VehicleModel";
    public static final String KEY_Fuel = "FuelType";

    //Service Table Fields
    public static final String KEY_serviceNo = "serviceNo";
    public static final String KEY_serviceName = "serviceName";
    public static final String KEY_serviceDate = "serviceDate";
    public static final String KEY_serviceDesc = "serviceDesc";

    //Db Info
    private final String DATABASE_NAME = "VehicleManagerDB";
    private final String VEHICLE_TABLE = "vehiclemanagertable";
    private final int DATABASE_VERSION = 1;

    private DBHelper ourHelper;
    private final Context outContext;
    private SQLiteDatabase ourDatabase;

    public VehicleManagerDB (Context context)
    {
        this.outContext = context;
    }

    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper (Context context)
        {
            super(context, DATABASE_NAME,null, DATABASE_VERSION);
        }
        @Override
        //check table existence
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //only run when the database version is changed
            //must backup the data before chanfing the version
            db.execSQL("DROP TABLE IF EXISTS " + VEHICLE_TABLE);
            onCreate(db);
        }

        @Override
        //create table Vehicle
        public void onCreate(SQLiteDatabase db) {

            String sqlCode = "CREATE TABLE " + VEHICLE_TABLE + " (" +
                    KEY_VehicleId + " TEXT PRIMARY KEY , " +
                    KEY_Type + " TEXT NOT NULL, " +
                    KEY_Brand + " TEXT NOT NULL," +
                    KEY_Fuel + " TEXT NOT NULL);";

            db.execSQL(sqlCode);
        }
    }

    public VehicleManagerDB open() throws SQLException
    {
        ourHelper = new DBHelper(outContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        ourHelper.close();
    }

    //write data to vehicle table
    public long createEntry(String VehicleNo, String sVehicleType,String VehicleModel,String FuelType)
    {
        ContentValues cv = new ContentValues();
        cv.put(KEY_VehicleId,VehicleNo);
        cv.put(KEY_Type,sVehicleType);
        cv.put(KEY_Brand,VehicleModel);
        cv.put(KEY_Fuel,FuelType);

        return  ourDatabase.insert(VEHICLE_TABLE,null,cv);
    }
    // write data to service table
    public long createEntry2(String serviceNo, String serviceName,String serviceDate,String serviceDesc)
    {
        ContentValues cv = new ContentValues();
        cv.put(KEY_VehicleId,serviceNo);
        cv.put(KEY_Type,serviceName);
        cv.put(KEY_Brand,serviceDate);
        cv.put(KEY_Fuel,serviceDesc);

        return  ourDatabase.insert(VEHICLE_TABLE,null,cv);
    }

    //public String getData()
    //{
        /*String [] columns = new String[] {KEY_VehicleId,KEY_Type, KEY_Brand,KEY_Fuel};
        Cursor c = ourDatabase.query(VEHICLE_TABLE,columns,
                null,
                null,
                null,
                null,
                null);
        String result = "";

        int iVehicleID = c.getColumnIndex(KEY_VehicleId);
        int iVehicleName = c.getColumnIndex(KEY_Type);
        int iVehicleBrand = c.getColumnIndex(KEY_Brand);
        int iFuel = c.getColumnIndex(KEY_Fuel);

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result = result + c.getString(iVehicleID) + ": " + c.getString(iVehicleName) + " - " + c.getString(iVehicleBrand) + "- " + c.getString(iFuel) + "  \n ";
        }
        c.close();
        return result;

         */


    //}
    //View vehicle data from database
    public Cursor viewData(){
        SQLiteDatabase db = this.ourHelper.getReadableDatabase();
        String query = "Select * From "+VEHICLE_TABLE;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }



}
