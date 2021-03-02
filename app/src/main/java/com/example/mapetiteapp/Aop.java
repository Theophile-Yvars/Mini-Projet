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

        Button buttonCalcul = findViewById(R.id.calculAop);
        buttonCalcul.setOnClickListener(this::calculAop);

        input1 = findViewById(R.id.inputAopVolt);
        input2 = findViewById(R.id.inputAop2);
        input3 = findViewById(R.id.inputAop3);
        output = findViewById(R.id.outputAopCalcul);

        spinner1 = (Spinner) findViewById(R.id.spinnerAop1);
        spinner2 = (Spinner) findViewById(R.id.spinnerAop2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.choix_Aop, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                //String inputStr = input2.getText().toString();

                @Override

                public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
                if (position == 1) { // R1
                    //R1 = Float.parseFloat(inputStr);
                    pos1 = 1;
                } else if (position == 2) { // R2
                    //R2 = Float.parseFloat(inputStr);
                    pos1 = 2;
                } else if (position == 3) { // Gain
                    //gain = Float.parseFloat(inputStr);
                    pos1 = 3;
                }
             }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //final String inputStr = input3.getText().toString();
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) { // R1
                //R1 = Float.parseFloat(inputStr);
                    pos2 = 1;
                } else if (position == 2) { // R2
                    //R2 = Float.parseFloat(inputStr);
                    pos2 = 2;
                } else if (position == 3) { // Gain
                    //gain = Float.parseFloat(inputStr);
                    pos2 = 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void calculAop(View sender){
        try {
            String outputStr2 = null;
            final String inputStr = input1.getText().toString();
            Vin = Float.parseFloat(inputStr);
            float vout = 0;

            final String inputStr1 = input2.getText().toString();
            final String inputStr2 = input3.getText().toString();

            float val1 = Float.parseFloat(inputStr1);
            float val2 = Float.parseFloat(inputStr2);

            Log.i("pos1", String.valueOf(pos1));
            Log.i("pos2", String.valueOf(pos2));

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

            if (pos1 == pos2) {
                outputStr2 = "Erreur saisie";
            }

            output.setText(outputStr2);

            Log.i("R1", String.valueOf(R1));
            Log.i("R2", String.valueOf(R2));
            Log.i("gain", String.valueOf(gain));
            Log.i("Vin", String.valueOf(Vin));
            Log.i("Vout", String.valueOf(vout));
            Log.i("valeur", outputStr2);

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
