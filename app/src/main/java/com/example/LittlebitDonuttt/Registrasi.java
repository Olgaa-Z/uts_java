package com.example.LittlebitDonuttt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrasi extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String mSharedPrefFile = "akun";
    EditText nama, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        nama = findViewById(R.id.nama);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void simpan(View view) {
        mPreferences = getSharedPreferences(mSharedPrefFile, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();

        editor.putString("nama", nama.getText().toString());
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Berhasil Simpan", Toast.LENGTH_SHORT).show();
    }

    public void reset(View view) {
        nama.setText("");
        username.setText("");
        password.setText("");
    }

    public void login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}