package Player;

import CardsAndDecks.Card;
import CardsAndDecks.CardsInHand;

public class Player {

    private int money;
    private String name;
    private CardsInHand hand = new CardsInHand();

    public Player(String name) {
        this.name = name;
        this.money = 100;
    }

    public void hit(Card card) {
        this.hand.addCard(card);
    }

    public void stand() {
        System.out.println(getName() + " stands!");
    }


    public int getMoney() {

        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money) {
        this.money += money;
        System.out.println("The user was given $" + money + " and now has a total of $" + this.money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardsInHand getHand() {
        return this.hand;
    }

    public void setHand(CardsInHand hand) {
        this.hand = hand;
    }

    public void addToHand(Card card) {
        this.hand.addCard(card);
    }
    
    public int valueOfCards(){
        int total = 0;
        for (Card card: hand.getHand()) {
            total += card.getValue();
        }
        return total;
    }

}
