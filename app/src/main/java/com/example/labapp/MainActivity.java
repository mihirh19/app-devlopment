package com.example.labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText User;
    EditText pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         User = (EditText) findViewById(R.id.editTextTextEmailAddress4);
         pass = (EditText) findViewById(R.id.editTextTextPassword);
         login = (Button) findViewById(R.id.button2);

         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String v1 = User.getText().toString();
                 String v2 = pass.getText().toString();

                 if (v1.equals("admin") && v2.equals("admin")){
                     Toast.makeText(getBaseContext(), "login_sucess", Toast.LENGTH_LONG).show();

                 }
                 else {
                     Toast.makeText(getBaseContext(), "unsuccessful", Toast.LENGTH_LONG).show();
                 }
             }
         });


    }
}