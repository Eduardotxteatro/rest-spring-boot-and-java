package com.github.Eduardotxteatro.utils;

import com.github.Eduardotxteatro.exception.UnsupportedMathOperationException;

public class NumberUtils {
    public static Double convertToDouble(String strNumber){
        if (strNumber == null || strNumber.isEmpty()){

            throw  new UnsupportedMathOperationException("Please, set a numeric value");

        }
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
    public static boolean isNumeric(String strNumber){
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
