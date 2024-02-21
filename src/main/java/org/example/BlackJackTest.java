package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackJackTest {

    @Test
    public void playLnshouldWin1stClass(){
         BlackJack bj = new BlackJack();
         int ln = 19;
         int rn = 25;
         int result = bj.play(ln,rn);
         Assertions.assertEquals(ln,result);
    }

    @Test
    public void playLnshouldWin2ndClass(){
        BlackJack bj = new BlackJack();
        int ln = 19;
        int rn = 15;
        int result = bj.play(ln,rn);
        Assertions.assertEquals(ln,result);
    }

    @Test
    public void playImpossibleCase3rdClass(){
        BlackJack bj = new BlackJack();
        int ln = 26;
        int rn = 26;
        int result = bj.play(ln,rn);
        Assertions.assertEquals(0,result);
    }




}
