package com.github.Eduardotxteatro.services;

import com.github.Eduardotxteatro.exception.UnsupportedMathOperationException;
import com.github.Eduardotxteatro.utils.NumberUtils;
import org.springframework.stereotype.Service;

@Service
public class MathService {
    public Double sum(String numberOne, String numberTwo){
        validateNumber(numberOne, numberTwo);
        return NumberUtils.convertToDouble(numberOne) + NumberUtils.convertToDouble(numberTwo);
    }

    public Double sub(String numberOne, String numberTwo){
        validateNumber(numberOne, numberTwo);
        return NumberUtils.convertToDouble(numberOne) - NumberUtils.convertToDouble(numberTwo);
    }

    public Double mult(String numberOne, String numberTwo){
        validateNumber(numberOne, numberTwo);
        return NumberUtils.convertToDouble(numberOne) * NumberUtils.convertToDouble(numberTwo);
    }

    public Double div(String numberOne, String numberTwo){
        validateNumber(numberOne, numberTwo);
        return NumberUtils.convertToDouble(numberOne) / NumberUtils.convertToDouble(numberTwo);
    }

    public Double med(String numberOne, String numberTwo){
        validateNumber(numberOne, numberTwo);
        return (NumberUtils.convertToDouble(numberOne) + NumberUtils.convertToDouble(numberTwo)) / 2;
    }

    public Double sqrt(String number){
        if (!NumberUtils.isNumeric(number)){
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }
        double value = NumberUtils.convertToDouble(number);
        if (value < 0){
            throw new UnsupportedMathOperationException("Cannot calculate square root of a negative number!");
        }
        return Math.sqrt(value);

    }
    private void validateNumber(String... numbers){
        for (String number : numbers){
            if (!NumberUtils.isNumeric(number)){
                throw new UnsupportedMathOperationException("Please, set a numeric value!");
            }
        }
    }
}
