package CardsAndDecks;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    private ArrayList<Card> availableDeck = new ArrayList<>();
    private Card[] fullDeck = new Card[52];
    
    public Card getRandomCard(){
        int randomCardInt = (int)Math.floor(Math.random()*(51-0+1)+1);
        return fullDeck[randomCardInt]; //RETURN A RANDOM CARD
    }
    
    
    
}
