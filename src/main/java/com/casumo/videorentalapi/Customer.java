package com.casumo.videorentalapi;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int customerID;
    private String customerName;
    private int bonusPoints;
    private List<Rental> rentals;



    public Customer () {

        this.rentals = new ArrayList<>();
        this.bonusPoints = 0;
    }



    public int getCustomerID() {

        return customerID;
    }

    public void setCustomerID(int customerID) {

        this.customerID = customerID;
    }

    public String getCustomerName() {

        return customerName;
    }

    public void setCustomerName(String customerName) {

        this.customerName = customerName;
    }

    public int getBonusPoints() {

        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {

        this.bonusPoints = bonusPoints;
    }

    public void addBonusPoints(int bonusPoints) {

        this.bonusPoints += bonusPoints;
    }


    public List<Rental> getRentals() {

        return rentals;
    }

    public void setRentals(List<Rental> rentals) {

        this.rentals = rentals;
    }

    public void addRentals(Rental rental) {

        this.rentals.add(rental);
    }

}
