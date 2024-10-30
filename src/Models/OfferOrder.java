package Models;

public class OfferOrder {
    private Client client;
    private Offer offer;

    public OfferOrder(Client client, Offer offer) {
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
}

