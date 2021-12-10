package com.example.LittlebitDonuttt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AyamAdapter.ItemClickListener {

    private RecyclerView recyclerView;
    private AyamAdapter adapter;
    private ArrayList<Ayam> ayamList;
    private int total = 0;
    private TextView totalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ayamList = new ArrayList<>();
        totalView = (TextView) findViewById(R.id.total);
        setTotal(0);
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new AyamAdapter(ayamList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);


//        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//                TextView total = (TextView) rv.findViewById(R.id.harga);
//                setTotal(Integer.valueOf(String.valueOf(total.getText())));
//                return true;
//            }
//
//            @Override
//            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.call_center) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Call Center");
            alert.setMessage("(123) 567 894");
            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert.show();
        } else if (item.getItemId() == R.id.sms_center) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("SMS Center");
            alert.setMessage("+62 8512348675");
            alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert.show();
        } else if (item.getItemId() == R.id.maps) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            // Using the coordinates for Google headquarters.
            String data = "geo:-6.90705532547378, 109.52662909450777?z=14";
            intent.setData(Uri.parse(data));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else {
            Intent intent = new Intent(MainActivity.this, UpdateUser.class);
            startActivity(intent);
        }

        return true;
    }

    public void addData() {
        String[] title_list = getResources().getStringArray(R.array.title);
        String[] harga_list = getResources().getStringArray(R.array.harga);
        String[] description_list = getResources().getStringArray(R.array.descriptions);
        TypedArray imgae_list = getResources().obtainTypedArray(R.array.image);

        for (int i = 0; i < title_list.length; i++) {
            ayamList.add(new Ayam(title_list[i], Integer.parseInt(harga_list[i]), imgae_list.getResourceId(i, 0), description_list[i]));
        }
    }

    public void setTotal(int total) {
        this.total = this.total + total;
        totalView.setText(String.valueOf(this.total));
    }

    public void reset(View view) {
        this.total = 0;
        setTotal(0);
    }

    @Override
    public void onClick(View view, int position) {
        final Ayam ayam = ayamList.get(position);

        switch (view.getId()) {
            case R.id.title:
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("title", ayam.getTitle());
                intent.putExtra("harga", ayam.getHarga());
                intent.putExtra("image", ayam.getImage());
                intent.putExtra("description", ayam.getDescription());
                startActivity(intent);
                break;
            case R.id.image:
                setTotal(ayam.getHarga());
            default:
        }
    }

    public void cekOut(View view) {
//        final Ayam ayam = ayamList.get();

        Intent intent = new Intent(MainActivity.this, Pembayaran.class);
        intent.putExtra("total", total);
        startActivity(intent);
    }
}