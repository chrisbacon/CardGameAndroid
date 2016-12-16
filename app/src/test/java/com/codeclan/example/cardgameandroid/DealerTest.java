package com.codeclan.example.cardgameandroid;

import com.codeclan.example.cardgameandroid.Card;
import com.codeclan.example.cardgameandroid.Dealer;
import com.codeclan.example.cardgameandroid.Deck;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DealerTest {
    
    Dealer dealer;
    Deck deck;

    @Before
    public void before() {
        deck = new Deck();
        dealer = new Dealer("Logan", deck);
    }

    @Test
    public void canGetDeckSize() {
        assertEquals(0, dealer.getDeckSize());
    }

    @Test
    public void canAddCardToDeck() {
        Card card = mock(Card.class);
        dealer.addCardToDeck(card);
        assertEquals(1, dealer.getDeckSize());
    }
}