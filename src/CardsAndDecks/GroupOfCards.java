/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CardsAndDecks;

import java.util.ArrayList;

public class GroupOfCards{
    
    private ArrayList<Card> hand = new ArrayList<>();

    public String getCards() {
        String cardDisplay = "";
        for (Card e : hand) {
            cardDisplay += e.toString() + "\n";
        }
        return cardDisplay;
    }
    
    public int getSize() {
        return this.hand.size();
    }
    
    public void addCard(Card card) {
        this.hand.add(card);
    }
    
    
}
