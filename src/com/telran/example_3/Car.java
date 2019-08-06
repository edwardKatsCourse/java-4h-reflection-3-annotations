package com.telran.example_3;

import com.telran.example_3.validation.Digit;
import com.telran.example_3.validation.Length;

public class Car {

    @Length(min = 4, max = 15, message = "Brand's length should be between 4 and 15 characters")
    private String brand;

    @Length(min = 3, max = 10, message = "Model's length should be between 3 and 10 characters")
    private String model;

    @Digit(message = "Year must be digit") //abc
    @Length(min = 4, max = 4, message = "Year should contain exactly 4 digits") //10000
    private String year;

    public Car(String brand, String model, String year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Car: %s, %s, of %s year",
                this.brand,
                this.model,
                this.year);
    }
}
