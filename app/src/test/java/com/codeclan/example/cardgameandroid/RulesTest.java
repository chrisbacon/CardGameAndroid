package com.codeclan.example.cardgameandroid;

import com.codeclan.example.cardgameandroid.cardGame.Card;
import com.codeclan.example.cardgameandroid.cardGame.Rank;
import com.codeclan.example.cardgameandroid.cardGame.Rules;
import com.codeclan.example.cardgameandroid.cardGame.Suit;

import org.junit.Before;
import org.junit.Test;


import static junit.framework.Assert.assertEquals;

public class RulesTest {

    Card card;

    @Before
    public void before() {
        card = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void canGetCardValue() {
        assertEquals(11, Rules.getCardValue(card));
    }
}