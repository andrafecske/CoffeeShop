package Models;

public class Card implements HasID{
    private Integer ID;
    private int currentPoints;
    private int totalPoints;

    public Card(Integer ID) {
        this.ID = ID;
    }

    private boolean isMaxedOut(){
        return currentPoints > 500;
    }

    public void addPoints(int points){
        if(!isMaxedOut()){
            currentPoints += points;
        }
    }

    public void clearPoints(){
        currentPoints = 0;
    }

    public int getCurrentPoints(){
        return currentPoints;
    }

    public int getTotalPoints(){
        return totalPoints;
    }
    public void setTotalPoints(int totalPoints){
        this.totalPoints = totalPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    @Override
    public Integer getId() {
        return ID;
    }

    public void setId(Integer ID) {
        this.ID = ID;
    }
}
