package madsj.entities;

public abstract class BaseShipInfo {
    private String shipClass;
    private String manufacturer;
    private int maxCargo;
    private int plating;
    private int speed;
    private String type;
    private int weapons;

    public BaseShipInfo(String shipClass, String manufacturer, int maxCargo, int plating, int speed, String type, int weapons) {
        this.shipClass = shipClass;
        this.manufacturer = manufacturer;
        this.maxCargo = maxCargo;
        this.plating = plating;
        this.speed = speed;
        this.type = type;
        this.weapons = weapons;
    }

    public String getShipClass() {
        return shipClass;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getMaxCargo() {
        return maxCargo;
    }

    public int getPlating() {
        return plating;
    }

    public int getSpeed() {
        return speed;
    }

    public String getType() {
        return type;
    }

    public int getWeapons() {
        return weapons;
    }
}
