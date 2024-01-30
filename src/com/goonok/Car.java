package com.goonok;

public class Car {
    private String carId;
    private String carModel;
    private String brand;
    private double basePricePerDay;
    private boolean isCarAvailable;

    public Car(String carId, String carModel, String brand, double basePricePerDay) {
        this.carId = carId;
        this.carModel = carModel;
        this.brand = brand;
        this.basePricePerDay = basePricePerDay;
        isCarAvailable = true;
    }
}
