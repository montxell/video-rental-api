package com.casumo.videorentalapi;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private List<Customer> customers;


    public CustomerDAO() {

        this.customers = new ArrayList<>();

        Customer c1 = new Customer();
        c1.setCustomerID(1);
        c1.setCustomerName("Jane Doe");
        c1.setBonusPoints(9);
        customers.add(c1);

        Customer c2 = new Customer();
        c2.setCustomerID(2);
        c2.setCustomerName("Peter Smith");
        c2.setBonusPoints(14);
        customers.add(c2);

        Customer c3 = new Customer();
        c3.setCustomerID(3);
        c3.setCustomerName("Frank Carter");
        c3.setBonusPoints(4);
        customers.add(c3);

        Customer c4 = new Customer();
        c4.setCustomerID(4);
        c4.setCustomerName("Mary Williams");
        customers.add(c4);

    }



    public List<Customer> getCustomers() {

        return customers;
    }

}
