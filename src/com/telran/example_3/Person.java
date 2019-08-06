package com.telran.example_3;

import com.telran.example_3.validation.Digit;
import com.telran.example_3.validation.Length;

public class Person {

    @Length(min = 2, max = 15, message = "Length must be between 2 and 15 characters")
    private String name;

    @Digit(message = "Field age must be numeric")
    private String age;



    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format(
                "Respondent: %s, %s years old",
                this.name,
                this.age);
    }
}
