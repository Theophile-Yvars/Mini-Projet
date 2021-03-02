package com.example.mapetiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Led extends AppCompatActivity {

    EditText input;
    EditText output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        Button buttonCalculRes = findViewById(R.id.calculRes);
        buttonCalculRes.setOnClickListener(this::calculRes);
    }

   void calculRes(View sender){
        final String inputStr = input.getText().toString();
        final float inputValue = Float.parseFloat(inputStr);
        final String outputStr = String.format("%.2f", CalculResLed.calculResistance(inputValue));
        output.setText(outputStr + " ohms");
   }
}