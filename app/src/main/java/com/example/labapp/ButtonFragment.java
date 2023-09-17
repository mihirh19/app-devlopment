package com.example.labapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ButtonFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, container, false);
        Button back = v.findViewById(R.id.button3);

        back.setOnClickListener(v1 -> {
            startActivity(new Intent(getContext(), MainActivity.class));
        });
        // Inflate the layout for this fragment
        return v;
    }
}