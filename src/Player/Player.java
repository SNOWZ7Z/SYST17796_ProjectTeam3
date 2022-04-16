package Player;

import CardsAndDecks.GroupOfCards;

public class Player {
    
    private int money;
    private String name;
    private GroupOfCards hand;
    
    public Player(String name) {
        this.name = name;
        this.money = 100;
    }
    
    public void split(){
        
    }
    
    public void hit(int bet){
        
    }
    
    public void stand(){
        
    }
    
    public void doubleDown(int bet){
        
    }
    
    public int getMoney(){
        
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }
    
    
    
    
}
