package Player;

import CardsAndDecks.Card;
import CardsAndDecks.GroupOfCards;

public class Player {
    
    private int money;
    private String name;
    private GroupOfCards hand = new GroupOfCards();
    
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
    
    public void addMoney(int money){
        this.money += money;
        System.out.println("The user was given $" + money + " and now has a total of $" + this.money);
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
    
    public void addToHand(Card card) {
        this.hand.addCard(card);
    }
     
}
