package com.example.labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity2 extends AppCompatActivity {
    private Button btnVCap, btnimg;
    private VideoView vdCap;
    private static final int vd_capture_code = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnVCap = findViewById(R.id.btnVCap);
        btnimg = findViewById(R.id.btn_img);
        vdCap = findViewById(R.id.capVV);

        btnVCap.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            //noinspection deprecation
            startActivityForResult(intent, vd_capture_code);
        });
        btnimg.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if ( requestCode == vd_capture_code) {
                Uri vduri = data.getData();
                vdCap.setVideoURI(vduri);

                vdCap.start();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "cancelled", Toast.LENGTH_SHORT).show();
            }
        }

    }
}