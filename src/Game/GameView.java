package Game;

import CardsAndDecks.Card;
import CardsAndDecks.Deck;
import CardsAndDecks.Hand;
import Player.Dealer;
import Player.Player;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GameView class that controls the flow of the program.
 *
 * @author Rzez, Marcelo, Uzair, Hannah April 2022
 */

public class GameView {

    //All private fields used in GameView class
    private String gameName = "Blackjack Game";
    private Boolean running;
    private int bet = 0;
    private char playerAction;
    private Dealer dealer;
    private Player player;
    private Deck deck;
    private Dialogue dialogue;
    private int WAIT_TIME = 250;

    Scanner sc = new Scanner(System.in);

    //TODO FILL THE GAME COMMANDS HERE
    public void play() throws InterruptedException {
        this.dialogue.preGameIntro(this.player.getName(), this.player.getMoney());
        while (this.player.getMoney() > 0) {
            this.betPhase();
            this.dealPhase();
            this.evaluatePhase();
            this.clearHandPhase();
            if (this.player.getMoney() >= 10000) {
                this.declareWin();
                break;
            } else {
                continue;
            }
        }
        this.declareLose();
    }//Play ends  

    //GameView constructor
    public GameView() {
    }

    //Main setup methods before game starts
    public void setup() {
        this.createDialogue();
        this.createDealer();
        this.createPlayer();
        this.createDeck();
    }
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
     * Methods to create the setup method or
     * Methods that setups introductions
     */
    private void load() {
        System.out.println("[     ]");
        this.wait(WAIT_TIME);
        System.out.println("[=    ]");
        this.wait(WAIT_TIME);
        System.out.println("[==   ]");
        this.wait(WAIT_TIME);
        System.out.println("[===  ]");
        this.wait(WAIT_TIME);
        System.out.println("[==== ]");
        this.wait(WAIT_TIME);
        System.out.println("[=====]");
        this.wait(WAIT_TIME);
    }

    private void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createDialogue() {
        this.dialogue = Dialogue.getInstance();
    }

    public void createDealer() {
        this.dialogue.creatingDealer();
        this.load();
        this.dealer = new Dealer("DealerAI");
        this.dialogue.dealerCreated();
    }

    public void createPlayer() {
        this.dialogue.greetPlayer(this.dealer.getName());
        this.dialogue.askPlayerName();
        String pName = sc.nextLine();
        this.dialogue.creatingPlayer();
        this.load();
        this.player = new Player(pName, 1000);
        this.dialogue.playerCreated(this.player.getName());
    }

    public void createDeck() {
        this.dialogue.creatingDeck();
        this.load();
        this.deck = new Deck();
        this.deck.populate();
        this.deck.shuffle();
        this.dialogue.deckCreated();
    }

    public void explainRules() {
        this.dialogue.askPlayerGameRules();
        String choice = sc.nextLine();
        if (choice.charAt(0) == 'Y' || choice.charAt(0) == 'y') {
            this.load();
            this.dialogue.displayRules();
        }
    }
    //End of introductions

    //Bet phase to prompt user how much to bet
    private void betPhase() {
        this.dialogue.askPlayerBet();
        while (true) {
            this.dialogue.playerBetAmount();
            try {
                this.bet = sc.nextInt();
                sc.nextLine();
                if (bet <= 0 || bet > player.getMoney()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                this.dialogue.playerBetError();
                sc.nextLine();
                continue;
            }
        }
        this.dialogue.dashSeperator();
    }
    //End of betPhase
    
    //Deal phase to start the game by giving the player its cards
    //Making deals, betting, player and dealer actions
    private void dealPhase() {
        this.dialogue.givePlayerCards();
        // Give player and dealer two cards in hand
        for (int i = 0; i < 2; i++) {
            this.player.addToHand(this.deck.draw());
            this.dealer.addToHand(this.deck.draw());
        }
        this.dialogue.showPlayerHand(this.player.getHand());
        
        //Player's turn
        boolean playerTurn = true;
        while (playerTurn) {
            this.dialogue.playerHitORStand();
            try {
                String continueAction = sc.next();
                playerAction = Character.toUpperCase(continueAction.charAt(0));

                switch (playerAction) {
                    case 'H':
                        this.player.hit(this.deck.draw());
                        break;

                    case 'S':
                        this.player.stand();
                        playerTurn = false;
                        break;

                    default:
                        this.dialogue.invalidInput();
                        continue;
                }
                this.dialogue.dashSeperator();
            } catch (Exception e) {
                this.dialogue.invalidInput();
                continue;
            }
            this.dialogue.totalValueOfCards(this.player.getHand(), this.player.valueOfCards());

            if (this.isHandOver21(this.player.getHand())) {
                return;
            }
        }

        //Dealer's turn
        boolean dealerTurn = true;
        while (dealerTurn) {
            switch (this.dealer.evaluateOwnHand()) {
                case 1:
                    this.dealer.hit(this.deck.draw());
                    break;

                default:
                    this.dealer.stand();
                    dealerTurn = false;
            }
            this.dialogue.totalValueOfCards(this.dealer.getHand(), this.dealer.valueOfCards());

            if (this.isHandOver21(this.dealer.getHand())) {
                return;
            }
        }
    }
    //End of dealPhase

    //Evaluation of hands, evaluating who wins the round,
    //and clear hands for next round
    private boolean isHandOver21(Hand hand) {
        int totalHand = 0;
        for (Card card : hand.getHand()) {
            totalHand += card.getValue().getValue();
        }
        if (totalHand > 21) {
            return true;
        }
        return false;
    }

    private void evaluatePhase() {
        if (this.isHandOver21(this.player.getHand())) {
            this.dealerWins();
        } else if (this.isHandOver21(this.dealer.getHand())) {
            this.playerWins();
        } else if (this.player.valueOfCards() > this.dealer.valueOfCards()) {
            this.playerWins();
        } else if (this.player.valueOfCards() < this.dealer.valueOfCards()) {
            this.dealerWins();
        } else if (this.player.valueOfCards() == this.dealer.valueOfCards()) {
            this.tie();
        }
    }

    private void clearHandPhase() {
        this.player.getHand().clearHand();
        this.dealer.getHand().clearHand();
    }
    //End of evaluations
    
    //Methods for who wins and tie
    private void playerWins() {
        this.player.addMoney(this.bet);
        this.dialogue.playerWinsRound(this.player.getMoney());
        this.bet = 0;
    }

    private void dealerWins() {
        this.player.addMoney(-(this.bet));
        this.bet = 0;
    }

    private void tie() {
        this.bet = 0;
        this.dialogue.playersTie();
    } 
    //End of methods for who wins and tie

    //Final results of winning or losing
    public void declareWin() {
        this.dialogue.playerWin(this.player.getMoney());
    }//Declare winner ends

    public void declareLose() {
        if (this.player.getMoney() <= 0) {
            this.dialogue.playerLose(this.player.getMoney());
        }
    }// Declare looser ends

}
