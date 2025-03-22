package com.github.Eduardotxteatro.controllers;

import com.github.Eduardotxteatro.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo")String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    //***********************************************************************
    //http://localhost:8080/math/sub/3/5
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }


    //***********************************************************************
    //http://localhost:8080/math/mult/3/5
    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    //***********************************************************************
    //http://localhost:8080/math/div/3/5
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    //***********************************************************************
    //http://localhost:8080/math/med/3/5
    @RequestMapping("/med/{numberOne}/{numberTwo}")
    public Double med(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("Please, set a numeric value!");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) /2;
    }
    //*****************************************************************************
    //http://localhost:8080/math/sqrt/3
    @RequestMapping("/sqrt/{number}")
    public Double sqrt(
            @PathVariable("number") String number
    ) throws Exception {
        if (!isNumeric(number))
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        double value = convertToDouble(number);
        if (value <0)
            throw new UnsupportedMathOperationException("Cannot calculate square root of a negative number!");
        return Math.sqrt(value);
    }
    //***********************************************************************

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {

        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedOperationException("Please, set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);

    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }



}
