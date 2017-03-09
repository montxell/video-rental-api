package com.casumo.videorentalapi;

import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    private List<Film> films;


    public FilmDAO() {

        this.films = new ArrayList<>();

        Film f1 = new Film();
        f1.setFilmID(1);
        f1.setFilmName("Matrix 11");
        f1.setFilmType("New");
        films.add(f1);

        Film f2 = new Film();
        f2.setFilmID(2);
        f2.setFilmName("Spiderman");
        f2.setFilmType("Regular");
        films.add(f2);

        Film f3 = new Film();
        f3.setFilmID(3);
        f3.setFilmName("Spiderman 2");
        f3.setFilmType("Regular");
        films.add(f3);

        Film f4 = new Film();
        f4.setFilmID(4);
        f4.setFilmName("Out of Africa");
        f4.setFilmType("Old");
        films.add(f4);

    }



    public List<Film> getFilms() {

        return films;
    }

}
