package com.example.LittlebitDonuttt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView title, harga, description;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = (TextView) findViewById(R.id.title);
        harga = (TextView) findViewById(R.id.harga);
        description = (TextView) findViewById(R.id.description);
        image = (ImageView) findViewById(R.id.image);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            String btitle = (String) bundle.get("title");
            int bharga = (int) bundle.get("harga");
            String bdesc = (String) bundle.get("description");
            int bimage = (int) bundle.get("image");

            title.setText(btitle);
            harga.setText(String.valueOf(bharga));
            description.setText(bdesc);
            image.setImageResource(bimage);
        }
    }
}