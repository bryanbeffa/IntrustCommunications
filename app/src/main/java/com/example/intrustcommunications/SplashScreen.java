package com.example.intrustcommunications;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASH_SCREEN_TIME = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ProgressBar pBar = (ProgressBar) findViewById(R.id.progressBar);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent mainContext = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mainContext);
                finish();
            }
        }, SPLASH_SCREEN_TIME);
    }

}
