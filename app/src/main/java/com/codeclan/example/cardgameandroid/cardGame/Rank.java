package com.codeclan.example.cardgameandroid.cardGame;

public enum Rank {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("t"),
    JACK("j"),
    QUEEN("q"),
    KING("k"),
    ACE("a");

    private String shortString;

    Rank(String shortString){
        this.shortString = shortString;
    }

    public String getShortString() {
        return this.shortString;
    }
}