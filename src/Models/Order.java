package Models;
import java.util.List;

public class Order implements HasID{
    private Integer ID, clientID;
    private int points, totalCost;

    private List<Product> products;

//    private  List<Coffee> coffees;
//    private  List<Food> foods;

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
//        for(Coffee coffee: coffees){
//            totalCost += coffee.getPrice();
//        }
//        for(Food food: foods){
//            totalCost += food.getPrice();
//        }
        for (Product product : products) {
            totalCost += product.getPrice();
        }

    }

    public Integer getClientID() {
        return clientID;
    }
    public void setClient(Integer client) {
        this.clientID = clientID;
    }
//    public List<Food> getFoods() {
//        return foods;
//    }
//    public List<Coffee> getCoffees() {return coffees;}

    public List<Product> getProducts() {
        return products;
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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
