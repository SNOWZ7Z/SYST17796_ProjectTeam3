package CardsAndDecks;

/**
 * Enum of card suits.
 *
 * @author Marcelo, Rzez, Uzair, Hannah April 2022
 */
public enum CardSuits {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    private String suitValue;

    private CardSuits(String value) {
        this.suitValue = value;
    }
    
    public String getValue() {
        return this.suitValue;
    }
}
