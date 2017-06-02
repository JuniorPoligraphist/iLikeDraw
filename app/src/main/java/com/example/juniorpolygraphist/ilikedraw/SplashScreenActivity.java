package com.example.juniorpolygraphist.ilikedraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SplashScreenActivity extends AppCompatActivity {

    private long time_thread = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        // new thread
        // create the splash screen activity
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    // set 2 second
                    sleep(time_thread);


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent goToMainActivity = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(goToMainActivity);
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // call finish();
        finish();
    }
}