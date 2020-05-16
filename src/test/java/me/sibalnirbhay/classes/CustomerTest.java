package me.sibalnirbhay.classes;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

  @Test
  public void test() {
    Customer customer = new Customer("Bob");

    customer.addRental(new Rental(new Movie("The Avengers", Movie.REGULAR), 9));
    customer.addRental(new Rental(new Movie("Endgame", Movie.NEW_RELEASE), 15));
    customer.addRental(new Rental(new Movie("Home Coming", Movie.CHILDREN), 12));

    String expected_output = "Rental Record for Bob\n" +
            "\tThe Avengers\t12.5\n" +
            "\tEndgame\t45.0\n" +
            "\tHome Coming\t15.0\n" +
            "Amount owed is 72.5\n" +
            "You earned 4 frequent renter points";

    assertEquals(customer.statement(), expected_output);
  }
}
