package me.sibalnirbhay.classes;

public class NewReleasePrice extends Price {
    public NewReleasePrice() {
        super(Movie.NEW_RELEASE);
    }

    public double amount(int daysRented) {
        return daysRented * 3;
    }

    public int renterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
