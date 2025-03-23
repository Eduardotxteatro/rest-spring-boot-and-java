package com.github.Eduardotxteatro.controllers;

import com.github.Eduardotxteatro.exception.UnsupportedMathOperationException;
import com.github.Eduardotxteatro.services.MathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService){
        this.mathService = mathService;
    }

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo){
        return mathService.sum(numberOne, numberTwo);
    }
    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo){
        return mathService.sub(numberOne, numberTwo);
    }
    @GetMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable String numberOne, @PathVariable String numberTwo){
        return mathService.mult(numberOne, numberTwo);
    }
    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne, @PathVariable String numberTwo){
        return mathService.div(numberOne, numberTwo);
    }
    @GetMapping("/med/{numberOne}/{numberTwo}")
    public Double med(@PathVariable String numberOne, @PathVariable String numberTwo){
        return mathService.med(numberOne, numberTwo);
    }
    @GetMapping("/sqrt/{number}")
    public Double sqrt(@PathVariable String number){
        return mathService.sqrt(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }



}
