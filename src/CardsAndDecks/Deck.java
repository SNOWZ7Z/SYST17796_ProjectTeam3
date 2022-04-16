package CardsAndDecks;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    

    private static ArrayList<Card> fullDeck = new ArrayList<>();
    
    public void populateDeck(){
        if (fullDeck.size() >= 1) {
            fullDeck.clear();
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                
                switch (i) {
                    case 1:
                        fullDeck.add(new Card(j, Suits.SPADES));
                        break;
                        
                    case 2:
                        fullDeck.add(new Card(j, Suits.CLUBS));
                        break;
                        
                    case 3:
                        fullDeck.add(new Card(j, Suits.DIAMONDS));
                        break;
                        
                    case 4:
                        fullDeck.add(new Card(j, Suits.HEARTS));
                        break;
                        
                    default:
                        throw new AssertionError();
                }
            }
        } 
    }
    
    public Card getRandomCard(){
        int randomCardInt = (int)Math.floor(Math.random()* 52);
        return fullDeck.get(randomCardInt); //RETURN A RANDOM CARD
    }

    public static ArrayList<Card> getFullDeck() {
        return fullDeck;
    }

 
}
