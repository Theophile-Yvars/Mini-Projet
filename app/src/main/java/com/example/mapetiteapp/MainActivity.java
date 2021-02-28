package com.example.mapetiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFiltre = findViewById(R.id.button1);
        Button buttonLed = findViewById(R.id.button2);

        buttonFiltre.setOnClickListener(this::filtre);
        buttonLed.setOnClickListener(this::led);
    }

    /*
    Fonction qui execute l'activité du calcul de filtre
     */
    void filtre(View sender){
        Intent filtreActivity = new Intent(getApplicationContext(),Filtre.class);
        startActivity(filtreActivity);
    }

    /*
    Fonction qui execute l'activité du calcul de la resistance pour la led
     */
    void led(View sender){
        Intent ledActivity = new Intent(getApplicationContext(),Led.class);
        startActivity(ledActivity);
    }
}