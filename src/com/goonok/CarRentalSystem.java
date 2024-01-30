package com.goonok;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> carList;
    private List<Customers> customersList;
    private List<Rental> rentalList;

    public CarRentalSystem() {
        carList = new ArrayList<>();
        customersList = new ArrayList<>();
        rentalList = new ArrayList<>();
    }

    public void addCar(Car car){
        carList.add(car);
    }

    public void addCustomer(Customers customers){
        customersList.add(customers);
    }

    public void rentCar(Car car, Customers customers, int days){
        if (car.isCarAvailable()){
            car.rent();
            rentalList.add(new Rental(car, customers, days));

        }else {
            System.out.println("Car is not available for rent!");
        }
    }

    public void returnCar(Car car){

        Rental rentalToRemove = null;
        for (Rental rental : rentalList){
            if (rental.getCar() == car){
                rentalToRemove = rental;
                break;
            }
        }

        if (rentalToRemove != null){
            rentalList.remove(rentalToRemove);
            car.returnCar();
            System.out.println("Car returned successfully!");
        }else {
            System.out.println("Car not rented yet!");
        }
    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("============Car Rental System =============");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            switch (choice){
                case 1:
                    System.out.println("==== Rent A Car =======");
                    System.out.println("Enter your name: ");
                    String customerName = input.nextLine();
                    System.out.println("Available Cars: ");
                    for (Car car : carList){
                        if(car.isCarAvailable()){
                            System.out.println(car.getCarId() + " - " + car.getBrand() + " - " + car.getCarModel());
                        }
                    }

                    System.out.print("Enter the Car ID you want to rent: ");
                    String carID = input.nextLine();
                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = input.nextInt();
                    Customers customers = new Customers("CUS" + (customersList.size()+1), customerName);
                    addCustomer(customers);

                    Car selectedCar = null;
                    for (Car car : carList){
                        if (car.getCarId().equals(carID) && car.isCarAvailable()){
                            selectedCar = car;
                            break;
                        }
                    }

                    if (selectedCar != null){
                        double totalPrice = selectedCar.calculatePrice(rentalDays);
                        System.out.println("==== Rental Information ===");
                        System.out.println("Customer ID: " + customers.getCustomerID());
                        System.out.println("Customer Name: " + customers.getName());
                        System.out.println("Car: " + selectedCar.getBrand() + " - " + selectedCar.getCarModel());
                        System.out.println("Rental Days: " + rentalDays);

                        System.out.printf("Total Price: $" + decimalFormat.format(totalPrice));
                        System.out.println("Confirm rental (y/n): ");
                        char confirm = input.next().charAt(0);

                        if (confirm == 'y' || confirm == 'Y'){
                            rentCar(selectedCar, customers, rentalDays);
                        }else {
                            System.out.println("Rental Cancelled!");
                        }

                    }else {
                        System.out.println("Invalid car selection or car not available for rent");
                    }

                    break;
                case 2:
                    System.out.println("============Return a car================");
                    System.out.println("Enter the car ID you want to return: ");
                    String carId = input.nextLine();
                    Car carToReturn = null;

                    for (Car car: carList){
                        if (car.getCarId().equals(carId) && !car.isCarAvailable()){
                            carToReturn = car;
                            break;
                        }
                    }

                    if (carToReturn != null){
                        Customers customers1 = null;
                        for (Rental rental : rentalList){
                            if (rental.getCar() == carToReturn){
                                customers1 = rental.getCustomers();
                                break;
                            }
                        }
                        if (customers1 != null){
                            returnCar(carToReturn);
                            System.out.println("Car return Successfully by " + customers1.getName());
                        }else{
                            System.out.println("Car was not rented or rental information is missing!");
                        }
                    }else {
                        System.out.println("Invalid Car ID or car is not rented!");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice, please enter a valid option!");
                    break;
            }

        }
    }
}
