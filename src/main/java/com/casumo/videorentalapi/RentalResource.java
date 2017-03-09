package com.casumo.videorentalapi;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/store")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)


public class RentalResource {

    private FilmDAO filmDAO;
    private CustomerDAO customerDAO;
    private RentalService rentalService;


    public RentalResource(FilmDAO filmDAO, CustomerDAO customerDAO, RentalService rentalService)  {

        this.filmDAO = filmDAO;
        this.customerDAO = customerDAO;
        this.rentalService = rentalService;

    }


    /** returns all the films */

    @GET
    @Path("films")
    public List<Film> getAllFilms() {

        return filmDAO.getFilms();

    }


    /** returns the not rented films */

    @GET
    @Path("films/available")
    public List<Film> getAvailableFilms(@QueryParam("is_rented") boolean isRented) {

        List<Film> result = new ArrayList<>();

        for (Film film : filmDAO.getFilms()) {

            if(film.isRented() == isRented) {

                result.add(film);
            }

        }

        return result;

    }


    /** returns all the customers */

    @GET
    @Path("customers")
    public List<Customer> getCustomers() {

        return customerDAO.getCustomers();
    }


    /** returns the rentals by customer's id */

    @GET
    @Path("customers/{customer_id}/rentals")
    public List<Rental> getRentalsByCustomerId(@PathParam("customer_id") int customerID) {

        for (Customer customer : customerDAO.getCustomers()) {
            if (customer.getCustomerID() == customerID) {
                return customer.getRentals();
            }
        }

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }



    /** creates a new rental */
/*
    @POST
    @Path("customers/{customer_id}/rentals")
    public Rental rent(@PathParam("customer_id") int customerID, Customer customer, Film film, int rentalID, int rentalDays) {

        return rentalService.createRentalFilm(customer, film, rentalID, rentalDays);

    }
*/


    /** returns the price of the customer's rental */
/*
    @GET
    @Path("customers/{customer_id}/rentals/price")
    public Double totalRentalPrice (@PathParam("customer_id") int customerID,
                                    List<Rental> rentals) {

        return rentalService.totalRentalPrice(rentals);

    }
*/

    /** returns the price of the customer's films returned */
/*
    @GET
    @Path("customers/{customer_id}/return/price)")
    public Double totalReturnPrice (@PathParam("customer_id") int customerID,
                                    List<Rental> rentals) {

        return rentalService.totalReturnPrice(rentals);

    }
*/

    /** returns the bonus points by customer's id */

    @GET
    @Path("customers/{id}/bonus_points")
    public int getBonusPointsByCustomerId(@PathParam("id") int id) {

        for (Customer customer : customerDAO.getCustomers()) {
            if (customer.getCustomerID() == id) {
                return customer.getBonusPoints();
            }
        }

        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }


    /** updates the bonus points by customer's id */
/*
    @PUT
    @Path("customers/{customer_id}/bonus_points")
    public int updateBonusPoints(@PathParam("customer_id") int id, Customer customer, Film film) {


        return rentalService.rentalBonusPoints(customer, film);

    }
*/

}
