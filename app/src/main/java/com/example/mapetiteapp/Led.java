package com.example.mapetiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Led extends AppCompatActivity {

    /*
    Information de saisie et de résultat
     */
    EditText input;
    EditText output;

    /*
    Pour un autre affichage de resultat
    Celui ci est proche du schéma
     */
    int afficheR = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);

        /*
        Recherche des ids
         */
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        Log.i("output : ",output.getText().toString());

        /*
        Button pour executer le calcul
         */
        Button buttonCalculRes = findViewById(R.id.calculRes);

        /*
        Attribution de la fonction de calcul
         */
        buttonCalculRes.setOnClickListener(this::calculRes);

        /*
        Sauvegarde de la donné trouvé
         */
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("value",afficheR);
        editor.apply();
    }

   void calculRes(View sender){
        try {
            /*
            Recuperation de la valeur saisie, en String
             */
            final String inputStr = input.getText().toString();
            /*
            Convertion de ce string en float
             */
            final float inputValue = Float.parseFloat(inputStr);

            /*
            Affichage du resultat
             */
            final String outputStr = String.format("%.2f", CalculResLed.calculResistance(inputValue));
            output.setText(outputStr + " ohms");

            /*
            Affichage de la valeur à coté de la résistance
             */
            afficheR = (int) CalculResLed.calculResistance(inputValue);
            TextView ledR = findViewById(R.id.affLed);
            ledR.setText("R : " + afficheR);
        } catch(Exception e){
            output.setText("Invalid input");
        }
    }
}