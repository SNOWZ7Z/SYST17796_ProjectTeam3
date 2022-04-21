package CardsAndDecks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Deck class, all functions of a deck.
 *
 * @author Marcelo, Rzez, Uzair, Hannah April 2022
 */
public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public void populate() {
        for (CardSuits suit : CardSuits.values()) {
            for (CardValues value : CardValues.values()) {
                this.deck.add(new Card(value, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.deck, new Random());
    }

    public Card draw() {
        if (this.deck.size() <= 0) {
            this.populate();
        }

        int lastCardIndex = this.deck.size() - 1;
        Card card = this.deck.get(lastCardIndex);
        this.deck.remove(lastCardIndex);
        return card;
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

}
