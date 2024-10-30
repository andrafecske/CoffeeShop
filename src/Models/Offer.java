package Models;
import java.util.List;

public class Offer {
    public int offerID;
    private List<Product> products;
    public int pointCost;
    public Offer(int offerID, List<Product> products, int pointCost) {
        this.offerID = offerID;
        this.products = products;
        this.pointCost = pointCost;
    }

    public int getOfferID() {
        return offerID;
    }

    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getPointCost() {
        return pointCost;
    }

    public void setPointCost(int pointCost) {
        this.pointCost = pointCost;
    }

    public String toString() {
        return "Offer [offerID=" + offerID + ", products=" + products + ", pointCost=";
    }
}

