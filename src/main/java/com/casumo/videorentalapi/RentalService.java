package com.casumo.videorentalapi;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RentalService {

    /** price for renting a new release film */
    public static final double PREMIUM_PRICE = 40;

    /** price for renting a regular or an old film */
    public static final double BASIC_PRICE = 30;

    /** maximum number of days the costumer can rent a regular film without surcharges */
    public static final int MAX_DAYS_NO_SURCHARGE_FOR_REGULAR_FILM= 3;

    /** maximum number of days the customer can rent an old film without surcharges */
    public static final int MAX_DAYS_NO_SURCHARGE_FOR_OLD_FILM = 5;

    /** number of bonus points the customer gets for renting a new release film */
    public static final int BONUS_POINTS_PER_NEW_FILM_RENTAL = 2;

    /** number of bonus points the customer gets for renting a regular or an old film */
    public static final int BONUS_POINTS_PER_OTHER_FILM_RENTAL = 1;



    // Create a new rental of the customer

    public Rental createRentalFilm (Customer customer, Film film, int rentalID, int rentalDays) {

        Rental rental = new Rental(customer, film, rentalDays);

        rental.setRentalID(rentalID);
        rental.setRentalPrice(filmTypeRentalPrice(film, rentalDays));
        rental.setReturned(false);

        film.setRented(true);

        customer.addRentals(rental);

        return rental;
    }



    // Calculate the total rental price

    // I suppose a customer can rent more films in the same day without returning the others of its rentals list.
    // Therefore, to filter the Total Rental Price I added the field "isRentalPaid".
    // The rentals paid earlier in the day would have been set to "true", and they wouldn't be taken into account
    // in the method "totalRentalPrice"

    public double totalRentalPrice (List<Rental> rentals) {

        double totalRentalPrice = 0;

        for (Rental rental : rentals) {

            if ( !rental.isRentalPaid()) {

                totalRentalPrice += rental.getRentalPrice();

            }
        }

        return totalRentalPrice;
    }



    // Set the rental price of the film by its type: New, Regular or Old

    public double filmTypeRentalPrice(Film film, int rentalDays) {

        double price;

        if (film.getFilmType().equals("New")) {

            price = PREMIUM_PRICE * rentalDays;

        } else if (film.getFilmType().equals("Regular")) {

            if (rentalDays <= MAX_DAYS_NO_SURCHARGE_FOR_REGULAR_FILM) {

                price = BASIC_PRICE;

            } else {

                price = BASIC_PRICE + BASIC_PRICE * (rentalDays - MAX_DAYS_NO_SURCHARGE_FOR_REGULAR_FILM);
            }

        } else {

            if (rentalDays <= MAX_DAYS_NO_SURCHARGE_FOR_OLD_FILM) {

                price = BASIC_PRICE;

            } else {

                price = BASIC_PRICE + BASIC_PRICE * (rentalDays - MAX_DAYS_NO_SURCHARGE_FOR_OLD_FILM);
            }

        }

        return price;
    }



    // Set the conditions when returning a film

    public void returnRentedFilm(Rental rental, Film film, Date returnDate, Date rentalDate, int rentalDays) {

        rental.setReturnDate(new Date());
        rental.setReturned(true);
        rental.setReturnPrice(filmTypeReturnPrice(film, returnDate, rentalDate, rentalDays));

    }


    // Calculate the total return price of the films

    // I suppose a customer maybe doesn't return all the films.
    // Therefore, to filter the Total Return Price, I previously set the field isReturned to "true".
    // The rentals with "isReturned = false" won't be taken into account in the method "totalReturnPrice".
    // Later, the rentals with "isReturned = true" should be removed from the rentals List.

    public double totalReturnPrice (List<Rental> rentals) {

        double totalReturnPrice = 0;

        for (Rental rental : rentals) {

            if (rental.isReturned()) {

                totalReturnPrice += rental.getReturnPrice();

            }
        }

        return totalReturnPrice;
    }



    // Set the return price of the film by its type: New, Regular or Old

    public double filmTypeReturnPrice(Film film, Date returnDate, Date rentalDate, int rentalDays) {

        double price;

        Long daysUntilReturnLong = getDifferenceDays(returnDate, rentalDate);

        int daysUntilReturn = daysUntilReturnLong.intValue();


        // Difference between the day of returning the film and the renting days assigned in the rental

        int extraDays = daysUntilReturn - rentalDays;

        if (extraDays > 0) {

            if (film.getFilmType().equals("New")) {

                price = PREMIUM_PRICE * extraDays;

            } else {

                price = BASIC_PRICE * extraDays;

            }

            return price;

        } else {

            return 0;
        }
    }



    // Calculate the days until the return of the film

    public static long getDifferenceDays (Date returnDate, Date rentalDate) {

        long diff = returnDate.getTime() - rentalDate.getTime();

        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }



    // Add the Bonus Points to the customer by the type of film rented

    public int rentalBonusPoints(Customer customer, Film film) {

        int rentalBonusPoints = customer.getBonusPoints();

        if (film.getFilmType().equals("New")) {

            customer.addBonusPoints(BONUS_POINTS_PER_NEW_FILM_RENTAL);

        } else {

            customer.addBonusPoints(BONUS_POINTS_PER_OTHER_FILM_RENTAL);

        }

        return rentalBonusPoints;
    }


}
