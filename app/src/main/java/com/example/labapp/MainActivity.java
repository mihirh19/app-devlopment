package com.example.labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity {
        EditText user,pass;
        Button saveBtn;
        FileOutputStream fstream;
        Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.editTextText);
        pass  = findViewById(R.id.editTextText2);
        saveBtn = findViewById(R.id.button);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username  = user.getText().toString()  + "\n";
                String password = pass.getText().toString() + "\n";
                try {
                    fstream =  openFileOutput("user_details", Context.MODE_PRIVATE);
                    fstream.write(username.getBytes());
                    fstream.write(password.getBytes());
                    fstream.close();
                    Toast.makeText(getApplicationContext(), "Details Saved Successfully",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, DetailsActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}