package com.codeclan.example.cardgameandroid.cardGame;

import java.util.ArrayList;
import java.util.Collections;

public class Hand extends CardCollection {

    public Hand() {
        super();
    }

    public void returnCardsToDealer(Dealer dealer){
        while (getSize() > 0) {
            Card cardRemoved = cards.remove(0);
            dealer.addCardToDeck(cardRemoved); 
        }       
    }

    public ArrayList<Card> getCards() {
        return new ArrayList<Card>(cards);
    }

    public void emptyHand() {
        cards.clear();
    }

    public int getValue() {
        return Rules.getHandValue(this.cards);
    }
}