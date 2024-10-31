package Models;

public class Client extends Person {

    public Card card;
    public Client(int ID, int age, String name) {
        super(ID, age, name);
        this.card = new Card();
    }

    public Card getCard() {
        return card;
    }
}