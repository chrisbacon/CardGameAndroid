package com.codeclan.example.cardgameandroid.cardGame;

public enum Suit {
    HEARTS("he"),
    CLUBS("cl"),
    DIAMONDS("di"),
    SPADES("sp");

    private String shortString;

    Suit(String shortString){
        this.shortString = shortString;
    }

    public String getShortString() {
        return this.shortString;
    }
}