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
     * Constructs a new {@code Card} with initial points set to zero.
     */
    public Card() {
        this.currentPoints = 0;
    }
    /**
     * Retrieves the current points on the card.
     *
     * @return the current points
     */
    public int getCurrentPoints() {
        return currentPoints;
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
        return "currentPoints=" + currentPoints ;
    }

    @Override
    public Integer getId() {
        return 0;
    }
}
