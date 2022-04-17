package Player;

import CardsAndDecks.Card;
import CardsAndDecks.Deck;
import java.util.ArrayList;


public class Dealer extends Player{
    
    Deck deck = new Deck();
    private static ArrayList<Card> availableDeck;
    
    public Dealer(){
        super("Dealer");
    }
    
    public void getDeckReady(){
    availableDeck = (ArrayList<Card>)Deck.getFullDeck().clone();
    }
    
    public Card giveRandomCard() {
        int randomCardInt = (int)Math.floor(Math.random()* 52);
        Card returnCard = availableDeck.get(randomCardInt);
        availableDeck.remove(randomCardInt);
        return returnCard; //RETURN A RANDOM CARD
    } // give a Random Card Ends
    
    public void evaluateMove() {
        
    } // Evaluate Move Ends
    
    public void operation(){
        
    }// Operation Ends

    
}
