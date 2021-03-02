package com.example.mapetiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Aop extends AppCompatActivity {

    float R1 = 0;
    float R2 = 0;
    float Vin = 0;
    float gain = 0;

    int pos1;
    int pos2;

    Spinner spinner1;
    Spinner spinner2;

    EditText input1; // Vin
    EditText input2; // Vout et Gain ou R1 ou R2
    EditText input3; // Vout et Gain ou R1 ou R2
    EditText output; // Vout et Gain ou R1 ou R2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop);

        /*
        Boutton d'execution des calculs
         */
        Button buttonCalcul = findViewById(R.id.calculAop);
        buttonCalcul.setOnClickListener(this::calculAop);

        /*
        Déclaration des zone de saisie, et de renvoie d'information
         */
        input1 = findViewById(R.id.inputAopVolt);
        input2 = findViewById(R.id.inputAop2);
        input3 = findViewById(R.id.inputAop3);
        output = findViewById(R.id.outputAopCalcul);

        /*
        spinner pour selectionner les éléments renseignés
         */
        spinner1 = (Spinner) findViewById(R.id.spinnerAop1);
        spinner2 = (Spinner) findViewById(R.id.spinnerAop2);

        /*
        déclaration du tableau d'item pour dans les spinner
         */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.choix_Aop, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /*
        Attribution du tableau au spinner
         */
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        /*
        Ecoute des 2 spinner
         */
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                //String inputStr = input2.getText().toString();

                @Override

                public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
                pos1 = position;
             }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //final String inputStr = input3.getText().toString();
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void calculAop(View sender){
        try {
            /*
            Variable string tampon
             */
            String outputStr2 = null;

            /*
            Recupêration de la valeur tension d'entrée saisie
             */
            final String inputStr = input1.getText().toString();
            Vin = Float.parseFloat(inputStr);

            /*
            Déclaration tension de sortie
             */
            float vout = 0;

            /*
            Recuperation des valeurs d'entrées dans les textes de saisie
             */
            final String inputStr1 = input2.getText().toString();
            final String inputStr2 = input3.getText().toString();

            /*
            Converti les valeurs string en float
             */
            float val1 = Float.parseFloat(inputStr1);
            float val2 = Float.parseFloat(inputStr2);

            /*
            Affichage des position des 2 spinners
             */
            Log.i("pos1", String.valueOf(pos1));
            Log.i("pos2", String.valueOf(pos2));

            /*
            Attribution des valeurs aux éléments choisis dans le spinner.
             */
            if (pos1 == 1)
                R1 = val1;
            if (pos1 == 2)
                R2 = val1;
            if (pos1 == 3)
                gain = val1;

            if (pos2 == 1)
                R1 = val2;
            if (pos2 == 2)
                R2 = val2;
            if (pos2 == 3)
                gain = val2;

            /*
            Appel la fonction calcul en fonction de l'élément manquant
             */
            if (R2 == 0) {
                R2 = CalculAop.calculR2(gain, R1);
                outputStr2 = "R2 : " + R2 + " ohms";
            }
            if (R1 == 0) {
                R1 = CalculAop.calculR1(gain, R2);
                outputStr2 = "R1 : " + R1 + " ohms";
            }
            if (gain == 0) {
                gain = CalculAop.calculGain(R1, R2);
                vout = CalculAop.calculVout(gain, Vin);
                outputStr2 = "Gain : " + gain + ". Vout : " + vout + "V";
            }

            /*
            Si l'utilisateur a selectionné deux fois un même element
             */
            if (pos1 == pos2) {
                outputStr2 = "Erreur saisie";
            }

            /*
            Affichage de la valeur du calcul
             */
            output.setText(outputStr2);

            /*
            Affichage terminal des valeurs
             */
            Log.i("R1", String.valueOf(R1));
            Log.i("R2", String.valueOf(R2));
            Log.i("gain", String.valueOf(gain));
            Log.i("Vin", String.valueOf(Vin));
            Log.i("Vout", String.valueOf(vout));
            Log.i("valeur", outputStr2);

            /*
            nouvelle initialisation
             */
            R1 = 0;
            R2 = 0;
            Vin = 0;
            gain = 0;
            vout = 0;
        } catch(Exception e){
            output.setText("Invalid input");
        }
    }

}
