package model.info;

public class Price {
    private String currency;
    private String amount;

    public Price(String currency, String amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }


}
