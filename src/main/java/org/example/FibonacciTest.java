package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    //4 branches

    @Test
    public void fibonacciShouldThrowAnExceptionIfNLowerThan0(){
        Assertions.assertThrows(IllegalArgumentException.class,()->Fibonacci.fibonacci(-2));
    }

    @Test
    public void fibonacciShouldReturnIfNEquals0(){
        int result = Fibonacci.fibonacci(0);
        Assertions.assertEquals(1,result);
    }

    @Test
    public void fibonacciShouldReturn1IfNEquals1(){
        int result = Fibonacci.fibonacci(1);
        Assertions.assertEquals(1,result);
    }

    @Test
    public void fibonacciShouldReturntheResultCalculatedByTheFormula(){
         int result = Fibonacci.fibonacci(6);
         Assertions.assertEquals(8,result);
    }


}
