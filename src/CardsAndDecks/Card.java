package CardsAndDecks;

public class Card {
    
    Suits suit;
    int value;
    
    public Card(int value, Suits suit){
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "The card is a " + this.value + " of " + this.suit;
    }
    
    
    
}
