package com.jojo.listfavoritesdrum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDrummer;
    private ArrayList<Drummer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvDrummer = findViewById(R.id.rv_drummers);
        rvDrummer.setHasFixedSize(true);
        list.addAll(DrummersData.getListData());
        showRecyclerList();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (item.getItemId() == R.id.profile){
            startActivity(new Intent(this, ProfileAct.class));

        }
        return true;
    }

    private void showRecyclerList(){
        rvDrummer.setLayoutManager(new LinearLayoutManager(this));
        ListDrummerAdapter listDrummerAdapter = new ListDrummerAdapter(list);
        rvDrummer.setAdapter(listDrummerAdapter);

        listDrummerAdapter.setOnItemClickCallback(new ListDrummerAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Drummer data) {
            showSelectedDrummer(data);


            }
        });
    }
    private void showSelectedDrummer(Drummer drummer){

        String name =  drummer.getName();
        String detail = drummer.getDetail();

        int photo = drummer.getPhoto();


            Intent intent = new Intent(getApplicationContext(), DetailDrummer.class);
            intent.putExtra("drummer", name);
            intent.putExtra("detail", detail);
            intent.putExtra("photo", photo);
            intent.putExtra("videos", drummer.getVideo());


//        intent.putExtra("photo", drummer.getPhoto());
        startActivity(intent);

    }
}
