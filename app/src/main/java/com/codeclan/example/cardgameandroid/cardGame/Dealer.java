package com.codeclan.example.cardgameandroid.cardGame;

import java.util.ArrayList;

public class Dealer extends Player {

    private Deck deck;

    public Dealer(String name, Deck deck) {
        super(name);
        this.deck = deck;
    }

    public int getDeckSize() {
        return this.deck.getSize();
    }

    public void shuffle() {
        this.deck.shuffle();
    }

    public void dealCardTo(Player recipient) {
        Card dealtCard = this.deck.dealCard();
        recipient.addCardToHand(dealtCard);
    }

    public void addCardToDeck(Card card) {
        this.deck.addCard(card);
    }

    public void getHandFromPlayerAndAddToDeck(Player player) {
        Hand playerHand = player.getHand();
        ArrayList<Card> cards = playerHand.getCards();
        for (Card card : cards) {
            addCardToDeck(card);
        }
        player.emptyHand();
    }
}