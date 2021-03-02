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

public class Filtre extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;

    int pos1;
    int pos2;

    float r;
    float C;
    float Fc;

    EditText input1; // Vout et Gain ou R1 ou R2
    EditText input2; // Vout et Gain ou R1 ou R2
    EditText output; // Vout et Gain ou R1 ou R2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtre);

        input1 = findViewById(R.id.inputFiltre1);
        input2 = findViewById(R.id.inputFiltre2);
        output = findViewById(R.id.outputFiltreCalcul);

        Button buttonCalculFiltre = findViewById(R.id.buttonCalculFiltre);
        buttonCalculFiltre.setOnClickListener(this::calculFiltre);

        spinner1 = (Spinner) findViewById(R.id.spinnerFiltre1);
        spinner2 = (Spinner) findViewById(R.id.spinnerFiltre2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.choix_Filtre, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

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

    void calculFiltre(View sender){
        try {
            String outputStr = null;

            final String inputStr1 = input1.getText().toString();
            final String inputStr2 = input2.getText().toString();

            float val1 = Float.parseFloat(inputStr1);
            float val2 = Float.parseFloat(inputStr2);

            if (pos1 == 1)
                r = val1;
            if (pos1 == 2)
                C = val1;
            if (pos1 == 3)
                Fc = val1;

            if (pos2 == 1)
                r = val2;
            if (pos2 == 2)
                C = val2;
            if (pos2 == 3)
                Fc = val2;

            if (r == 0) {
                r = CalculFiltre.calculR(C, Fc);
                outputStr = "R : " + r + " ohms";
            }
            if (C == 0) {
                C = CalculFiltre.calculC(r, Fc);
                outputStr = "C : " + C + " microF";
            }
            if (Fc == 0) {
                Fc = CalculFiltre.calculFc(r, C);
                outputStr = "Fc : " + Fc + " Hz";
            }

            if (pos1 == pos2) {
                outputStr = "Erreur saisie";
            }

            Log.i("R", String.valueOf(r));
            Log.i("C", String.valueOf(C));
            Log.i("Fc", String.valueOf(Fc));
            Log.i("valeur", outputStr);

            output.setText(outputStr);

            r = 0;
            C = 0;
            Fc = 0;
        } catch(Exception e){
            output.setText("Invalid input");
        }
    }
}