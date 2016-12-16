package com.codeclan.example.cardgameandroid.cardGame;

public enum Suit {
    HEARTS("H"),
    CLUBS("C"),
    DIAMONDS("D"),
    SPADES("S");

    private String shortString;

    Suit(String shortString){
        this.shortString = shortString;
    }

    public String getShortString() {
        return this.shortString;
    }
}