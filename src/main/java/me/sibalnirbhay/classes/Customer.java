package me.sibalnirbhay.classes;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String       _name;
    private List<Rental> myRentals = new ArrayList<Rental>();

    public Customer (String name) {
        _name = name;
    }

    public void addRental(Rental rental) {
        myRentals.add(rental);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        String name   = getName();
        String result = header(name);

        for (Rental each : myRentals) {
            double thisAmount = each.amountFor();
            result += "\t" + each.getMovie().getTitle() +
                      "\t" + String.valueOf(thisAmount) + "\n";
        }

        double totalAmount          = totalAmount(this.myRentals);
        int    frequentRenterPoints = frequentRenterPoints(this.myRentals);

        result += footer(totalAmount, frequentRenterPoints);
        return result;
    }

    private double totalAmount(Iterable<Rental> rentals) {
        double totalAmount = 0;
        for (Rental each : rentals) {
            double thisAmount = each.amountFor();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

    private int frequentRenterPoints(List<Rental> rentals) {
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            frequentRenterPoints++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;
    }

    private String header(String name) {
        return "Rental Record for " + name + "\n";
    }

    private String footer(double totalAmount, int frequentRenterPoints) {
        String footer1 = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        String footer2 = "You earned " + String.valueOf(frequentRenterPoints) +
                         " frequent renter points";
        return footer1 + footer2;
    }
}
