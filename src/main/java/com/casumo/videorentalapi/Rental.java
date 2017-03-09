package com.casumo.videorentalapi;


import java.util.Date;


public class Rental {

    private int rentalID;
    private Customer customer;
    private Film film;
    private Date rentalDate;
    private int rentalDays;
    private double rentalPrice;
    private Date returnDate;
    private double returnPrice;
    private boolean isReturned;
    private boolean isRentalPaid;



    public Rental(Customer customer, Film film, int rentalDays) {

        this.customer = customer;
        this.film = film;
        this.rentalDays = rentalDays;
        this.rentalDate = new Date();

    }



    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(double returnPrice) {
        this.returnPrice = returnPrice;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public boolean isRentalPaid() {
        return isRentalPaid;
    }

    public void setRentalPaid(boolean rentalPaid) {
        isRentalPaid = rentalPaid;
    }

}
