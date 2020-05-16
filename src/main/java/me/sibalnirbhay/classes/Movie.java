package me.sibalnirbhay.classes;

public class Movie {

    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN    = 2;
    
    private String _title;
    private Price  _price;
    
    public Movie(String title, int priceCode) {
        _title     = title;
        _price     = new Price(priceCode);
    }
    
    public int getPriceCode() {
        return _price.priceCode();
    }
    
    public void setPriceCode(int priceCode) {
        _price = new Price(priceCode);
    }
    
    public String getTitle() {
        return _title;
    }

    public double amount(int daysRented) {
        return amount(_price, daysRented);
    }

    private double amount(Price price, int daysRented) {
        double thisAmount = 0;
        switch (price.priceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2) {
                    thisAmount += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDREN:
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
