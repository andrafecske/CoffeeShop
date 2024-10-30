package Models;
import java.util.List;

public class Order {
    public int orderID;
    private int points, totalCost = 0;
    private Client client;
    private  List<Product> products;

    public Order(int orderID, int points, int totalCost, Client client, List<Product> products) {
        this.orderID = orderID;
        this.points = points;
        this.client = client;
        this.products = products;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getTotalCost() {
        for(Product product: products){
            totalCost += product.getPrice();
        }
        return totalCost;
    }
    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

}
