package Models;

import java.net.IDN;

/**
 * The {@code OfferOrder} class represents an order of a specific offer placed by a client.
 * Each {@code OfferOrder} has a unique identifier (ID), a reference to the {@code Client}
 * who placed the order, and the {@code Offer} being ordered.
 */
public class OfferOrder implements HasID {

    /**
     * The unique identifier for this order.
     */
    private Integer ID;

    /**
     * The client who placed this order.
     */
    private Client client;

    /**
     * The offer being ordered.
     */
    private Offer offer;

    /**
     * Constructs a new {@code OfferOrder} with the specified ID, client, and offer.
     *
     * @param ID     the unique identifier for this order
     * @param client the client placing the order
     * @param offer  the offer being ordered
     */
    public OfferOrder(Integer ID, Client client, Offer offer) {
        this.ID = ID;
        this.client = client;
        this.offer = offer;
    }

    /**
     * Retrieves the client who placed the order.
     *
     * @return the {@code Client} associated with the order
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets a new client for this order.
     *
     * @param client the new {@code Client} to associate with the order
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Retrieves the offer associated with this order.
     *
     * @return the {@code Offer} being ordered
     */
    public Offer getOffer() {
        return offer;
    }

    /**
     * Sets a new offer for this order.
     *
     * @param offer the new {@code Offer} to associate with the order
     */
    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    /**
     * Sets a new ID for this order.
     *
     * @param ID the new ID to set for this order
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Retrieves the unique identifier of this order.
     *
     * @return the order ID
     */
    @Override
    public Integer getId() {
        return ID;
    }
}
