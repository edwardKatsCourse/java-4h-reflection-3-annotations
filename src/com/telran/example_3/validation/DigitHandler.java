package com.telran.example_3.validation;

public class DigitHandler extends BaseHandler {

    private Digit digitAnnotation;

    public DigitHandler(Digit digitAnnotation) {
        this.digitAnnotation = digitAnnotation;
    }

    @Override
    boolean isValid(String valueToCheck) { //age

        try {
            Integer.parseInt(valueToCheck);
            return true;
        } catch (NumberFormatException e) {
            System.err.println(digitAnnotation.message());
        }
        return false;
    }
}
