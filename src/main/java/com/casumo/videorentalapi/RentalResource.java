package com.casumo.videorentalapi;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;


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


    /** returns the available films: not rented */

    @GET
    @Path("films")
    public List<Film> getAvailableFilms(Boolean isRented) {

        if (isRented == null) {

            return filmDAO.getFilms();

        } else {

            return filmDAO.getFilms().stream()
                    .filter(film ->film.isRented())
                    .collect(Collectors.toList());
        }
    }


    /** returns the rentals by customer's id*/

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

    @POST
    @Path("customers/{customer_id}/rentals")
    public Rental rent(@PathParam("customer_id") int customerID, Customer customer, Film film, int rentalID, int rentalDays) {

        return rentalService.createRentalFilm(customer, film, rentalID, rentalDays);

    }


    /** returns the price of the customer's rental */

    @GET
    @Path("customers/{customer_id}/rentals/price")
    public Double totalRentalPrice (@PathParam("customer_id") int customerID, List<Rental> rentals) {

        return rentalService.totalRentalPrice(rentals);

    }


    /** returns the price of the customer's films returned */

    @GET
    @Path("customers/{customer_id}/return/price)")
    public Double totalReturnPrice (@PathParam("customer_id") int customerID, List<Rental> rentals) {

        return rentalService.totalReturnPrice(rentals);

    }


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

    @PUT
    @Path("customers/{id}/bonus_points")
    public int updateBonusPoints(@PathParam("id") int id, Customer customer, Film film) {


        return rentalService.rentalBonusPoints(customer, film);

    }


}
