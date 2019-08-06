package com.telran.example_3;

import com.telran.example_3.validation.Validator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        carValidation();
    }

    private static void carValidation() {
        while (true) {
            System.out.println("Brand: ");
            String brand = new Scanner(System.in).nextLine();

            System.out.println("Model: ");
            String model = new Scanner(System.in).nextLine();

            System.out.println("Year: ");
            String year = new Scanner(System.in).nextLine();

            Car car = new Car(brand, model, year);
            boolean isValid = Validator.validate(car);
            if (!isValid) {
                System.out.println("Car input is not valid");
                System.out.println("Try again");
                continue;
            }

            System.out.println(car.toString());
            break;
        }


    }

    private static void personValidation() {
        System.out.println("Enter your name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Your age: ");
        String age = new Scanner(System.in).nextLine();

        Person person = new Person(name, age);

        boolean isValid = Validator.validate(person);
        if (!isValid) {
            System.out.println("Input Data validation error. Please, try again!");
            return;
        }

        //person processing logic goes after this point
        System.out.println(person.toString());
    }
}
