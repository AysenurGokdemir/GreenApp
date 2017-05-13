package com.gokdemir.aysenur.greenapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Aysenur on 29.04.2017.
 */

public class SonucActivity extends AppCompatActivity {
    TextView tvSonuc,ideal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sonuc_sayfasi);
        Bundle gelenData=getIntent().getExtras();
        double sonuc= gelenData.getDouble("sonuc");
        tvSonuc= (TextView) findViewById(R.id.tvKitleEndex);
        tvSonuc.setText("Kitle Endexi"+sonuc);
        ideal= (TextView)(findViewById(R.id.tvİdealKilo));
        if(sonuc<18)
        {
            ideal.setText("zayıf");
        }
        else if(sonuc>17 && sonuc<26){
            ideal.setText("normal kilolu");

        }
        else if(sonuc>25 && sonuc<30){

            ideal.setText("fazla kilolu");

        }
        else if(sonuc>29 && sonuc<35)
        {
            ideal.setText("1.derece obez");

        }
        else if(sonuc>34 && sonuc<40){
            ideal.setText("2.derece obez");
        }
        else{
            ideal.setText("OBEZ");


    }
}}
