package com.example.mytest;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView[] textView = new TextView[4];
    EditText editText;
    DataBAseHelper db;
    List<BarCode> lbarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView[0] = findViewById(R.id.textview);
        textView[1] = findViewById(R.id.textview1);
        textView[2] = findViewById(R.id.textview2);
        textView[3] = findViewById(R.id.textview3);
        editText = findViewById(R.id.editText);
        db = DataBAseHelper.getDbInstance(this);
        lbarcode = db.iBarCode().getAllBarCode();

    }
    @SuppressLint("SetTextI18n")
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    textView[2].setText(result.getContents());
                    BarCode info = search(lbarcode,result.getContents());
                    if (info == null){
                        textView[3].setText("Not Found Information about this BarCode");
                        textView[1].setText("");
                        textView[0].setText("");
                    }else {
                        textView[1].setText(String.valueOf(info.getIDBarCode()));
                        textView[3].setText(info.getAsset_Description());
                        textView[0].setText(info.getAsset_Category());
                    }
                }
            });

    public void onClick(View view) {
        ScanOptions options = new ScanOptions();
        options.setDesiredBarcodeFormats(ScanOptions.ONE_D_CODE_TYPES);
        options.setPrompt("Scan a barcode");
        options.setCameraId(0);  // Use a specific camera of the device
        options.setBeepEnabled(false);
        options.setBarcodeImageEnabled(true);
        barcodeLauncher.launch(options);
    }

    @SuppressLint("SetTextI18n")
    public void OnSearch(View view) {
        if (editText.getText().toString().isEmpty()){
            editText.findFocus();
        }else {
            BarCode info = new BarCode();
            textView[2].setText(editText.getText().toString());
            try {
                info = search(lbarcode, textView[2].getText().toString());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            if (info == null) {
                textView[3].setText("Not Found Information about this BarCode");
                textView[1].setText("");
                textView[0].setText("");
            } else {
                textView[1].setText(String.valueOf(info.getIDBarCode()));
                textView[3].setText(info.getAsset_Description());
                textView[0].setText(info.getAsset_Category());
            }
        }
    }
    public void insertdb(){

        BarCode barCode = new BarCode();

        barCode.setAsset_Description("Mercedes");
        barCode.setAsset_Category("Cars");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("meeting table");
        barCode.setAsset_Category("Furniture");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Sharp Calculator");
        barCode.setAsset_Category("Equipments");
        db.iBarCode().insertBarcode(barCode);
        barCode= new BarCode();
        barCode.setAsset_Description("Compressor");
        barCode.setAsset_Category("Electrical Equipments");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Powder Fire extinguisher");
        barCode.setAsset_Category("Fire extinguisher");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Optas Telephone");
        barCode.setAsset_Category("Telephone");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Samsung Printer");
        barCode.setAsset_Category("Printer");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("MoneyGram Fax");
        barCode.setAsset_Category("Fax");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Beta Machine");
        barCode.setAsset_Category("Photocopier Machine");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Cassio Calculator");
        barCode.setAsset_Category("Calculator");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("work stationdes");
        barCode.setAsset_Category("Furniture");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Volks Wagen");
        barCode.setAsset_Category("Cars");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Surround System");
        barCode.setAsset_Category("Electrical Equipments");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Attendance Machine");
        barCode.setAsset_Category("Electrical Equipments");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("LG LCD 32");
        barCode.setAsset_Category("Television & Video");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Smoke Detector");
        barCode.setAsset_Category("Alarm System");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("CISCO PC");
        barCode.setAsset_Category("Computer Machine");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("HP PC");
        barCode.setAsset_Category("Computer Machine");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("HP Printer");
        barCode.setAsset_Category("Printer");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Planet Machine");
        barCode.setAsset_Category("Planet Machine");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Metal Curtain");
        barCode.setAsset_Category("Metal Curtain");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("White Curtains");
        barCode.setAsset_Category("Curtain");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Meeting Table 220x110x72.2 ");
        barCode.setAsset_Category("Desks & Tables");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Side Table");
        barCode.setAsset_Category("Desks & Tables");
        db.iBarCode().insertBarcode(barCode);
        barCode = new BarCode();
        barCode.setAsset_Description("Big Wooden Cabinet");
        barCode.setAsset_Category("Cabinet");
        db.iBarCode().insertBarcode(barCode);

    }
    public BarCode search(List<BarCode> list,String id){
        BarCode barCode = null;
        for (int i = 0 ; i<list.size();i++){
            if (list.get(i).getIDBarCode() == Integer.parseInt(id)) {
                barCode = list.get(i);
                System.out.println(i);
                return barCode;
            }
        }
        return barCode;
    }

    public void SetData(View view) {
        if(lbarcode.size()==0) {
            insertdb();
            lbarcode = db.iBarCode().getAllBarCode();
        }
        else {
            Toast.makeText(MainActivity.this, "Exist Data", Toast.LENGTH_LONG).show();
        }
    }
}