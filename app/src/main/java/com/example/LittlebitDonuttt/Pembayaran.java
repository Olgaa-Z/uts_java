package com.example.LittlebitDonuttt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

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

        StringBuilder tmp = new StringBuilder();


        if (bundle != null){
            int btotal = (int) bundle.get("total");
            ArrayList<String> data = (ArrayList<String>) intent.getSerializableExtra("data_tampung");

            String items = (String) bundle.get("title");

            for (int i =0; i < data.size(); i++){
                tmp.append(data.get(i)).append(",");
            }


            transaksi.setText(String.valueOf(tmp));
            pembayaran.setText(String.valueOf(btotal));
        }
    }
}