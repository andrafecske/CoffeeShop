package Models;

/**
 * The {@code Client} class represents a client, inheriting from the {@code Person} class.
 * Each client is assigned a {@code Card} to track points associated with their account.
 */
public class Client extends Person {

    /**
     * The card associated with this client.
     */
    public Card card;

    /**
     * Constructs a new {@code Client} with the specified ID, age, and name,
     * and initializes a new {@code Card} for the client.
     *
     * @param ID   the unique identifier for the client
     * @param age  the age of the client
     * @param name the name of the client
     */
    public Client(int ID, int age, String name) {
        super(ID, age, name);
        this.card = new Card();
    }

    /**
     * Retrieves the card associated with this client.
     *
     * @return the {@code Card} object associated with the client
     */
    public Card getCard() {
        return card;
    }

    /**
     * Returns a string representation of the client, including ID, age, name, and card details.
     *
     * @return a string representation of the client
     */
    @Override
    public String toString() {
        return "Client " +
                "ID=" + ID +
                ", Age=" + age +
                ", Name='" + name + '\'' +
                ", Card:" + card.toString();
    }
}
