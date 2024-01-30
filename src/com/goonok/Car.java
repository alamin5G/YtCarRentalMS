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

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public boolean isCarAvailable() {
        return isCarAvailable;
    }

    public void setCarAvailable(boolean carAvailable) {
        isCarAvailable = carAvailable;
    }

    public double calculatePrice(int rentalDays){
        return basePricePerDay * rentalDays;
    }

    public void rent(){
        isCarAvailable = false;
    }

    public void returnCar(){
        isCarAvailable = true;
    }
}
