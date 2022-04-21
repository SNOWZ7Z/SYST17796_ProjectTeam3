package Player;

import CardsAndDecks.Card;
import CardsAndDecks.CardValues;
import CardsAndDecks.Hand;

/**
 *
 *
 * @author Marcelo, Rzez, Uzair, Hannah April 2022
 */
public class Player {

    protected int money;
    protected String name;
    protected Hand hand = new Hand();

    public Player(String name) {
        this.name = name;
        this.money = 0;
    }

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
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

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void addToHand(Card card) {
        this.hand.addCard(card);
    }

    public int valueOfCards() {
        int total = 0;
        for (Card card : hand.getHand()) {
            CardValues value = card.getValue();
            total += value.getValue(); // Returns the real int value
        }
        return total;
    }

}
