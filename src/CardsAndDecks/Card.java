/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CardsAndDecks;

/**
 *
 * @author user
 */
public class Card {
    
    Suits suit;
    int value;
    
    public Card(int value, Suits suit){
        
    }

    @Override
    public String toString() {
        return "The card is a " + this.value + " of " + this.suit;
    }
    
    
    
}
