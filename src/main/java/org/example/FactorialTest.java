package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class FactorialTest {


     @Test
     public void factorialShouldThrowAnExceptionIfNIsLowerThan0(){
          Assertions.assertThrows(IllegalArgumentException.class,()->Factorial.factorial(-5));
     }
     @Test
    public void factorialShouldReturn1IfNEquals0(){
         int result = Factorial.factorial(0);
         Assertions.assertEquals(1,result);
     }

    @Test
    public void factorialShouldReturn1IfNEquals1(){
        int result = Factorial.factorial(1);
        Assertions.assertEquals(1,result);
    }

    @Test
    public void factorialShouldReturnTheValueCalculatedInsideTheForLoopIfNIsGreaterThan2(){
          int result = Factorial.factorial(4);
          Assertions.assertEquals(24,result);
    }

}
