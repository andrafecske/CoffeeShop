package Models;

public class Coffee extends Product{

    Boolean hasCaffeine;
    Enum MilkType;
    String extra;
    public Coffee(int productID, int points, String name, boolean hasCaffeine, Enum milkType, String extra) {
        super(productID, points, name);
        this.hasCaffeine = hasCaffeine;
        this.MilkType = milkType;
        this.extra = extra;
    }
    public Coffee(int productID, int points, String name, boolean hasCaffeine, Enum milkType) {
        super(productID, points, name);
        this.hasCaffeine = hasCaffeine;
        this.MilkType = MilkType;
    }

    public String getExtra() {
        return extra;
    }
    public void setExtra(String extra) {
        this.extra = extra;
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
}
