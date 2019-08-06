package com.telran.example_3.validation;

import com.telran.example_3.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public static boolean validate(Object instance) {
        //Person.class ->
//        Person person = new Person();
//        person.getClass();
        Class clazz = instance.getClass();

        //year
        List<Field> lengthFields = getFieldsByAnnotationType(clazz, Length.class);

        //year
        List<Field> digitFields = getFieldsByAnnotationType(clazz, Digit.class);

        long lengthErrors = lengthFields.stream()
                .filter(field -> {
                    field.setAccessible(true);
                    try {
                        String value = (String) field.get(instance);
                        //brand -> 4 - 15
                        //model -> 3 - 10
                        Length lengthAnnotation = field.getAnnotation(Length.class);

                        BaseHandler baseHandler = new LengthHandler(lengthAnnotation);
                        return !isValid(baseHandler, value);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    return false;
                })
                .count();

        long digitErrors = digitFields.stream()
                .filter(field -> {
                    try {
                        field.setAccessible(true);
                        String value = (String) field.get(instance);
                        Digit digitAnnotation = field.getAnnotation(Digit.class);

                        BaseHandler digitHandler = new DigitHandler(digitAnnotation);
                        return !isValid(digitHandler, value);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .count();

        return lengthErrors == 0 && digitErrors == 0;

    }

    private static List<Field> getFieldsByAnnotationType(Class clazz, Class<? extends Annotation> annotation) {//Class<Object>
//        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field field : declaredFields) {
//            if ()
//        }

        return Arrays.stream(clazz.getDeclaredFields())
                .filter(x -> x.isAnnotationPresent(annotation))
                .collect(Collectors.toList());
    }

    private static boolean isValid(BaseHandler baseHandler, String valueToCheck) {
        return baseHandler.isValid(valueToCheck);
    }


}
