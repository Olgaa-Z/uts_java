package com.example.LittlebitDonuttt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Pembayaran extends AppCompatActivity {

    TextView transaksi, pembayaran, itemsatu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        transaksi = findViewById(R.id.total);
        pembayaran = findViewById(R.id.pembayaran);
        itemsatu = findViewById(R.id.item1);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            int btotal = (int) bundle.get("total");
            String items = (String) bundle.get("title");

            transaksi.setText(String.valueOf(btotal));
            pembayaran.setText(String.valueOf(btotal));
        }
    }
}