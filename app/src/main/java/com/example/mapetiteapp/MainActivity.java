package com.example.mapetiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    ImageButton buttonPlayStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFiltre = findViewById(R.id.button1);
        Button buttonLed = findViewById(R.id.lien);
        Button buttonAop = findViewById(R.id.button3);

        buttonFiltre.setOnClickListener(this::filtre);
        buttonLed.setOnClickListener(this::led);
        buttonAop.setOnClickListener(this::aop);

        this.buttonPlayStore = findViewById(R.id.lienPlay);
        this.buttonPlayStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayStore();
            }
        });
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

    void aop(View sender){
        Intent aopActivity = new Intent(getApplicationContext(),Aop.class);
        startActivity(aopActivity);
    }

    public void  openPlayStore()  {
        String url="https://play.google.com/store/search?q=electronique";

        // An implicit intent, request a URL.
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(intent);
    }
}