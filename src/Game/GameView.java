package Game;

import CardsAndDecks.Deck;
import Player.Dealer;
import Player.Player;
import java.util.Scanner;

public class GameView {
    private String gameName = "Generic Blackjack 1v1";
    private Boolean running;
    private int bet = 0;
    private char actionOption;
    private Dealer dealer = new Dealer();
    private Player player = new Player("Player1");
    Deck deck = new Deck();
            
    
    Scanner sc = new Scanner(System.in);
    
    //TODO FILL THE GAME COMMANDS HERE
    public void play(){
        
        deck.populateDeck();
        dealer.getDeckReady();
        
        helloAndName();
        ruleExplanation();
        gameBegins();
        offerBetting();
        cardDealing();
        
    }//Play ends    

    public void declareWinner(){
        
    }//Declare winner ends
    public void declareLooser(){
        
    }// Declare looser ends
    
    /***
     * getter and Setters
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
    /***
     * Getter and setters end
     */
    
    /**
     * Game voice lines interactions and methods
     */
    public void helloAndName(){
        System.out.println("Greetings player, my name is Dealy, and I will be your dealer of cards");
        System.out.print("What's your name? \n My name is: ");
        String playerName = sc.nextLine();
        player.setName(playerName);
        System.out.println("Nice to meet you " + player.getName());  
    }
    
    public void ruleExplanation(){
        System.out.println("Would you like me to explain to you the rules of the game?\n(Y)ES    or    (N)O");
            String desition = sc.nextLine();
            if (desition.charAt(0) == 'Y' || desition.charAt(0) == 'y') {
                System.out.println(rulesText());
            }
    }
    
    public String rulesText(){
        
        return "1. The main goal of BlackJack is to beat the dealer's cards with your own.\n"
                + "2. To beat the dealer, you must not go over 21 and either outscore the dealer or have him bust.\n"
                + "3. At the start of the round the dealer will give out a card to the every player including themselves.\n"
                + "4. From this point the player can hold, hit, stand, or double down (Once per each round).\n"
                + "5. Choosing 'Hold' will allow not to bet for that round, 'Hit', which will"
                + " add another card to get closer to 21, 'Stand',\n"
                + " which will make you not draw a card,"
                + " and 'Double Down', which will double the amount that is being bet.\n"
                + "6. Each Card has it's own value, the numbered cards have face value while suited cards are worth 10.";
    }
    
    public void gameBegins(){
        System.out.println("\nBefore we begin, here is the initial balance for you to start betting:");
        System.out.println(player.getName() + " received " + player.getMoney());
        System.out.println("\nLet the game begin\n");
    }
    
    public void offerBetting(){
        System.out.println("How much would you like to bet this round");     
        for (;;) { //The funky "for"
            System.out.print("Bet amount: ");
            try {
                bet = sc.nextInt();
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
    
    public void cardDealing(){
        System.out.println("\nAlright, here is your card");
        //Code to add a random card to hand
        player.addToHand(dealer.giveRandomCard());
        System.out.println(player.getHand().toString());
        
    }
    
    public void performtAction() {
        System.out.println("Would you like to (H)IT, (S)TAND, H(O)LD, or (D)OUBLE DOWN?");
        while (true) {            
            actionOption = sc.nextLine().charAt(0);
            
            switch (actionOption) {
                case 'H':
                    
                    break;
                    
                case 'S':
                    
                    break;
                    
                case 'O':
                    
                    break;
                    
                case 'D':
                    
                    break;
                    
                default:
                    System.out.println("Thats not a valid input");
                    continue;
            }
        }
    }
    //TODO
    //Insert the action methods from player above.
}
