package Models;

public class Coffee extends Product{

    Boolean hasCaffeine;
    Enum MilkType;

    public Coffee(Integer productID, int price, int points, String name, boolean hasCaffeine, Enum milkType) {
        super(productID, price, points, name);
        this.hasCaffeine = hasCaffeine;
        this.MilkType = MilkType;
    }

    public Enum getMilkType() {
        return MilkType;
    }
    public void setMilkType(Enum milkType) {
        MilkType = milkType;
    }
    public Boolean getHasCaffeine() {
        return hasCaffeine;
    }
    public void setHasCaffeine(Boolean hasCaffeine) {
        this.hasCaffeine = hasCaffeine;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "hasCaffeine=" + hasCaffeine +
                ", MilkType=" + MilkType +
                ", ID=" + ID +
                ", points=" + points +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
