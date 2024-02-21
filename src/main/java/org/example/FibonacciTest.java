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
}
