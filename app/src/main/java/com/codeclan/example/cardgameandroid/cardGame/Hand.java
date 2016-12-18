package com.codeclan.example.cardgameandroid.cardGame;

import java.util.ArrayList;

public class Hand extends CardCollection {

    public Hand() {
        super();
    }

    public void returnCardsToDealer(Dealer dealer){
        while (getSize() > 0) {
            Card cardRemoved = this.cards.remove(0);
            dealer.addCardToDeck(cardRemoved); 
        }       
    }

    public ArrayList<Card> getCards() {
        return new ArrayList<Card>(cards);
    }

    public int getValue() {
        return Rules.getHandValue(this.cards);
    }
}