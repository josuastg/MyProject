package com.josuaapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.josuaapp.ProfileFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_profile, container, false);
       TextView  tvProfile = view.findViewById(R.id.tvProfile);
        TextView  tvSettings = view.findViewById(R.id.tvSettings);
        TextView  tvSendFeed = view.findViewById(R.id.tvSendFeedback);
        TextView  tvLogout = view.findViewById(R.id.tvLogout);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoLogout = new Intent(getActivity(), LoginActivity.class);
                startActivity(gotoLogout);
            }
        });

        tvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoprofile = new Intent(getActivity(), MyProfileAct.class);
                startActivity(gotoprofile);
            }
        });
        tvSendFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoSendFeed = new Intent(getActivity(), SendFeedbackAct.class);
                startActivity(gotoSendFeed);
            }
        });
        tvSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoSettings= new Intent(getActivity(), SettingsAct.class);
                startActivity(gotoSettings);
            }
        }); return view;

    }

}
