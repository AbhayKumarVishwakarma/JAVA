package com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    public CalculatorTest() {
        System.out.println("Constructor created...");
    }

    @Test
    public void testDivide_whenValidValueProvided_shouldReturnExpectedResult(){

        //Arrange
        Calculator c = new Calculator();

        //Act
        int result = c.divide(4,2);

        //Assert
        Assertions.assertEquals(2, result, "4/2 should have returned 2");
    }

}
