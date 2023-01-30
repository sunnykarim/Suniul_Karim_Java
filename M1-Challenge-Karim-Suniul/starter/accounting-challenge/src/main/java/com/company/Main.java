package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static List<Customer> toCustomerList(List<String[]> l) {
        List<Customer> c = new ArrayList<Customer>();


        // Go through each String[] in the ArrayList
        for (String[] s: l) {
            boolean found = false;
            for (Customer cus : c) {
                if (cus.getName().equalsIgnoreCase(s[1])) {
                    found = true;
                }
            }

            // if this is a customer that already exists
            AccountRecord ar = new AccountRecord();
            ar.setCharge(Integer.parseInt(s[2]));
            ar.setChargeDate(s[3]);

            if (!found) {
                // create a new account record
                // create a new customer account
                Customer aNewCustomer = new Customer();
                aNewCustomer.setId(Integer.parseInt(s[0]));
                aNewCustomer.setName(s[1]);
                aNewCustomer.getCharges().add(ar);
                c.add(aNewCustomer);
            }

            else {
                for (Customer cus : c) {
                    if (cus.getName().equals(s[1])) {
                        cus.getCharges().add(ar);
                        continue;
                    }
                }
            }
        }

        return c;
    }

    public static List<Customer> PosOrNegAccounts(boolean positive) {
        List<Customer> allCustomers = toCustomerList(customerData);
        List<Customer> matchingCustomers = new ArrayList<Customer>();

        if (positive) {
            for (Customer c: allCustomers){
                if (c.getBalance() > 0) {
                    matchingCustomers.add(c);
                }
            }
        }

        else {
            for (Customer c: allCustomers){
                if (c.getBalance() < 0) {
                    matchingCustomers.add(c);
                }
            }
        }

        return matchingCustomers;
    }

    public static void main(String[] args) {
        List<Customer> positiveCustomers = PosOrNegAccounts(true);
        List<Customer> negativeCustomers = PosOrNegAccounts(false);

        System.out.println("Positive accounts:");
        for(Customer c: positiveCustomers){
            System.out.println(c);
            System.out.println();
        }
        System.out.println("Negative accounts:");
        for(Customer c: negativeCustomers){
            System.out.println(c);
            System.out.println();
        }
    }
}
