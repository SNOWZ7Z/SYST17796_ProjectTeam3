
package CardsAndDecks;

import java.util.ArrayList;

/**
 * Hand class that gets the cards, size, hand,
 * add and clear hand.
 *
 * @author Rzez, Marcelo, Uzair, Hannah April 2022
 */

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }
    
    public String getCards() {
        String cardDisplay = "";
        for (Card e : hand) {
            cardDisplay += e.toString() + "\n";
        }
        return cardDisplay;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }
    
    public int getSize() {
        return this.hand.size();
    }
    
    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void clearHand() {
        this.hand.clear();
    }
    
    @Override
    public String toString() {
        String fullHand = "";
        for (Card card : hand) {
             fullHand += "You have a " + card.value + " of " + card.suit + "\n";
        }
        return fullHand;
    }   
}
