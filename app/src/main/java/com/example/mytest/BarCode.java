package com.example.mytest;

public class BarCode {
    String IDBarCode;
    String Asset_Description;
    String Asset_Category;

    public String getIDBarCode() {
        return IDBarCode;
    }

    public void setIDBarCode(String IDBarCode) {
        this.IDBarCode = IDBarCode;
    }

    public String getAsset_Category() {
        return Asset_Category;
    }

    public String getAsset_Description() {
        return Asset_Description;
    }

    public void setAsset_Category(String asset_Category) {
        Asset_Category = asset_Category;
    }

    public void setAsset_Description(String asset_Description) {
        Asset_Description = asset_Description;
    }
    public BarCode(String IDBarCode,String Asset_Description,String Asset_Category){
        this.IDBarCode = IDBarCode;
        this.Asset_Category = Asset_Category;
        this.Asset_Description = Asset_Description;
    }
    public static final String BARCODE_TB = "TBBarCode";
    public static final String IDBARCODE = "BarCode";
    public static final String ASSET_DESCRIPTION = "Asset_Description";
    public static final String ASSET_CATEGORY = "Asset_Category";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + BARCODE_TB + "("
            + IDBARCODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ASSET_DESCRIPTION + " TEXT, "
            + ASSET_CATEGORY + " TEXT" + ");";
}
