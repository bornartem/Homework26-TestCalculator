package com.example.TestCalculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.TestCalculator.constants.CalculatorServiceTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorParametrizedTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("parametrizedTest1")
    public void shouldReturnCorrectGreetings(String firstName, String secondNames, String thirdName) {
        String result = calculatorService.calculator(firstName);
        assertTrue(result.contains(secondNames));
        assertEquals(thirdName, result);
    }

    @ParameterizedTest
    @MethodSource("parametrizedTest")
    public void tests(int inputNum1, int inputNum2, int expectedNum1, int expectedNum2,int expectedNum3) {
        int result = calculatorService.sum(inputNum1, inputNum2);
        Assertions.assertTrue(result != calculatorService.sum(expectedNum1, expectedNum2));
        assertEquals(expectedNum3, inputNum2, calculatorService.sum(expectedNum1, expectedNum2));
    }

    @ParameterizedTest
    @MethodSource("parametrizedTest")
    public void test1(int inputNum1, int inputNum2, int expectedNum1, int expectedNum2, int expectedNum3) {
        int result = calculatorService.minus(inputNum1, inputNum2);
        Assertions.assertTrue(result != calculatorService.minus(expectedNum1, expectedNum2));
        assertEquals(expectedNum3, inputNum2, calculatorService.minus(expectedNum1, expectedNum2));
    }

    @ParameterizedTest
    @MethodSource("parametrizedTest")
    public void test2(int inputNum1, int inputNum2, int expectedNum1, int expectedNum2, int expectedNum3) {
        int result = calculatorService.multiply(inputNum1, inputNum2);
        Assertions.assertTrue(result != calculatorService.multiply(expectedNum1, expectedNum2));
        assertEquals(expectedNum3, inputNum2, calculatorService.multiply(expectedNum1, expectedNum2));
    }

    @ParameterizedTest
    @MethodSource("parametrizedTest")
    public void test3(int inputNum1, int inputNum2, int expectedNum1, int expectedNum2, int expectedNum3) {
        int result = calculatorService.divide(inputNum1, inputNum2);
        Assertions.assertTrue(result != calculatorService.divide(expectedNum1, expectedNum2));
        assertEquals(expectedNum3, inputNum2, calculatorService.multiply(expectedNum1, expectedNum2));
    }

    public static Stream<Arguments> parametrizedTest() {
        return Stream.of(
                Arguments.of(NEGATIVE_ONE, DEFAULT_INT, DEFAULT_INT, DEFAULT_INT,DEFAULT_INT)
        );
    }

    public static Stream<Arguments> parametrizedTest1() {
        return Stream.of(
                Arguments.of(CORRECT_NAME, CORRECT_NAME, DEFAULT_MESSAGE)
        );
    }
}
