package com.codeclan.example.cardgameandroid;

public enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private String shortString;

    Rank(String shortString){
        this.shortString = shortString;
    }

    public String getShortString() {
        return this.shortString;
    }
}