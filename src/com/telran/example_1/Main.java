package com.telran.example_1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        //Compile time
        //Runtime
//        String s = "123@";

//        Integer.parseInt(s);

        //@RetentionPolicy()
        //SOURCE
        //CLASS
        //------ could be found by reflection ------
        //RUNTIME

        Class<Main> clazz = Main.class;

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyInterface.class)) {
                System.out.println(method.getName());
                break;
            }
        }
        System.out.println("Все!");
    }

    @MyInterface
    private void method() {}
}

//class
//interface
//enum
//@interface

@Retention(value = RetentionPolicy.RUNTIME)
@interface MyInterface {}
