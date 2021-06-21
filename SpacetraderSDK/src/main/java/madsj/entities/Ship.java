package madsj.entities;

public class Ship extends BaseShipInfo {
    private String id;
    private int spaceAvailable;
    private int x;
    private int y;

    public Ship(String shipClass, String manufacturer, int maxCargo, int plating, int speed, String type, int weapons, String id, int spaceAvailable, int x, int y) {
        super(shipClass, manufacturer, maxCargo, plating, speed, type, weapons);
        this.id = id;
        this.spaceAvailable = spaceAvailable;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public int getSpaceAvailable() {
        return spaceAvailable;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
