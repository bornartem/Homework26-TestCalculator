package com.example.TestCalculator.service;

import org.junit.jupiter.api.Test;

import static com.example.TestCalculator.constants.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void shouldReturnCorrectGreeting() {
        String result = calculatorService.calculator(CORRECT_NAME);
        assertTrue(result.contains(CORRECT_NAME));
        assertEquals(DEFAULT_MESSAGE, result);
    }

    @Test
    public void ifSumNegativeOne() {
        int result = calculatorService.sum(NEGATIVE_ONE, DEFAULT_INT);
        assertTrue(result != calculatorService.sum(DEFAULT_INT, DEFAULT_INT));
        assertEquals(DEFAULT_INT, DEFAULT_INT, calculatorService.sum(DEFAULT_INT, DEFAULT_INT));

    }

    @Test
    public void ifEquals() {
        int result = calculatorService.minus(NEGATIVE_ONE, DEFAULT_INT);
        assertTrue(result != calculatorService.minus(DEFAULT_INT, DEFAULT_INT));
        assertEquals(DEFAULT_INT, DEFAULT_INT, calculatorService.minus(DEFAULT_INT, DEFAULT_INT));
    }

    @Test
    public void ifMultiplyNegativeOne() {
        int result = calculatorService.multiply(NEGATIVE_ONE, DEFAULT_INT);
        assertTrue(result != calculatorService.multiply(DEFAULT_INT, DEFAULT_INT));
        assertEquals(DEFAULT_INT, DEFAULT_INT, calculatorService.multiply(DEFAULT_INT, DEFAULT_INT));

    }

    @Test
    public void ifDivideEquals() {
        int result = calculatorService.divide(NEGATIVE_ONE, DEFAULT_INT);
        assertTrue(result != calculatorService.divide(DEFAULT_INT, DEFAULT_INT));
        assertEquals(DEFAULT_INT, DEFAULT_INT, calculatorService.divide(DEFAULT_INT, DEFAULT_INT));
    }

    @Test
    public void ifDivideByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculatorService.divide(DEFAULT_INT, ZERO));
    }
}
