package com.example.labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn = findViewById(R.id.playbtn);

        mp = new MediaPlayer();
        mp = MediaPlayer.create(getApplicationContext(),R.raw.arambh);

        btn.setOnClickListener(v -> {
            if (mp.isPlaying()){
                mp.pause();
                btn.setText("Play");
            }
            else {
                mp.start();
                btn.setText("Pause");
            }
        });


    }
}