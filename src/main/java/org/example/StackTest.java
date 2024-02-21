package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void pushValueShouldbePushedWithoutExpanding(){
         Stack stack = new Stack();
         stack.push(4);
         stack.push(5);
         boolean result = stack.size() > 10 ;
        Assertions.assertFalse(result);
    }

    @Test
    public void pushValueShouldbePushedWithExpanding(){
        Stack stack = new Stack();
        for(int i = 0;i<10;i++){
             stack.push(i);
        }
        stack.push(4);
        boolean result = stack.size() > 10 && stack.peek() == 4;
        Assertions.assertTrue(result);
    }

    @Test
    public void topShouldReturnTheElementPoppedFromTheStack(){
        Stack stack = new Stack();
        for(int i = 0;i<5;i++){
            stack.push(i);
        }
        int result = stack.pop();
        Assertions.assertEquals(4,result );
    }

    @Test
    public void peekShouldReturnTheTopElementOfTheStack(){
        Stack stack = new Stack();
        for(int i = 0;i<5;i++){
            stack.push(i);
        }
        int result = stack.peek();
        Assertions.assertEquals(4,result);
    }



    @Test
    public void isEmptyShouldReturnTrueIfStackIsEmpty(){
        Stack stack = new Stack();
        boolean result = stack.isEmpty();
        Assertions.assertTrue(result);
    }

    @Test
    public void sizeShouldReturnTheSizeOfTheStack(){
        Stack stack = new Stack();
        for(int i = 0;i<5;i++){
            stack.push(i);
        }
        int result = stack.size();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void expandArrayShouldDoubleTheLengthOftheArray(){
         Stack stack = new Stack();
         //pushing more than 10 elements
         for(int i = 0; i<15; i++){
              stack.push(i);
         }
         boolean result = stack.size() > 10;
         Assertions.assertTrue(result);
    }



}
