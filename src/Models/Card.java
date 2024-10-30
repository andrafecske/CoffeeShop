package Models;

public class Card {
    private int currentPoints;
    private int totalPoints;

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
}
