package com.example.calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5.0, calculator.add(2.0, 3.0), 0.001);
    }

    @Test
    public void testSubtract() {
        assertEquals(1.0, calculator.subtract(4.0, 3.0), 0.001);
    }

    @Test
    public void testMultiply() {
        assertEquals(12.0, calculator.multiply(4.0, 3.0), 0.001);
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6.0, 3.0), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(6.0, 0.0);
    }
}
