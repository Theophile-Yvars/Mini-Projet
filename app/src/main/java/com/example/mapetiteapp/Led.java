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

    EditText input;
    EditText output;
    int afficheR = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);

       // TextView ledR = findViewById(R.id.affLed);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
        Log.i("output : ",output.getText().toString());

        Button buttonCalculRes = findViewById(R.id.calculRes);
        buttonCalculRes.setOnClickListener(this::calculRes);
/*
        buttonCalculRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String inputStr = input.getText().toString();
                final float inputValue = Float.parseFloat(inputStr);
                final String outputStr = String.format("%.2f", CalculResLed.calculResistance(inputValue));
                output.setText(outputStr + " ohms");
                afficheR = (int) CalculResLed.calculResistance(inputValue);

                ledR.setText("Valeur : "+afficheR);
            }
        });
*/
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("value",afficheR);
        editor.apply();
    }

   void calculRes(View sender){
        final String inputStr = input.getText().toString();
        final float inputValue = Float.parseFloat(inputStr);
        final String outputStr = String.format("%.2f", CalculResLed.calculResistance(inputValue));
        output.setText(outputStr + " ohms");
        afficheR = (int) CalculResLed.calculResistance(inputValue);
        TextView ledR = findViewById(R.id.affLed);
        ledR.setText("R : "+afficheR);
   }
}