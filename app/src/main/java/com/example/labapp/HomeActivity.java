package com.example.labapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn = findViewById(R.id.playbtn);

        mp = new MediaPlayer();
        mp = MediaPlayer.create(getApplicationContext(),R.raw.arambh);

        btn.setOnClickListener(v -> {
            myAsyncTask task = new myAsyncTask();
                    task.execute("");
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
    private class myAsyncTask extends AsyncTask<String, String, String> {
        ProgressDialog pd;
        MediaPlayer md;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(HomeActivity.this,btn.getText().toString() , "Wait for 5 seconds", true, false);
            // This method is called before the task is executed

        }

        @Override
        protected void onProgressUpdate(String... values) {
            pd.setMessage("Wait for " + values[0] + " seconds");
        }

        @Override
        protected String doInBackground(String... strings) {
            publishProgress("5");
            try {
                for (int i = 0; i < 5; i++){
                    Thread.sleep(1000);
                    publishProgress(String.valueOf(5-i-1));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Done";
        }

        @Override
        protected void onPostExecute(String s) {
                    pd.dismiss();

        }
    }
}

