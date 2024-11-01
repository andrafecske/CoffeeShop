package Models;

import java.net.IDN;

public class OfferOrder implements HasID {
    private Integer ID;
    private Client client;
    private Offer offer;

    public OfferOrder(Integer ID, Client client, Offer offer) {
        this.ID = ID;
        this.client = client;
        this.offer = offer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    @Override
    public Integer getId() {
        return ID;
    }
}

