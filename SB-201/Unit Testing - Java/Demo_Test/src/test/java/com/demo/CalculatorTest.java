package com.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    Calculator calculator;

    public CalculatorTest() {
        System.out.println("Hello");
    }

    @BeforeAll
    public static void setUp() {
        System.out.println("Executing @BeforeAll method.");
    }

    @AfterAll
    public static void cleanUp() {
        System.out.println("Executing @AfterAll method.");
    }

    @BeforeEach
    public void beforeEachTestMethod() {
        System.out.println("Executing @BeforeEach method.");
        // Arrange
        calculator = new Calculator();
    }

    @AfterEach
    public void afterEachTestMethod() {
        System.out.println("Executing @AfterEach method.");
        calculator = null;
    }

    @DisplayName("Test 4/2 = 2 ")
    @Test
    public void testDivide_whenValidValueProvided_shouldReturnExpectedResult() {
        System.out.println("inside Test 4/2 = 2 method");
        // Act
        int result = calculator.divide(4, 2);
        // Assert
        assertEquals(2, result, "4/2 should have returned 2");
    }

    /**
     * Disabled annotation
     */
    @Disabled("TODO: Still need to work on this")
    @DisplayName("Disable test method")
    @Test
    public void test_DisableMethod(){
        System.out.println("inside test Disable method ");
    }

    /**
     * Asserting an Exception
     */
    @DisplayName("Division by zero")
    @Test
    public void testDivide_WhenDividendIsDividedByZero_ShouldThrowArithmeticException(){
        System.out.println("inside test Division by zero method ");

        //Arrange
        int dividend = 4;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";

        //Act and Assert
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () ->{ calculator.divide(dividend, divisor);}, "Division by zero should have thrown an Arithmetic exception");

        //Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Unexpected Exception message");
    }

    /**
     * ParameterizedTest
     * @param num1
     * @param num2
     * @param expectedResult
     */
    @DisplayName("Test integerAdd with [num1, num2, expected]")
    @ParameterizedTest
    @MethodSource("integerAddInputParameters") // with this name we need to create a static method
    public void testIntegerAdd_WhenAddingTwoPositiveNumber_ThenReturnAdditionResult(int num1, int num2, int expectedResult) {
        System.out.println("inside integerAdd test method");

        //Act
        int actualResult = calculator.integerAdd(num1, num2);

        //Assert
        assertEquals(expectedResult, actualResult, () -> num1 + " + " + num2  + " did not produce the " + expectedResult);
    }

    //this method with act like a method source for Parameterized test
    private static Stream<Arguments> integerAddInputParameters(){
        return Stream.of(
                Arguments.of(10,2,12),
                Arguments.of(15,2,17),
                Arguments.of(5,5,10)
        );
    }

}
