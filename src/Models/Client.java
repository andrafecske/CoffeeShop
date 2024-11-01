package Models;

public class Client extends Person {

    Integer cardID;
    public Card card;
    public Client(int ID, int age, String name) {
        super(ID, age, name);
        this.card = new Card(cardID);
    }

    public Card getCard() {
        return card;
    }
}
