package com.example.mytest;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Timestamp;

public class DataBAseHelper extends SQLiteOpenHelper {

    private Context context;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "search.db";

    public DataBAseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BarCode.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+BarCode.BARCODE_TB);
        onCreate(sqLiteDatabase);
    }

    @SuppressLint("Range")
    public BarCode sarch_in_database (String IdBarCode){

        SQLiteDatabase db = this.getReadableDatabase();
        BarCode info = null;

        String[] columns = {BarCode.IDBARCODE,BarCode.ASSET_DESCRIPTION,BarCode.ASSET_CATEGORY};
        String selection = BarCode.IDBARCODE+" = ?";
        Cursor cursor = db.query(BarCode.BARCODE_TB,
                columns,
                selection,
                new String[]{IdBarCode},
                null,
                null,
                null);

        int cursercount = cursor.getCount();
        if (cursor !=null && cursercount>0){
            cursor.moveToFirst();

            info = new BarCode(
                    cursor.getString(cursor.getColumnIndex(BarCode.IDBARCODE)),
                    cursor.getString(cursor.getColumnIndex(BarCode.ASSET_DESCRIPTION)),
                    cursor.getString(cursor.getColumnIndex(BarCode.ASSET_CATEGORY))
            );
            cursor.close();
            db.close();
        }
        return info;
    }
    public long insertbarcode(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BarCode.ASSET_DESCRIPTION,"Mercedes");
        values.put(BarCode.ASSET_CATEGORY,"Cars");
        long id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"meeting table");
//        values.put(BarCode.ASSET_CATEGORY,"Furniture");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Sharp Calculator");
//        values.put(BarCode.ASSET_CATEGORY,"Equipments");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Compressor");
//        values.put(BarCode.ASSET_CATEGORY,"Electrical Equipments");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Powder Fire extinguisher");
//        values.put(BarCode.ASSET_CATEGORY,"Fire extinguisher");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Optas Telephone");
//        values.put(BarCode.ASSET_CATEGORY,"Telephone");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Samsung Printer");
//        values.put(BarCode.ASSET_CATEGORY,"Printer");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"MoneyGram Fax");
//        values.put(BarCode.ASSET_CATEGORY,"Fax");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Beta Machine");
//        values.put(BarCode.ASSET_CATEGORY,"Photocopier Machine");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Cassio Calculator");
//        values.put(BarCode.ASSET_CATEGORY,"Calculator");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"work stationdes");
//        values.put(BarCode.ASSET_CATEGORY,"Furniture");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Volks Wagen");
//        values.put(BarCode.ASSET_CATEGORY,"Cars");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Surround System");
//        values.put(BarCode.ASSET_CATEGORY,"Electrical Equipments");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Attendance Machine");
//        values.put(BarCode.ASSET_CATEGORY,"Electrical Equipments");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"LG LCD 32");
//        values.put(BarCode.ASSET_CATEGORY,"Television & Video");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Smoke Detector");
//        values.put(BarCode.ASSET_CATEGORY,"Alarm System");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"CISCO PC");
//        values.put(BarCode.ASSET_CATEGORY,"Computer Machine");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"HP PC");
//        values.put(BarCode.ASSET_CATEGORY,"Computer Machine");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"HP Printer");
//        values.put(BarCode.ASSET_CATEGORY,"Printer");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Planet Machine");
//        values.put(BarCode.ASSET_CATEGORY,"Planet Machine");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Metal Curtain");
//        values.put(BarCode.ASSET_CATEGORY,"Metal Curtain");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"White Curtains");
//        values.put(BarCode.ASSET_CATEGORY,"Curtain");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Meeting Table 220x110x72.2 ");
//        values.put(BarCode.ASSET_CATEGORY,"Desks & Tables");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Side Table");
//        values.put(BarCode.ASSET_CATEGORY,"Desks & Tables");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
//        values.put(BarCode.ASSET_DESCRIPTION,"Big Wooden Cabinet");
//        values.put(BarCode.ASSET_CATEGORY,"Cabinet");
//        id = db.insert(BarCode.BARCODE_TB,null,values);
        Log.e("Tofiq",String.valueOf(id));
        db.close();
        return id;
    }
    public void deletebarcode(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(BarCode.BARCODE_TB,BarCode.IDBARCODE+" > ?",new String[]{"25"});
        db.close();

    }
}
