package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void getFullNameTest(){
         Person person = new Person("Toufik", "KECHAOUI", 23);
         String result = person.getFullName();
        Assertions.assertEquals("Toufik KECHAOUI", result);
    }
    @Test
    public void isAdultShouldReturnTrueWhenAgeGreaterOrEqualsThan18OrFalseWhenLessThan18(){
        Person person = new Person("Toufik", "KECHAOUI", 23);
        boolean result = person.isAdult();
        Assertions.assertTrue(result);
    }


}
