package com.goonok;

public class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();
        Car car = new Car("C001", "Camri", "Toyota",60.00);
        Car car1 = new Car("C002", "Accord", "Honda",50.00);
        Car car2 = new Car("C003", "Hiace", "Noah",50.00);
        rentalSystem.addCar(car);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.menu();
    }
}