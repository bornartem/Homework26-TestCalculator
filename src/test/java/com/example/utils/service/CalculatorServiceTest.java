package com.example.utils.service;

import com.example.TestCalculator.service.CalculatorService;
import com.example.utils.constants.CalculatorServiceTestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.utils.constants.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void shouldReturnCorrectGreeting() {
        String result = calculatorService.calculator(CalculatorServiceTestConstants.CORRECT_NAME);
        assertTrue(result.contains(CalculatorServiceTestConstants.CORRECT_NAME));
        Assertions.assertEquals(CalculatorServiceTestConstants.DEFAULT_MESSAGE, result);
    }

    @Test
    public void shouldReturnThreeIfSum1And2() {
        assertEquals(THREE, calculatorService.sum(ONE, TWO));

    }

    @Test
    public void shouldReturnOneIfMinus2And1() {
        assertEquals(ONE, calculatorService.minus(TWO, ONE));
    }

    @Test
    public void shouldReturnTwoIfMultiply2And1() {
        assertEquals(TWO, calculatorService.multiply(TWO, ONE));

    }

    @Test
    public void shouldReturnTwoIfDivide2And1() {
        assertEquals(TWO, calculatorService.divide(TWO, ONE));
    }

    @Test
    public void ifDivideByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculatorService.divide(ONE, ZERO));
    }
}
