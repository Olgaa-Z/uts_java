package com.example.LittlebitDonuttt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String mSharedPrefFile = "akun";
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void registrasi(View view) {
        Intent intent = new Intent(this, Registrasi.class);
        startActivity(intent);
    }

    public void reset(View view) {
        username.setText("");
        password.setText("");
    }

    public void login(View view) {
        mPreferences = getSharedPreferences(mSharedPrefFile, Activity.MODE_PRIVATE);

        boolean satu = username.getText().toString().equals(mPreferences.getString("username", null));
        boolean dua = password.getText().toString().equals(mPreferences.getString("password", null));

        if (satu && dua){
            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            return;
        }
        Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
        return;
    }
}