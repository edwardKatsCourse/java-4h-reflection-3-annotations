package com.telran.example_3.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Length {

    int min();
    int max();
    String message();

    //Color color();
    //enums
    //primitives
    //Class
    //string

    //arrays of the those values
}

//enum Color {BLUE, RED}
