package com.codeclan.example.cardgameandroid.cardGame;

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

    public int getValue() {
        return Rules.getHandValue(this.cards);
    }
}