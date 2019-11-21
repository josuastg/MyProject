package com.jos.mobileapp.gbi.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.jos.mobileapp.gbi.R;

import org.jetbrains.annotations.Nullable;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageView;
    static int  PReqCode = 1;
    static int REQUESCODE = 1;
    Uri pickImgUri;
    private FirebaseAuth mAuth;

    private EditText regName,regPassword,regPassword2,regEmail;
    private ProgressBar progressBar;
    private Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Create Your Account");
        //inu views
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        regPassword2 = findViewById(R.id.regPassword2);
        regName = findViewById(R.id.regName);
        progressBar = findViewById(R.id.progressBar2);
        regBtn = findViewById(R.id.regBtn);
        progressBar.setVisibility(View.INVISIBLE);
        mAuth = FirebaseAuth.getInstance();
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regBtn.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                final String email = regEmail.getText().toString();
                final String password = regPassword.getText().toString();
                final String password2 = regPassword2.getText().toString();
                final String username  = regName.getText().toString();
                if (email.isEmpty() || username.isEmpty() || password.isEmpty() || !password.equals(password2) ) {

                    //bila tidak diisi tampil pesan harus diisi semuanya
                    // metode create user account akan terbuat jika email valid
                    showMessage("Please Verify all fields");
                    regBtn.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                }
                else {
                    //user bisa membuat akun

                    CreateUserAccount(email,password,username);
                }
                updateUI();

            }
        });

        imageView = findViewById(R.id.regUserPhoto);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 22) {
                    checkAndRequestforPermission();
                }
                else
                    {
                    openGallery();
                }
            }


    });
}

    private void CreateUserAccount(String email, String password, final String username) {
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //akun user berhasil terbentuk
                            showMessage("Account Created");
                            //setelah akun user terbentuk kita butuh tuk memperbarui foto profil dan username
                            updateUserInfo(username,pickImgUri,mAuth.getCurrentUser());

                        }
                        else {
                            //akun tidak berhasil terbentuk
                            showMessage("Account Created Failed" + task.getException().getMessage());
                            regBtn.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                });
    }
//update user and photo name
    private void updateUserInfo(final String username, Uri pickImgUri, final FirebaseUser currentUser) {
        //first we need to update user photo to firebase storage and get url

        StorageReference mStorage = FirebaseStorage.getInstance().getReference().child("user photo");
        final StorageReference imageFilePath = mStorage.child(pickImgUri.getLastPathSegment());
        imageFilePath.putFile(pickImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                //gambar berhasil diupload
                //sekarang bisa dapat url gambar

                imageFilePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //isi uri gambar user url

                        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                .setDisplayName(username)
                                .setPhotoUri(uri)
                                .build();

                    }
                });


            }
        });




    }

    private void updateUI() {
        Intent homeActivity = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(homeActivity);
        finish();


    }

    private void showMessage(String mesaage) {

        Toast.makeText(getApplicationContext(),mesaage,Toast.LENGTH_LONG).show();
    }

    private void openGallery() {
                //TODO: open gallery intent and wait for user to pick an image
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,REQUESCODE);
            }

            private void checkAndRequestforPermission() {
                if (ContextCompat.checkSelfPermission(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(RegisterActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                        Toast.makeText(RegisterActivity.this, "Please accpept for required permission", Toast.LENGTH_SHORT).show();

                    } else {
                        ActivityCompat.requestPermissions(RegisterActivity.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                PReqCode);
                    }
                } else
                    openGallery();
            }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUESCODE && data != null) {
            //the user has successfully picked an image
            //kita butuh menyimpan  untuk variabel uri
        pickImgUri = data.getData();
        imageView.setImageURI(pickImgUri);
        }

    }
}


