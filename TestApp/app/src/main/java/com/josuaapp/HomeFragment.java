package com.josuaapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.josuaapp.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout visimisi = view.findViewById(R.id.btn_visi_misi);
        LinearLayout profile = view.findViewById(R.id.btn_profile);
        LinearLayout journey = view.findViewById(R.id.btn_journey);
        LinearLayout contacts = view.findViewById(R.id.btn_contacts);

        visimisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotovisi = new Intent(getActivity(), VisiMisiAct.class);
                startActivity(gotovisi);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoprofile = new Intent(getActivity(), ProfileAct.class);
                startActivity(gotoprofile);
            }
        });
        journey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotojourney = new Intent(getActivity(), JourneyAct.class);
                startActivity(gotojourney);
            }
        });
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocontacts = new Intent(getActivity(), ContactsAct.class);
                startActivity(gotocontacts);
            }
        }); return view;

    }

}
