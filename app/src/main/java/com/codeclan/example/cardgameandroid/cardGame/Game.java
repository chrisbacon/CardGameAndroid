package com.codeclan.example.cardgameandroid.cardGame;

public class Game {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private Rules rules;
    private Log log;

    public Game(Log log) {
        this.deck = new Deck();
        this.deck.buildDeck();
        this.log = log;
    } 

    public void addPlayer(String name) {
        this.player = new Player(name);
    }

    public void addDealer(String name) {
        this.dealer = new Dealer(name, deck);
        log.setDealer(this.dealer);
    }

    public void setUp() {
        log.setCurrentPlayer(player);
        dealer.shuffle();
    }

    public void dealCardToCurrentPlayer() {
        dealer.dealCardTo(log.getCurrentPlayer());
        log.setBust(Rules.checkForBust(log.getCurrentPlayer()));
    }

    public void dealCardToDealer() {
        dealer.dealCardTo(dealer);
        log.setBust(Rules.checkForBust(dealer));
    }

    // public void checkForBust() {
        
    // }

    public void handleMove() {
        String move = log.getMove();
        switch (move) {
            case "stick":  log.setPlaying(false);
                           break;   
            case "twist":  log.setPlaying(true);
                           break;
        }
    }

    public void nextPlayer() {
        log.setCurrentPlayer(dealer);
        log.setPlaying(true);
    }

    public void runDealerTurn() {
        if (dealer.getHandValue() < 16) {
            dealCardToDealer();
        } else {
            log.setPlaying(false);
        }
    }

    public void setResult() {
        if (Rules.didDraw(player, dealer)) {
            log.setDraw(true);
            log.setWinner(dealer);
            log.setLoser(player);
        } else if (Rules.didPlayerWin(player, dealer)) {
            log.setWinner(player);
            log.setLoser(dealer);
        } else {
            log.setWinner(dealer);
            log.setLoser(player);
            
        }
    }
}