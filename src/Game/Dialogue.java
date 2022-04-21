package Game;

import CardsAndDecks.Hand;

/**
 *
 *
 * @author Marcelo, Rzez, Uzair, Hannah April 2022
 */
public class Dialogue {

    private static Dialogue dialogue;

    public static Dialogue getInstance() {
        if (dialogue == null) {
            dialogue = new Dialogue();
        }
        return dialogue;
    }

    public void creatingDealer() {
        System.out.println("Creating dealer...");
    }

    public void dealerCreated() {
        System.out.println("Dealer created!");
    }

    public void greetPlayer(String dealerName) {
        System.out.println("Greetings player, my name is " + dealerName + ", and I will be your dealer for today.");
    }

    public void askPlayerName() {
        System.out.print("What's your name?\nMy name is: ");
    }

    public void creatingPlayer() {
        System.out.println("Creating player...");
    }

    public void playerCreated(String playerName) {
        System.out.println("Player created!");
        System.out.println("Nice to meet you " + playerName + "!");
    }

    public void creatingDeck() {
        System.out.println("Creating and shuffling deck...");
    }

    public void deckCreated() {
        System.out.println("The deck has been created and shuffled.");
    }

    public void askPlayerGameRules() {
        System.out.println("Would you like me to explain to you the rules of the game?\n(Y)ES    or    (N)O");
    }

    public void displayRules() {
        System.out.println("1. The main goal of BlackJack is to beat the dealer's cards with your own.");
        System.out.println("2. To beat the dealer, you must not go over 21 and either outscore the dealer or have him bust.");
        System.out.println("3. At the start of the round the dealer will give out a card to the every player including themselves.");
        System.out.println("4. From this point the player can hit or stand(Once per each round).");
        System.out.println("5. Choosing 'Hit', will add another card to get closer to 21.");
        System.out.println("6. Chossing 'Stand', will make you not draw a card");
        System.out.println("7. Good luck, have fun!");
    }

    public void preGameIntro(String playerName, int playerMoney) {
        System.out.println("\nBefore we begin, here is the initial balance for you to start betting:");
        System.out.println(playerName + " received " + playerMoney);
        System.out.println("\nLet the game begin!\n");
    }

    public void askPlayerBet() {
        System.out.println("How much would you like to bet this round?");
    }

    public void playerBetAmount() {
        System.out.print("Bet amount: ");
    }

    public void playerBetError() {
        System.out.println("Why would you even try to bet negative money or money you can't afford!");
    }

    public void givePlayerCards() {
        System.out.println("\nAlright, here are your cards");
    }
    
    public void showPlayerHand(Hand hand) {
        System.out.println(hand.toString());
    }
}
