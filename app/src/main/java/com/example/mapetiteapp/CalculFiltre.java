package com.example.mapetiteapp;

import static java.lang.Math.PI;

public class CalculFiltre {
    /*
    Calcul d'un filtre

    fc = frequence de coupure
    fc = 1 / (2*PI*R*C)

    R = Resistance
    C = Capacité

    Voir sur le schéma, sur l'application, pour visualiser l'emplacement des composants.
     */

    /*
    Calcul de R
     */
    static float calculR(double C, float fc){
        float R;
        R = (float) (1 / (2*C*fc*PI));
        return R;
    }

    /*
    Calcul de C
     */
    static float calculC(float R, float fc){
        float C;
        C = (float) (1 / (2*PI*R*fc));
        return C;
    }

    /*
    Calcul de Fc
     */
    static float calculFc(float R, double C){
        float fc;
        fc = (float) (1 / (2*PI*R*C));
        return fc;
    }
}
