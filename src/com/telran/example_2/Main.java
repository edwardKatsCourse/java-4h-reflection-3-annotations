package com.telran.example_2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        Class<?> personClass = Class.forName("com.telran.example_2.Person");

        Constructor<?> constructor = personClass.getConstructor(String.class);

        Object personInstance = constructor.newInstance("John Smith");

        NamePrefix namePrefix = null;
        Field nameField = null;

        //field
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {

            //Способ №1
//            NamePrefix annotation = field.getAnnotation(NamePrefix.class);
//            if (annotation != null) {
//            }

            //Способ №2
            if (field.isAnnotationPresent(NamePrefix.class)) {
                namePrefix = field.getAnnotation(NamePrefix.class);
                nameField = field;
                break;
            }
        }

        nameField.setAccessible(true);
        //John Smith -> Mr John Smith
        String value = namePrefix.prefix() + " " + nameField.get(personInstance);

        nameField.set(personInstance, value);

        Method toString = personClass.getMethod("toString");

        System.out.println(toString.invoke(personInstance));

    }
}

class Person {

    @NamePrefix(prefix = "Mr.")
    private String name;        //Jane Smith -> Mrs. Jane Smith


    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface NamePrefix {

    String prefix();
}
