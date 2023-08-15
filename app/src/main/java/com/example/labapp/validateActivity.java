package com.example.labapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class validateActivity extends AppCompatActivity {
    SharedPreferences prf;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.validate_main);
        TextView result = (TextView) findViewById(R.id.textView3);
        Button logout = (Button) findViewById(R.id.button2);
        prf  = getSharedPreferences("user_details", MODE_PRIVATE);
        intent  = new Intent(validateActivity.this, MainActivity.class);
        result.setText("hello , " + prf.getString("username", null));
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = prf.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
            }
        });
    }

}
