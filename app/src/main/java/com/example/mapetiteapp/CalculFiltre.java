package com.example.mapetiteapp;

import static java.lang.Math.PI;

public class CalculFiltre {
    static float calculR(float C, float fc){
        float R;
        R = (float) (1 / (2*C*fc*PI));
        return R;
    }
    static float calculC(float R, float fc){
        float C;
        C = (float) (1 / (2*PI*R*fc));
        return C;
    }
    static float calculFc(float R, float C){
        float fc;
        fc = (float) (1 / (2*PI*R*C));
        return fc;
    }
}
