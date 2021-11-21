package com.example.mytest;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface IBarCode {

    @Query("SELECT * FROM BbarCode;")
    List<BarCode> getAllBarCode();

    @Insert(onConflict = REPLACE)
    void insertBarcode(BarCode barCodes);

    @Delete
    void delete(BarCode barCodes);
}
