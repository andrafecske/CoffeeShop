package Models;

/**
 * The {@code Card} class represents a points-based card that tracks a user's
 * current and total points. The card has a point limit for current points,
 * and additional points cannot be added once it reaches the maximum threshold.
 */
public class Card implements HasID {
    /**
     * The current points available on the card.
     */
    private int currentPoints;

    /**
     * The total points accumulated on the card.
     */
    private int totalPoints;

    /**
     * Constructs a new {@code Card} with initial points set to zero.
     */
    public Card() {
        this.currentPoints = 0;
        this.totalPoints = 0;
    }

//    /**
//     * Checks if the card has reached the maximum allowed points.
//     *
//     * @return {@code true} if current points exceed the maximum threshold of 500, {@code false} otherwise
//     */
//    private boolean isMaxedOut() {
//        return currentPoints > 500;
//    }
//
//    /**
//     * Adds points to the current points on the card, if the card has not reached the maximum limit.
//     *
//     * @param points the number of points to add
//     */
//    public void addPoints(int points) {
//        if (!isMaxedOut()) {
//            currentPoints += points;
//        }
//    }
//
//    /**
//     * Clears the current points on the card, resetting them to zero.
//     */
//    public void clearPoints() {
//        currentPoints = 0;
//    }

    /**
     * Retrieves the current points on the card.
     *
     * @return the current points
     */
    public int getCurrentPoints() {
        return currentPoints;
    }

    /**
     * Retrieves the total points accumulated on the card.
     *
     * @return the total points
     */
    public int getTotalPoints() {
        return totalPoints;
    }

    /**
     * Sets the total points accumulated on the card.
     *
     * @param totalPoints the total points to set
     */
    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    /**
     * Sets the current points on the card.
     *
     * @param currentPoints the current points to set
     */
    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    /**
     * Returns a string representation of the card, including current and total points.
     *
     * @return a string representation of the card
     */
    @Override
    public String toString() {
        return "currentPoints=" + currentPoints + " and totalPoints=" + totalPoints;
    }

    @Override
    public Integer getId() {
        return 0;
    }
}
