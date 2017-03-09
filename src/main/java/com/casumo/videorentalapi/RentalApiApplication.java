package com.casumo.videorentalapi;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class RentalApiApplication extends Application<RentalApiConfiguration> {

    public static void main(String[] args) throws Exception {
        new RentalApiApplication().run(args);
    }

    @Override
    public String getName() {

        return "rentalapi";
    }

    @Override
    public void initialize(Bootstrap<RentalApiConfiguration> bootstrap) {

    }


    @Override
    public void run(RentalApiConfiguration configuration, Environment environment) {

        String envName = configuration.getEnvironment();
        System.out.println("Environment: " + envName);


        FilmDAO filmDAO = new FilmDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        RentalService rentalService = new RentalService();

        RentalResource rentalResource = new RentalResource(filmDAO, customerDAO, rentalService);
        environment.jersey().register(rentalResource);

    }

}

