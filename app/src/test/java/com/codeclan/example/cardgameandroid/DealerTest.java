package com.codeclan.example.cardgameandroid;

import com.codeclan.example.cardgameandroid.cardGame.Card;
import com.codeclan.example.cardgameandroid.cardGame.Dealer;
import com.codeclan.example.cardgameandroid.cardGame.Deck;
import com.codeclan.example.cardgameandroid.cardGame.Player;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void dealerIntegrationTest() {
        Player player = new Player("Chris");
        Deck deck = new Deck();
        deck.buildDeck();
        Dealer dealer = new Dealer("Logan", deck);

        dealer.dealCardTo(player);
        dealer.dealCardTo(player);
        dealer.dealCardTo(player);
        dealer.dealCardTo(player);
        dealer.dealCardTo(player);


        assertEquals(5, player.getHandSize());
        assertEquals(47, dealer.getDeckSize());

        dealer.getHandFromPlayerAndAddToDeck(player);

        assertEquals(0, player.getHandSize());
        assertEquals(52, dealer.getDeckSize());
    }
}