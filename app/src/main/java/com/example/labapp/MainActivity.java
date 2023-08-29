package com.example.labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        DrawingView drawing = new DrawingView(this);
        IndiaFlagView india = new IndiaFlagView(this);
        setContentView(india);
    }
}