package com.company;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static com.company.Main.toCustomerList;
import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class CustomerTest {

    @Test
    public void getBalance() {
        Customer testCustomer = new Customer();
        AccountRecord ar = new AccountRecord();
        ar.setCharge(10000);

        testCustomer.setId(1);
        testCustomer.setName("Sunny");
        List<AccountRecord> records = new ArrayList<AccountRecord>();
        records.add(ar);
        testCustomer.setCharges(records);

        assertEquals(10000, testCustomer.getBalance());

    }

    @Test
    public void testToString() {
        Customer testCustomer = new Customer();
        AccountRecord ar = new AccountRecord();
        ar.setCharge(10000);

        testCustomer.setId(1);
        testCustomer.setName("Sunny");
        List<AccountRecord> records = new ArrayList<AccountRecord>();
        records.add(ar);
        testCustomer.setCharges(records);


        String expected = "Customer ID: 1\n" +
                "Customer name: Sunny\n" +
                "Customer balance: 10000";
        assertEquals(expected,testCustomer.toString());
    }
}