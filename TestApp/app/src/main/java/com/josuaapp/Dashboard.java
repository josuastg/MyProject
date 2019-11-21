package com.josuaapp;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    private HomeFragment homeFragment;
    private TimelineFragment timelineFragment;
    private ServicesFragment servicesFragment;
    private ProfileFragment profileFragment;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(homeFragment);
                    return true;
                case R.id.navigation_Timeline:
                    setFragment(timelineFragment);
                    return true;
                case R.id.navigation_service:
                    setFragment(servicesFragment);
                    return true;
                case R.id.navigation_Profile:
                    setFragment(profileFragment);
                    return true;

                default:
                    return false;
            }
        }

    };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        homeFragment = new HomeFragment();
        timelineFragment = new TimelineFragment();
        servicesFragment = new ServicesFragment();
        profileFragment = new ProfileFragment();
        LinearLayout button = findViewById(R.id.btn_visi_misi) ;

        setFragment(homeFragment);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.mainFrame,fragment );
        fragmentTransaction.commit();

    }

}
