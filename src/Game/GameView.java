package Game;

import Player.Dealer;
import Player.Player;
import java.util.Scanner;

public class GameView {
    private String gameName = "Generic Blackjack 1v1";
    private Boolean running;
    private Dealer dealer;
    private Player player = new Player("Player1");
    
    Scanner sc = new Scanner(System.in);
    
    //TODO FILL THE GAME COMMANDS HERE
    public void play(){
        helloAndName();
        ruleExplanation();
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
        
        return "1. You must....\n"
                + "2. Take care of your money\n"
                + "You will be able to...... etc etc";
    }
    
    
}
