package Models;

import java.util.List;

/**
 * The {@code Offer} class represents a special offer that includes
 * a list of products and has an associated point cost. Each offer
 * has a unique identifier, represented by {@code offerID}.
 */
public class Offer implements HasID {

    /**
     * The unique identifier for this offer.
     */
    public Integer offerID;

    /**
     * The list of products included in this offer.
     */
    private List<Product> products;

    /**
     * The point cost required to redeem this offer.
     */
    public int pointCost;

    /**
     * Constructs a new {@code Offer} with the specified ID, list of products, and point cost.
     *
     * @param offerID   the unique identifier for this offer
     * @param products  the list of products included in the offer
     * @param pointCost the point cost required to redeem this offer
     */
    public Offer(Integer offerID, List<Product> products, int pointCost) {
        this.offerID = offerID;
        this.products = products;
        this.pointCost = pointCost;
    }

    /**
     * Sets a new ID for this offer.
     *
     * @param offerID the new offer ID to set
     */
    public void setOfferID(Integer offerID) {
        this.offerID = offerID;
    }

    /**
     * Retrieves the list of products included in the offer.
     *
     * @return a list of {@code Product} objects in the offer
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Sets a new list of products for this offer.
     *
     * @param products the new list of products to include in the offer
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Retrieves the point cost required to redeem this offer.
     *
     * @return the point cost of the offer
     */
    public int getPointCost() {
        return pointCost;
    }

    /**
     * Sets a new point cost for this offer.
     *
     * @param pointCost the new point cost to set
     */
    public void setPointCost(int pointCost) {
        this.pointCost = pointCost;
    }

    /**
     * Returns a string representation of the offer, including its ID, products, and point cost.
     *
     * @return a string representation of the offer
     */
    @Override
    public String toString() {
        StringBuilder productsString = new StringBuilder();
        for (Product product : products) {
            productsString.append(product.getName()).append(", ");
        }
        productsString.delete(productsString.length() - 1, productsString.length());

        return "offerID=" + offerID +"\n"+ "products:"+ "\n" + productsString + "\n"+ "pointCost = " +pointCost + "\n";
    }
    /**
     * Retrieves the unique identifier of this offer.
     *
     * @return the offer ID
     */
    @Override
    public Integer getId() {
        return offerID;
    }
}
