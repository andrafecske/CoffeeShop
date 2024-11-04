package Models;
import java.util.List;

public class Order implements HasID{
    private Integer ID, clientID;
    private int points, totalCost;

    private  List<Product> products;

    public Order(Integer orderID, Integer clientID, List<Product> products) {
        this.ID = orderID;
        this.clientID = clientID;
        this.products = products;
        calculatePoints();
        calculateTotalCost();
    }
    public int getPoints() {
        return points;
    }

    public void calculateTotalCost() {
        totalCost = 0;
        for(Product product: products){
            totalCost += product.getPrice();
        }
    }

    public Integer getClientID() {
        return clientID;
    }
    public void setClient(Integer client) {
        this.clientID = clientID;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void setOrderID(Integer orderID) {
        this.ID = orderID;
    }

    public void calculatePoints()
    {
        points = 0;
        for(Product product: products){
            points+= product.getPoints();
        }
    }

    public int getTotalCost(){
       return totalCost;
    }


    @Override
    public Integer getId() {
        return ID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", clientID=" + clientID +
                ", points=" + points +
                ", totalCost=" + totalCost +
                ", products=" + products +
                '}';
    }
}
