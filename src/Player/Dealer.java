package Player;

import CardsAndDecks.Card;
import CardsAndDecks.Deck;
import java.util.ArrayList;


public class Dealer extends Player{
    
    Deck deck = new Deck();
    private static ArrayList<Card> availableDeck = new ArrayList<>();
    
    public Dealer(){
        super("Dealer");
    }
    
    public Card giveRandomCard() {
        int randomCardInt = (int)Math.floor(Math.random()* 52);
        return availableDeck.get(randomCardInt); //RETURN A RANDOM CARD
    } // give a Random Card Ends
    
    public void evaluateMove() {
        
    } // Evaluate Move Ends
    
    public void operation(){
        
    }// Operation Ends

    
}
