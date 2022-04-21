package Player;

import CardsAndDecks.Card;
import CardsAndDecks.Deck;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 *
 * @author Marcelo, Rzez, Uzair, Hannah April 2022
 */
public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    @Override
    public void hit(Card card) {
        this.hand.addCard(card);
        System.out.println("Dealer hits!");
    }

    @Override
    public void stand() {
        System.out.println("Dealer stands!");
    }

    public int evaluateOwnHand() {
        Random random = new Random();
        int rng = random.nextInt(100);
        int handValue = this.valueOfCards();
        
        if (handValue <= 10) {
            if (rng <= 90) {
                return 1;
            }
        } else if (handValue >= 11 && handValue <= 16) {
            if (rng <= 75) {
                return 1;
            }
        } else if (handValue >= 17 && handValue <= 20) {
            if (rng <= 15) {
                return 1;
            }
        }
        return 0;
    }

}
