package com.example.mapetiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Led extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);
        Button buttonCalculRes = findViewById(R.id.calculRes);
        buttonCalculRes.setOnClickListener(this::calculRes);
    }

   void calculRes(View sender){

   }
}