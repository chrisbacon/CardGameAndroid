package com.codeclan.example.cardgameandroid;
import java.util.*;

public abstract class CardCollection {
    ArrayList<Card> cards;

    public CardCollection() {
        this.cards = new ArrayList<Card>();
    }

    public int getSize() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public String toString(String delimeter) {
        String output = "";
        for (Card card : this.cards) {
            output += card.toString() + delimeter;
        }
        return output.substring(0, output.length()-delimeter.length());
    }

    @Override
    public String toString() {
        return toString(" ");
    }
}