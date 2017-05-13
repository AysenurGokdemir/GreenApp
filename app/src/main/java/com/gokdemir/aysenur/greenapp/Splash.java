package com.gokdemir.aysenur.greenapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Aysenur on 29.04.2017.
 */

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);



        Timer a = new Timer();
        a.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Splash.this,MainActivity.class));
            }
        },3000);
}}
