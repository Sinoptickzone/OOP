package main;

import task1.Employee;
import task1.SalaryCalculator;
import task2.Bus;
import task2.SpeedCalculation;
import task3.Circle;
import task3.Cube;
import task4.Rectangle;
import task4.Square;
import task5.DieselEngine;
import task5.PetrolEngine;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entry point of the application.
 */
public class App {
    public static void main(String[] args) {
        //task1
        LocalDate dob = LocalDate.of(1997, 7, 19);
        Employee employee = new Employee("Vasya", dob, new BigDecimal(150000));
        System.out.println("Vasya's net salary: " + SalaryCalculator.calculateNetSalary(employee.getBaseSalary()) + "\n");

        //task2
        task2.Car v1 = new task2.Car(130);
        Bus v2 = new Bus(100);
        System.out.println("Vehicle v1 allowed speed: " + SpeedCalculation.calculateAllowedSpeed(v1));
        System.out.println("Vehicle v2 allowed speed: " + SpeedCalculation.calculateAllowedSpeed(v2) + "\n");

        //task3
        Circle circle = new Circle(5);
        Cube cube = new Cube(10);
        System.out.println("Circle's area is: " + circle.area());
        System.out.println("Cube's area is: " + cube.area());
        System.out.println("Cube's volume is: " + cube.volume() + "\n");

        //task4
        Rectangle square = new Square(30);
        Rectangle rectangle = new Rectangle(20, 30);
        System.out.println("Square's area is: " + square.area());
        System.out.println("Rectangle's area is: " + rectangle.area() + "\n");

        //task5
        task5.Car dieselCar = new task5.Car(new DieselEngine());
        task5.Car petrolCar = new task5.Car(new PetrolEngine());
        dieselCar.start();
        petrolCar.start();
    }
}