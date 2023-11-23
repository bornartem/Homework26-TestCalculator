package com.example.TestCalculator.controller;


import com.example.TestCalculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorContoller {
    private final CalculatorService calculatorService;

    public CalculatorContoller(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String calculator(@RequestParam String name) {
        return calculatorService.calculator(name);
    }

    @GetMapping(path = "/plus")
    public String getSum(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            throw new RuntimeException("Не введен один из параметров");
        }
        return num1 + "+" + num2 + "=" + calculatorService.sum(num1, num2);

    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            throw new RuntimeException("Не введен один из параметров");
        }
        return num1 + "-" + num2 + "=" + calculatorService.minus(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String getMultiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            throw new RuntimeException("Не введен один из параметров");
        }
        return num1 + "*" + num2 + "=" + calculatorService.multiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String getDivide(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num1 == null || num2 == null) {
            throw new RuntimeException("Не введен один из параметров");
        }
        return num1 + "/" + num2 + "=" + calculatorService.divide(num1, num2);
    }
}
