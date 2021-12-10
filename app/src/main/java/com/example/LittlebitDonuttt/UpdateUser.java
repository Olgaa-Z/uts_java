package com.example.LittlebitDonuttt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateUser extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String mSharedPrefFile = "akun";
    EditText nama, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        nama = findViewById(R.id.nama);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        mPreferences = getSharedPreferences(mSharedPrefFile, Activity.MODE_PRIVATE);
        nama.setText(mPreferences.getString("nama", null));
        username.setText(mPreferences.getString("username", null));
        password.setText(mPreferences.getString("password", null));
    }

    public void update(View view) {
        mPreferences = getSharedPreferences(mSharedPrefFile, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mPreferences.edit();

        editor.putString("nama", nama.getText().toString());
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();
        Toast.makeText(getApplicationContext(), "Berhasil Simpan", Toast.LENGTH_SHORT).show();
    }

    public void cancel(View view) {
        Intent intent = new Intent(UpdateUser.this, MainActivity.class);
        startActivity(intent);
    }
}