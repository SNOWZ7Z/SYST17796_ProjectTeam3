package Game;

import CardsAndDecks.Card;
import CardsAndDecks.Deck;
import Player.Dealer;
import Player.Player;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameView {

    private String gameName = "Generic Blackjack 1v1";
    private Boolean running;
    private Boolean roundStatus;
    private Boolean dealerRoundStatus;
    private int bet = 0;
    private char actionOption;
    private Dealer dealer = new Dealer();
    private Player player = new Player("Player1");
    Deck deck = new Deck();

    Scanner sc = new Scanner(System.in);

    //TODO FILL THE GAME COMMANDS HERE
    public void play() throws InterruptedException {

        deck.populateDeck();
        dealer.getDeckReady();

        helloAndName();
        ruleExplanation();
        gameBegins();
        offerBetting();
        cardDealing();
        performtAction();

    }//Play ends    

    public void declareWinner() {

    }//Declare winner ends

    public void declareLooser() {

    }// Declare looser ends

    /**
     * *
     * getter and Setters
     *
     * @return
     */
    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * *
     * Getter and setters end
     */
    /**
     * Game voice lines interactions and methods
     */
    public void helloAndName() {
        System.out.println("Greetings player, my name is Dealy, and I will be your dealer of cards");
        System.out.print("What's your name? \n My name is: ");
        String playerName = sc.nextLine();
        player.setName(playerName);
        System.out.println("Nice to meet you " + player.getName());
    }

    public void ruleExplanation() throws InterruptedException {
        System.out.println("Would you like me to explain to you the rules of the game?\n(Y)ES    or    (N)O");
        String desition = sc.nextLine();
        if (desition.charAt(0) == 'Y' || desition.charAt(0) == 'y') {
            System.out.println(rulesText());
            TimeUnit.SECONDS.sleep(7);
        }
    }

    public String rulesText() {

        return "1. The main goal of BlackJack is to beat the dealer's cards with your own.\n"
                + "2. To beat the dealer, you must not go over 21 and either outscore the dealer or have him bust.\n"
                + "3. At the start of the round the dealer will give out a card to the every player including themselves.\n"
                + "4. From this point the player can hit or stand(Once per each round).\n"
                + "5. Choosing 'Hit', will add another card to get closer to 21,\n"
                + " choosing 'Stand', will make you not draw a card\n"
                + "6. Each Card has it's own value, the numbered cards have face value while suited cards are worth 10.";
    }

    public void gameBegins() {
        System.out.println("\nBefore we begin, here is the initial balance for you to start betting:");
        System.out.println(player.getName() + " received " + player.getMoney());
        System.out.println("\nLet the game begin!\n");
    }

    public void offerBetting() {
        System.out.println("How much would you like to bet this round");
        for (;;) { //The funky "for"
            System.out.print("Bet amount: ");
            try {
                bet = sc.nextInt();
                sc.nextLine();
                if (bet <= 0 || bet > player.getMoney()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Bets are meant to be a positive number, that is no more than the amount of money you have");
                sc.nextLine();
                continue;
            }
        }
    }

    public void cardDealing() {
        System.out.println("\nAlright, here are your cards");
        //Code to add a random card to hand
        player.addToHand(dealer.giveRandomCard());
        player.addToHand(dealer.giveRandomCard());
        System.out.println(player.getHand().toString());
    }

    public void performtAction() {
        while (true) {
            System.out.println("Would you like to (H)IT, (S)TAND?");
            try {
                actionOption = sc.nextLine().charAt(0);

            switch (actionOption) {
                case 'H':
                    this.player.hit(this.dealer.giveRandomCard());
                    System.out.println(player.getName() + " hits!");
                    System.out.println(player.getHand().toString());
                    System.out.println("The total value of the cards is " + player.valueOfCards());
                    break;

                case 'S':
                    this.player.stand();
                    System.out.println("The total value of the cards is " + player.valueOfCards());
                    break;
                   
                default:
                    System.out.println("Thats not a valid input");
                    continue;
            }
            this.dealer.evaluateMove(this.player);
            
            } catch (Exception e) {
                System.out.println("Thats not a valid input");
                    continue;
            }
            
            evaluateRound();
            if (roundStatus) {
                break;
            } else {
                dealerPerforAction();
                if (!dealerRoundStatus) {
                    break;
                }
            }
        }//While ends
        //TODO EVALUATE IF LOST ROUND OR NOT & BOT ACTION
    }
    
    public void dealerPerforAction(){
            int chances = (int) Math.floor(Math.random()*4);
            if (chances != 1) {
                System.out.println("Dealer went over 21, YOU WIN THE ROUND!");
                player.addMoney(bet);
                System.out.println("You now have $" + player.getMoney());
                this.bet = 0;
                dealerRoundStatus = false;
            } else {
                System.out.println("Dealer drew a card...he is not out yet.");
                dealerRoundStatus = true;
            }
            
    }
    //TODO EVALUATE LOST METHOD HERE    
    public void evaluateRound(){
        if (player.valueOfCards() > 21) {
            this.roundStatus = true;
            System.out.println("Oh, It seems like you've gone over the maximum\nYou Lose the round");
            player.addMoney(-(bet));
            System.out.println("You now have $" + player.getMoney());
            this.bet = 0;
        } else {
            this.roundStatus = false;
        }
        
    }
    //Insert the action methods from player above.
    
    //TODO IMPLEMENT THE EVALUATE GAME
}
