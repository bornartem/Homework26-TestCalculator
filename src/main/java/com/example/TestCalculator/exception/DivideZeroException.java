package com.example.TestCalculator.exception;

import java.io.IOException;

public class DivideZeroException extends RuntimeException {
    public DivideZeroException(String message) {
        super(message);
    }
}
