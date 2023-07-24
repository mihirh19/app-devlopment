package com.example.labapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;

public class DetailsActivity  extends AppCompatActivity {

        FileInputStream fstream;
        Intent intent;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.details);
            TextView result = (TextView) findViewById(R.id.textView5);
            Button back = (Button) findViewById(R.id.button2);
            try {
                fstream = openFileInput("user_details");
                int i;
                StringBuffer buffer = new StringBuffer();
                while ((i = fstream.read()) != -1) {
                    buffer.append((char) i);
                }
                String [] details = buffer.toString().split("\n");
                result.setText("Name: " + details[0] + "\n" + "Password: " + details[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(DetailsActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });

        }
}
