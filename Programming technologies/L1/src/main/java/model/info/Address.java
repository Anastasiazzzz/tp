package model.info;

public class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "city: " + city + ", country: " + country + "]";
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
