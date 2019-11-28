package com.jojo.moviecatalogue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jojo.moviecatalogue.com.jojo.fragments.MovieFragment;
import com.jojo.moviecatalogue.com.jojo.fragments.TvShowFragment;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = getSupportActionBar();
        loadFragment(new MovieFragment());
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav_main);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment fragment;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_movie:
                            toolbar.setTitle("Movie");
                            fragment = new MovieFragment();
                            loadFragment(fragment);
                            return true;
                        case R.id.nav_tvShow:
                            toolbar.setTitle("Tv Show");
                            fragment = new TvShowFragment();
                            loadFragment(fragment);
                            return true;
                    }
                    return false;
                }
            };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fr_container, fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.language) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
