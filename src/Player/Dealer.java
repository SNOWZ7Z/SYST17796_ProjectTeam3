package Player;

import CardsAndDecks.Card;
import CardsAndDecks.Deck;


public class Dealer extends Player{

    public Dealer(String name) {
        super(name);
    }
    
    public Card giveRandomCard(Deck deck) {
        
        return deck.getRandomCard();
    } // give a Random Card Ends
    
    public void evaluateMove() {
        
    } // Evaluate Move Ends
    
    public void operation(){
        
    }// Operation Ends

    
}
