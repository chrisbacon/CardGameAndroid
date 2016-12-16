package com.codeclan.example.cardgameandroid;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

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