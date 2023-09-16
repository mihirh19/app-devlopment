package com.example.labapp;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.AsyncTask;

public class MyaynscTask extends AsyncTask<String, String, String> {
        ProgressDialog pd;
        MediaPlayer mp;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = ProgressDialog.show(pd.getContext(), "Please wait", "Loading...");
        }


        @Override
        protected String doInBackground(String... strings) {
            mp = new MediaPlayer();
            mp = MediaPlayer.create(pd.getContext(),R.raw.arambh);
            mp.start();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;

        }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        pd.dismiss();
        mp.pause();
    }
}
