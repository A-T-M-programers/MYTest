package com.example.mytest;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.sql.Timestamp;

@Database(entities = {BarCode.class},version = 1,exportSchema = false)
public abstract class DataBAseHelper extends RoomDatabase {


    public abstract IBarCode iBarCode();

    private static DataBAseHelper INSTANCE;

    public static DataBAseHelper getDbInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),DataBAseHelper.class,"DataBase.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return INSTANCE;
    }
}
