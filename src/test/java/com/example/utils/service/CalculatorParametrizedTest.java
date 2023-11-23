package com.example.utils.service;

import com.example.TestCalculator.service.CalculatorService;
import com.example.utils.constants.CalculatorServiceTestConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.utils.constants.CalculatorServiceTestConstants.*;
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
    public void returnCorrectSum(int num1, int num2) {
        assertEquals(num1+num2, calculatorService.sum(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("parametrizedTest")
    public void returnCorrectMinus(int num1, int num2) {
        assertEquals(num1-num2, calculatorService.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("parametrizedTest")
    public void returnCorrectMultiply(int num1, int num2) {
        assertEquals(num1*num2, calculatorService.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("parametrizedTest")
    public void returnCorrectDivide(int num1, int num2) {
        assertEquals(num1/num2, calculatorService.divide(num1, num2));
    }

    public static Stream<Arguments> parametrizedTest() {
        return Stream.of(
                Arguments.of(TWO, ONE)
//                Arguments.of(ZERO, TWO),
//                Arguments.of(ONE, ONE),
//                Arguments.of(ONE, TWO),
//                Arguments.of(TWO, TWO)
                );
    }

    public static Stream<Arguments> parametrizedTest1() {
        return Stream.of(
                Arguments.of(CORRECT_NAME, CORRECT_NAME, DEFAULT_MESSAGE)
        );
    }
}
