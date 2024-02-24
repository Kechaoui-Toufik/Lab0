package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {


    BankAccount ba;

    @BeforeEach
    public void setUp() {
        ba = new BankAccount(2000.0, 0.01);
    }

    @Test
    public void depositShouldThrowAnExceptionIfAmountIsLowerThan0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ba.deposit(-20.0));
    }

    @Test
    public void depositShouldAddTheDepositAmountToTheAccountBalanceIfAmountIsGreaterThan0() {
        double initialAccountBalance = ba.getBalance();
        ba.deposit(100.0);
        Assertions.assertEquals(initialAccountBalance + 100.0, ba.getBalance());
    }


    //this test is not passed
    @Test
    public void depositShouldAlertTheUserThatTheDepositAmountEquals0() {
        Assertions.assertThrows(IllegalStateException.class, () -> ba.deposit(0.0));
    }

    @Test
    public void withdrawShouldThrowAnExceptionIfTheWithdrawnAmountLowerThan0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ba.withdraw(-100.0));
    }

    @Test
    public void withdrawShouldThrowAnExceptionIfTheAmountIsGreaterThanTheAccountBalance() {
        Assertions.assertThrows(IllegalStateException.class, () -> ba.withdraw(3000.0));
    }

    @Test
    public void withdrawShouldWithdrawTheAmountFromAccountBalanceIfTheAmountIsBiggerThan0AndLowerThanTheAccountBalance() {
        double initialAccountBalance = ba.getBalance();
        ba.withdraw(100.0);
        Assertions.assertEquals(initialAccountBalance - 100.0, ba.getBalance());
    }

   //this test is not passed
    @Test
    public void withdrawShouldThrowAnExceptionIfTheAmountEquals0() {
        Assertions.assertThrows(IllegalStateException.class, ()->ba.withdraw(0.0));
    }

   @Test
    public void transferShouldThrownAnExceptionIfTheOtherAccountIsNull(){
         Assertions.assertThrows(NullPointerException.class, () -> ba.transfer(100.0, null));
   }

   //This test is not passed

   @Test
    public void transferShouldThrowAnExceptionIfTheOtherAccountIsTheSameThanTheTranferringAcount(){
         Assertions.assertThrows(IllegalStateException.class, () -> ba.transfer(100.0, ba));
   }

   @Test
    public void transferShouldsubstractTheAmountFromTheTransferringAccountAndAddItToTheTargetAccount(){
         BankAccount anotherAcc = new BankAccount(1000.0, 0.01);
         double initialMainAccBalance = ba.getBalance();
         double initialTargetAccBalance = anotherAcc.getBalance();
         ba.transfer(100.0, anotherAcc);
         Assertions.assertEquals(initialMainAccBalance - 100.0, ba.getBalance());
         Assertions.assertEquals(initialTargetAccBalance + 100.0, anotherAcc.getBalance());

   }

   @Test
    public void addInterestShouldAddTheInterestAmountToTheAccountBalance(){
         ba.addInterest();
         Assertions.assertEquals(ba.getBalance(), 2000 * 1.01);
   }


   @Test
    public void getBalanceShouldReturnTheAccountBalance(){
         Assertions.assertEquals(2000.0, ba.getBalance());
   }



}


