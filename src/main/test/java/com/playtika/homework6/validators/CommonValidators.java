package com.playtika.homework6.validators;

public class CommonValidators {

    public static void assertEquals (int firstValue, int secondValue, String errorMessage){
        assert firstValue == secondValue : errorMessage;
    }

    public static void assertBooleanEquals (boolean firstValue, boolean secondValue, String errorMessage){
        assert firstValue == secondValue : errorMessage;
    }
}