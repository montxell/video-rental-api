package com.casumo.videorentalapi;

import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    private List<Film> films;


    public FilmDAO() {

        this.films = new ArrayList<>();

        Film v1 = new Film();
        v1.setFilmID(1);
        v1.setFilmName("Matrix 11");
        v1.setFilmType("New");
        films.add(v1);

        Film v2 = new Film();
        v2.setFilmID(2);
        v2.setFilmName("Spiderman");
        v2.setFilmType("Regular");
        films.add(v2);

        Film v3 = new Film();
        v3.setFilmID(3);
        v3.setFilmName("Spiderman 2");
        v3.setFilmType("Regular");
        films.add(v3);

        Film v4 = new Film();
        v4.setFilmID(4);
        v4.setFilmName("Out of Africa");
        v4.setFilmType("Old");
        films.add(v4);

    }


}
