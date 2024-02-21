package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {
    //@BeforeEach indiquer que cette méthode doit être exécuté avant chaque test lancé
    // généralement on prépare les données qu'on veut utiliser dans le test
    private Stack stack;
    @BeforeEach
    void setUP(){
         stack = new Stack();
    }

    @Test
    public void pushShouldAddElementToTheTopOfTheStackWithoutExpandingTheArray(){

         stack.push(4);
         stack.push(5);
         boolean result = stack.size() == 2 && stack.peek() == 5;
        Assertions.assertTrue(result);
    }

    @Test
    public void pushShouldAddElementToTheTopOftheStackWithExpandingTheArray(){

        for(int i = 0; i<10; i++){
             stack.push(i);
        }
        stack.push(4);
        boolean result = stack.size() == 11 && stack.peek() == 4;
        Assertions.assertTrue(result);
    }

    @Test
    public void popShouldReturnTheElementPoppedFromTheStackIfStackIsNotEmpty(){

        for(int i = 0; i<5 ;i++){
            stack.push(i);
        }
        int result = stack.pop();
        Assertions.assertEquals(4,result );
    }
    @Test
    public void popShouldTrowAnErrorIfStackIsEmpty(){
        //assertThrows(the exception class, lambda function that throwing the exception)

        Assertions.assertThrows(IllegalStateException.class,()->stack.pop());

    }

    @Test
    public void peekShouldReturnTheTopElementOfTheStack(){

        for(int i = 0;i<5;i++){
            stack.push(i);
        }
        int initialSize = stack.size();
        int result = stack.peek();
        Assertions.assertEquals(stack.size(),initialSize);
        Assertions.assertEquals(4,result);
    }



    @Test
    public void isEmptyShouldReturnTrueIfStackIsEmpty(){

        boolean result = stack.isEmpty();
        Assertions.assertTrue(result);
    }
    @Test
    public  void isEmptyShouldReturnFalseIfStackIsNotEmpty(){
         stack.push(5);
         Assertions.assertFalse(stack.isEmpty());
    }
   // expandArray, nous n'avons pas besoin de la tester car c'est une fonction privée.
    @Test
    public void sizeShouldReturnTheSizeOfTheStack(){

        for(int i = 0;i<5;i++){
            stack.push(i);
        }
        int result = stack.size();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void expandArrayShouldDoubleTheLengthOftheArray(){

         //pushing more than 10 elements
         for(int i = 0; i<15; i++){
              stack.push(i);
         }
         boolean result = stack.size() > 10;
         Assertions.assertTrue(result);
    }



}
