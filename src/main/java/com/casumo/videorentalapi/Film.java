package com.casumo.videorentalapi;

public class Film {

    private int filmID;
    private String filmName;
    private String filmType;
    private boolean isRented;



    public int getFilmID() {

        return filmID;
    }

    public void setFilmID(int filmID) {

        this.filmID = filmID;
    }

    public String getFilmName() {

        return filmName;
    }

    public void setFilmName(String filmName) {

        this.filmName = filmName;
    }

    public String getFilmType() {

        return filmType;
    }

    public void setFilmType(String filmType) {

        this.filmType = filmType;
    }

    public boolean isRented() {

        return isRented;
    }

    public void setRented(boolean rented) {

        isRented = rented;
    }
}
