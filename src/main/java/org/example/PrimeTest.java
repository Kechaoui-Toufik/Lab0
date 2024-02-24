package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class PrimeTest {

    @Test
    public void isPrimerShouldReturnFalseIfNLowerThan2(){
         boolean result = Prime.isPrime(1);
         Assertions.assertFalse(result);
    }

    @Test
    public void isPrimerShouldReturnTrueIfNEquals2(){
        boolean result = Prime.isPrime(2);
        Assertions.assertTrue(result);
    }

    @Test
    public void isPrimerShouldReturnTrueIfNEquals3(){
        boolean result = Prime.isPrime(3);
        Assertions.assertTrue(result);
    }

    @Test
    public void isPrimerShouldReturnTrueIfNGraterThan3AndNisPrime(){
        boolean result = Prime.isPrime(7);
        Assertions.assertTrue(result);
    }

    @Test
    public void isPrimerShouldReturnFalseIfNGreaterThan3AndNisNotPrime(){
        boolean result = Prime.isPrime(8);
        Assertions.assertFalse(result);
    }



}
