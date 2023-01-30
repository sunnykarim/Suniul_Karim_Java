package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int allCharges = 0;
        for (AccountRecord charge: this.getCharges()) {
            allCharges += charge.getCharge();
        }
        return allCharges;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    public void setCharges(List<AccountRecord> charges) {
        this.charges = charges;
    }

    @Override
    public String toString() {
        //update this
        // Update the `toString()` method in the `Customer` class to print the customer ID, customer name, and customer balance.
        String s = "Customer ID: " + this.getId() + "\nCustomer name: " + this.getName() + "\nCustomer balance: " + this.getBalance();
        return s;
    }
}
