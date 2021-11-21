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
//        insertdb();
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
}