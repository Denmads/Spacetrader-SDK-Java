package spacetraderapi.entities;

public class Offer {
    private String system;
    private String location;
    private int price;

    public Offer(String system, String location, int price) {
        this.system = system;
        this.location = location;
        this.price = price;
    }

    public String getSystem() {
        return system;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }
}
