package com.example.mytest;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "BbarCode")
public class BarCode implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long IDBarCode;

    @ColumnInfo(name = "Asset_Description")
    private String Asset_Description;

    @ColumnInfo(name = "Asset_Category")
    private String Asset_Category;

    public void setAsset_Description(String asset_Description) {
        Asset_Description = asset_Description;
    }

    public void setAsset_Category(String asset_Category) {
        Asset_Category = asset_Category;
    }

    public void setIDBarCode(int IDBarCode) {
        this.IDBarCode = IDBarCode;
    }

    public String getAsset_Description() {
        return Asset_Description;
    }

    public String getAsset_Category() {
        return Asset_Category;
    }

    public long getIDBarCode() {
        return IDBarCode;
    }
}
