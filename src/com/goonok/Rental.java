package com.goonok;

public class Rental {
    private Car car;
    private Customers customers;
    private int days;

    public Rental(Car car, Customers customers, int days) {
        this.car = car;
        this.customers = customers;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
