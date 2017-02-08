package com.andrew.healthapp;

import java.math.BigDecimal;
import java.math.RoundingMode;

class CalculationHelper {

    static String calculateBmi(double weight, double height) {
        double step1 = weight * 0.45;
        double step2 = height * 0.025;
        double step3 = Math.pow(step2, 2);
        double step4 = round((step1 / step3), 2);
        return String.valueOf(step4);
    }

    static String calculateBodyFat(double waist, double hips, double height, double neck, boolean isMale) {
        double percentage;
        if(isMale){
            double step1 = Math.log10(waist - neck);
            double step2 = step1 * 86.010;
            double step3 = Math.log10(height);
            double step4 = step3 * 70.041;
            double step5 = step2 - step4;
            percentage = step5 + 36.76;
        } else {
            double wstep1 = Math.log10(waist + hips - neck);
            double wstep2 = wstep1 * 163.205;
            double wstep3 = Math.log10(height);
            double wstep4 = wstep3 * 97.684;
            double wstep5 = wstep2 - wstep4;
            percentage = wstep5 - 78.387;
        }

        return String.valueOf(round(percentage, 2)) + "%";
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
