
package CardsAndDecks;

import java.util.ArrayList;

public class GroupOfCards{
    
    private ArrayList<Card> hand = new ArrayList<>();

    public String getCards() {
        String cardDisplay = "";
        for (Card e : hand) {
            cardDisplay += e.toString() + "\n";
        }
        return cardDisplay;
    }
    
    public int getSize() {
        return this.hand.size();
    }
    
    public void addCard(Card card) {
        this.hand.add(card);
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
