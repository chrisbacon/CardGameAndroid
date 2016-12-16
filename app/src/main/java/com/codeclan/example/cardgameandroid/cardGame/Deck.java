package com.codeclan.example.cardgameandroid.cardGame;

import java.util.*;

public class Deck extends CardCollection {

    public Deck() {
        super();
    }

    public Card dealCard() {
        return this.cards.remove(0);
    }

    public void buildDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                addCard(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}