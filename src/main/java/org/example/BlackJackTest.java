package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackJackTest {

    @Test
    public void playShouldReturnTheSmallestScoreIfAPlayerExceed21(){
         BlackJack bj = new BlackJack();
         int ln = 19;
         int rn = 25;
         int result = bj.play(ln,rn);
         Assertions.assertEquals(ln,result);
    }

    @Test
    public void playShouldReturnTheHighestScoreIfBothPlayersScoreIsBelow21(){
        BlackJack bj = new BlackJack();
        int ln = 19;
        int rn = 15;
        int result = bj.play(ln,rn);
        Assertions.assertEquals(ln,result);
    }

    //this test is not passed
    @Test
    public void playShouldThrowAnExceptionIfBothPlayerExceed21(){
        BlackJack bj = new BlackJack();
        int ln = 26;
        int rn = 26;
        Assertions.assertThrows(IllegalStateException.class, ()->bj.play(ln,rn));

    }




}
