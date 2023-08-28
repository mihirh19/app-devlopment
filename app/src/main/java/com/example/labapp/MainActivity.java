package com.example.labapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ImageView imgCap;
    private static final int img_capture_code=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCap = findViewById(R.id.btnCap);
        Button btnVCap = findViewById(R.id.btnVd);
        imgCap= findViewById(R.id.capIV);

        btnCap.setOnClickListener(v -> {
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            //noinspection deprecation
            startActivityForResult(intent,img_capture_code);
        });

        btnVCap.setOnClickListener(v ->{
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == img_capture_code) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                Bitmap bp = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");
                imgCap.setImageBitmap(bp);
                MediaStore.Images.Media.insertImage(getContentResolver(), bp, "image", "image info");
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "cancelled", Toast.LENGTH_SHORT).show();
            }

        }
    }
}