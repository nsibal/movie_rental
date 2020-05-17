package me.sibalnirbhay;

import me.sibalnirbhay.classes.Customer;
import me.sibalnirbhay.classes.Movie;
import me.sibalnirbhay.classes.Rental;
import me.sibalnirbhay.price.ChildrenPrice;
import me.sibalnirbhay.price.NewReleasePrice;
import me.sibalnirbhay.price.RegularPrice;

public final class Main {

  private Main() {}

  public static void main(String[] args) {
    Customer tony = new Customer("Tony");
    Customer peter = new Customer("Peter");

    Movie avengers = new Movie("The Avengers", new RegularPrice());
    Movie endgame = new Movie("Endgame", new NewReleasePrice());
    Movie homeComing = new Movie("Home Coming", new ChildrenPrice());

    tony.addRental(new Rental(avengers, 9));
    tony.addRental(new Rental(endgame, 15));

    peter.addRental(new Rental(homeComing, 12));
    peter.addRental(new Rental(avengers, 4));

    System.out.println(tony.statement());
    System.out.println(peter.statement());
  }
}
