package me.sibalnirbhay.classes;

public class Movie {

    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDREN    = 2;
    
    private String _title;
    private int    _priceCode;
    
    public Movie(String title, int priceCode) {
        _title     = title;
        _priceCode = priceCode;
    }
    
    public int getPriceCode() {
        return _priceCode;
    }
    
    public void setPriceCode(int arg) {
        _priceCode = arg;
    }
    
    public String getTitle() {
        return _title;
    }

    public double amount(int daysRented) {
        double thisAmount = 0;
        switch (getPriceCode()) {
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
