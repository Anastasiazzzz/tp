package model.info;

public class Publisher {
    private String name;
    private Address address;

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("name");
//        sb.append((this.name == null) ? "null" : this.name);
//        sb.append("address");
//        sb.append((this.address == null) ? "null" : this.address);
//        sb.append("city");
//        sb.append((this.city == null) ? "null" : this.city);
//        sb.append("country");
//        sb.append((this.country == null) ? "null" : this.country);
//        return sb.toString();
//    }

//    public Publisher(String name, String address, String city, String country) {
//        this.name = name;
//        this.address = address;
//        this.city = city;
//        this.country = country;
//    }

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "[name: " + name + ", address [" + address + "]";
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}