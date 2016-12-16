package com.codeclan.example.cardgameandroid;

public class Player {
    private Hand hand;
    private String name;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return this.name;
    }

    public int getHandSize() {
        return this.hand.getSize();
    }

    public void addCardToHand(Card card) {
        this.hand.addCard(card);
    }

    public void returnHandToDealer(Dealer dealer) {
        this.hand.returnCardsToDealer(dealer);
    }

    public int getHandValue() {
        return this.hand.getValue();
    }

    public String getHandString() {
        return this.hand.toString();
    }
}