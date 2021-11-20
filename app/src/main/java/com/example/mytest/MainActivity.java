package com.example.mytest;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {

    TextView[] textView = new TextView[4];
    EditText editText;
    DataBAseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView[0] = findViewById(R.id.textview);
        textView[1] = findViewById(R.id.textview1);
        textView[2] = findViewById(R.id.textview2);
        textView[3] = findViewById(R.id.textview3);
        editText = findViewById(R.id.editText);
        db = new DataBAseHelper(getApplicationContext());
        long id = db.insertbarcode();
//        id = db.insertbarcode();
//        db.deletebarcode();
    }
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    textView[2].setText(result.getContents());
                    final BarCode info = db.sarch_in_database(result.getContents());
                    if (info == null){
                        textView[3].setText("Not Found Information about this BarCode");
                        textView[1].setText("");
                        textView[0].setText("");
                    }else {
                        textView[1].setText(info.getIDBarCode());
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

    public void OnSearch(View view) {
        if (editText.getText().toString().isEmpty()){
            editText.findFocus();
        }else {
            textView[2].setText(editText.getText().toString());
            final BarCode info = db.sarch_in_database(textView[2].getText().toString());
            if (info == null) {
                textView[3].setText("Not Found Information about this BarCode");
                textView[1].setText("");
                textView[0].setText("");
            } else {
                textView[1].setText(info.getIDBarCode());
                textView[3].setText(info.getAsset_Description());
                textView[0].setText(info.getAsset_Category());
            }
        }
    }
}