package jos.GBI.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    public TextView tvObaja, tvAyat;
    public Button btnAbout, btnNewUser, btnLogin;
    public ImageView ivGbi;
    public EditText etUsername, etPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvObaja = findViewById(R.id.tvObaja);
        tvAyat = findViewById(R.id.tvAyat);
        btnAbout = findViewById(R.id.btnAbout);
        btnNewUser = findViewById(R.id.btnNewUser);
        btnLogin = findViewById(R.id.btnLogin);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etUsername.getText().toString().equals(etUsername) && etPassword.getText().toString().equals(etPassword)){
                    Toast.makeText(Main2Activity.this, "Selamat anda berhasil login", Toast.LENGTH_SHORT).show();
                }
                if (etUsername.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()) {
                    Toast.makeText(Main2Activity.this, "Username dan password harus diisi !", Toast.LENGTH_LONG).show();
                } Intent i = new Intent(Main2Activity.this, Home.class);
                startActivity(i);

            }
        });
        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, NewUser.class);
                startActivity(intent);
            }
        });

            }
        }





