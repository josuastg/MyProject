package com.jos.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class Register extends AppCompatActivity {
    EditText username, password, email, namalengkap, phone;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        namalengkap = findViewById(R.id.namalengkap);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidation()) {
                    simpanFileData();
                } else {
                    Toast.makeText(Register.this,
                            "Mohon Lengkapi Seluruh Data", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    boolean isValidation(){
    if(username.getText().toString().equals("") ||
        password.getText().toString().equals("") ||
            namalengkap.getText().toString().equals("")  ||
            email.getText().toString().equals("") ||
            phone.getText().toString().equals(""))  {
        return false;
    } else {
        return true;
        }
    }
void simpanFileData() {
String isiFile = username.getText().toString() + ";" + password.getText().toString() + ";"
+ namalengkap.getText().toString() + ";" + email.getText().toString() + ";" + phone.getText().toString();
    File file= new File(getFilesDir(), username.getText().toString());
    FileOutputStream outputStream = null;
    try{
        file.createNewFile();
        outputStream = new FileOutputStream(file, false);
        outputStream.write(isiFile.getBytes());
        outputStream.flush();
        outputStream.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show();
    onBackPressed();

    }
}


