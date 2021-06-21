package madsj.entities;

import java.util.List;

public class ShipListing extends BaseShipInfo {

    private List<Offer> offers;

    public ShipListing(String shipClass, String manufacturer, int maxCargo, int plating, int speed, String type, int weapons) {
        super(shipClass, manufacturer, maxCargo, plating, speed, type, weapons);
    }

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public List<Offer> getOffers() {
        return offers;
    }
}
