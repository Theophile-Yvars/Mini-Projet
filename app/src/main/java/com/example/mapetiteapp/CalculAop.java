package com.example.mapetiteapp;

public class CalculAop {
    /*
    Calcul de l'AOP

    Gain = 1 + R2/R1

    Pour le montage electronique, le schéma de l'appli indique la position de R1 et R2
     */

    /*
    Calcul du gain
     */
    static float calculGain(float R1, float R2){
        float gain = 0;
        gain = 1+(R2/R1);
        return gain;
    }

    /*
    Calcul de R1
     */
    static float calculR1(float gain, float R2){
        float R1 = 0;
        R1 = R2 / (gain - 1);
        return R1;
    }

    /*
    Calcul de R2
     */
    static float calculR2(float gain, float R1){
        float R2 = 0;
        R2 = R1 * (gain - 1);
        return R2;
    }

    /*
    Calcul de la tension de sortie
     */
    static float calculVout(float gain, float vin){
        float vout;
        vout = gain*vin;
        return vout;
    }
}