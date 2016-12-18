package com.codeclan.example.cardgameandroid.cardGame;

import java.util.ArrayList;
import java.util.Collections;

public class Hand extends CardCollection {

    public Hand() {
        super();
    }

    public Hand(Hand hand) {
        super();
        this.cards = new ArrayList<Card>(hand.getCards());
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

    public void emptyCards() {
        cards.clear();
    }
    public int getValue() {
        return Rules.getHandValue(this.cards);
    }
}