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


    @Override
    public String toString() {
        return "Client " +
                "ID=" + ID +
                ", Age=" + age +
                ", Name='" + name + '\'' +
                ", Card:" + card.toString() ;
    }

}
