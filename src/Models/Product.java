package Models;

public class Product implements HasID{
    protected Integer ID;
    protected int points;
    protected int price;
    protected String name;

    public Product(Integer ID, int points, String name) {
        this.ID = ID;
        this.points = points;
        this.name = name;
    }

    public Integer getProductID() {
        return ID;
    }
    public void setProductID(Integer ID) {
        this.ID = ID;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public Integer getId() {
        return ID;
    }
}


