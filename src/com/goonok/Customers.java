package com.goonok;

import java.util.PrimitiveIterator;

public class Customers {
    private String name;
    private String customerID;

    public Customers(String name, String customerID) {
        this.name = name;
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
