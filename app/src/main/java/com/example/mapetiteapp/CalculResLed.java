package com.example.mapetiteapp;

public class CalculResLed {
    /*
        Pour le calcul d'une résistance d'une led, on considere sa tension de fonctionnement à 2.2 Volt
        et son intensité à 20mA

        Calcul de la resistance : (Ve - Vr) / Iled
        Ve = tension d'alimentation
        Vr = tension souhaité de la led
        Iled = intensité souhaite de la led
    */
    private static float intensite = 0.02f;
    private static float voltLed = 2.2f;

    static float calculResistance(float voltSysteme){
        float resistance = 0;
        /*
        Execute le calcul
         */
        resistance = (voltSysteme - CalculResLed.voltLed) / CalculResLed.intensite;
        return resistance;
    }
}