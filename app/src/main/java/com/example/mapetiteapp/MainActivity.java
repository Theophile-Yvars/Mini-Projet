package com.example.mapetiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    /*
    Image Boutton pour aller sur le play store
     */
    ImageButton buttonPlayStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Création des 3 bouttons pour les 3 activités.
         */
        Button buttonFiltre = findViewById(R.id.button1);
        Button buttonLed = findViewById(R.id.lien);
        Button buttonAop = findViewById(R.id.button3);

        /*
        Affectation des fonctions à chacun des bouttons.
         */
        buttonFiltre.setOnClickListener(this::filtre);
        buttonLed.setOnClickListener(this::led);
        buttonAop.setOnClickListener(this::aop);

        /*
        Affectation la fonction pour aller sur le play store
         */
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

    /*
    Fonction qui execute l'activité du calcul d'Aop'
     */
    void aop(View sender){
        Intent aopActivity = new Intent(getApplicationContext(),Aop.class);
        startActivity(aopActivity);
    }

    /*
    Fonction qui ouvre le play store
     */
    public void  openPlayStore()  {
        // Adresse cible
        String url="https://play.google.com/store/search?q=electronique";

        // Intent implicite. Va à l'adresse cible
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(intent);
    }
}