package me.sibalnirbhay.classes;

public class Price {
  private int _priceCode;

  public Price(int priceCode) {
    _priceCode = priceCode;
  }

  public int priceCode() {
    return _priceCode;
  }

  public double amount(int daysRented) {
      double thisAmount = 0;
      switch (priceCode()) {
          case Movie.REGULAR:
              thisAmount += 2;
              if (daysRented > 2) {
                  thisAmount += (daysRented - 2) * 1.5;
              }
              break;
          case Movie.NEW_RELEASE:
              thisAmount += daysRented * 3;
              break;
          case Movie.CHILDREN:
              thisAmount += 1.5;
              if (daysRented > 3) {
                  thisAmount += (daysRented - 3) * 1.5;
              }
              break;
          default:
              System.out.println("Bad Rental Type");
              break;
      }
      return thisAmount;
  }
}
