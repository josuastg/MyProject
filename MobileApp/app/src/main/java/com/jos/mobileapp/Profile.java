package com.jos.mobileapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Profile extends AppCompatActivity {
    EditText username, password, email, namalengkap, phone;
    Button btnSave;
    TextView textViewPassword;

    public static final String FILENAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        namalengkap = findViewById(R.id.namalengkap);
        phone = findViewById(R.id.phone);
        btnSave = findViewById(R.id.btnSave);
        textViewPassword = findViewById(R.id.textViewPassword);

        btnSave.setVisibility(View.GONE);
        username.setEnabled(false);
        password.setVisibility(View.GONE);
        textViewPassword.setVisibility(View.GONE);
        namalengkap.setEnabled(false);
        email.setEnabled(false);
        phone.setEnabled(false);

        bacaFileLogin();
    }

    void bacaFileLogin() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);
        if (file.exists()) {
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br =
                        new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
            String data = text.toString();
            String[] dataUser = data.split(";");
            bacaDataUser(dataUser[0]);

        }
    }

    void bacaDataUser(String fileName) {
        File sdcard = getFilesDir();

        File file = new File(sdcard, fileName);
        if (file.exists()) {
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br =
                        new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null) {
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
            String data = text.toString();
            String[] dataUser = data.split(";");

            username.setText(dataUser[0]);
            namalengkap.setText(dataUser[2]);
            email.setText(dataUser[3]);
            phone.setText(dataUser[4]);


        } else {
            Toast.makeText(this, "User Tidak Ditemukan",
                    Toast.LENGTH_SHORT).show();
        }
    }
            @Override
            public boolean onCreateOptionsMenu (Menu menu){
                getMenuInflater().inflate(R.menu.menu, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected (MenuItem item){
                switch (item.getItemId()) {
                    case R.id.action_logout:
                        tampilkanDialogKonfirmasiLogout();
                        break;
                }
                return super.onOptionsItemSelected(item);
            }

            void hapusFile () {
                File file = new File(getFilesDir(), FILENAME);
                if (file.exists()) {
                    file.delete();
                }
            }
            void tampilkanDialogKonfirmasiLogout () {
                new AlertDialog.Builder(this)
                        .setTitle("Logout")
                        .setMessage("Apakah Anda yakin ingin Logout?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                hapusFile();
                                Intent intent = new Intent(Profile.this, Login.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        }




