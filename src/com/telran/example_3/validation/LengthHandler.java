package com.telran.example_3.validation;

public class LengthHandler extends BaseHandler {

    private Length length;

    public LengthHandler(Length length) {
        this.length = length;
    }

    @Override
    boolean isValid(String valueToCheck) {
        if (valueToCheck.length() <= length.max() && valueToCheck.length() >= length.min()) {
            return true;
        } else {
            System.err.println(length.message());
        }
        return false;
    }
}
