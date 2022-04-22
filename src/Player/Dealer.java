package Player;

import CardsAndDecks.Card;
import java.util.Random;

/**
 * Dealer class that extends the Player
 * and plays against the Player.
 *
 * @author Rzez, Marcelo, Uzair, Hannah April 2022
 */
public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    @Override
    public void hit(Card card) {
        this.hand.addCard(card);
        System.out.println(getName() + " hits!");
    }

    @Override
    public void stand() {
        System.out.println(getName() + " stands!");
    }

    //The probabilities to hit for a card
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
            if (rng <= 10) {
                return 1;
            }
        }
        return 0;
    }

}
