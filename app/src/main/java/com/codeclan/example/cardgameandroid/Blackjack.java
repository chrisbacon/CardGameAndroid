package com.codeclan.example.cardgameandroid;

public class Blackjack {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private Rules rules;
    private Log log;

    public Blackjack(Log log) {
        this.deck = new Deck();
        this.deck.buildDeck(); 
        this.log = log;
    } 

    public void addPlayer(String name) {
        this.player = new Player(name);
    }

    public void addDealer(String name) {
        this.dealer = new Dealer(name, this.deck);
        this.log.setDealer(this.dealer);
    }

    public void setUp() {
        this.log.setCurrentPlayer(this.player);
        this.dealer.shuffle();
    }

    public void dealCardToCurrentPlayer() {
        this.dealer.dealCardTo(this.log.getCurrentPlayer());
        this.log.setBust(Rules.checkForBust(this.log.getCurrentPlayer()));
    }

    public void dealCardToDealer() {
        this.dealer.dealCardTo(this.dealer);
        this.log.setBust(Rules.checkForBust(this.dealer));
    }

    // public void checkForBust() {
        
    // }

    public void handleMove() {
        String move = this.log.getMove();
        switch (move) {
            case "stick":  this.log.setPlaying(false);
                           break;   
            case "twist":  this.log.setPlaying(true);
                           break;
        }
    }

    public void nextPlayer() {
        this.log.setCurrentPlayer(this.dealer);
        this.log.setPlaying(true);
    }

    public void runDealerTurn() {
        if (this.dealer.getHandValue() < 16) {
            dealCardToDealer();
        } else {
            this.log.setPlaying(false);
        }
    }

    public void setResult() {
        if (Rules.didDraw(this.player, this.dealer)) {
            this.log.setDraw(true);
            this.log.setWinner(dealer);
            this.log.setLoser(player);
        } else if (Rules.didPlayerWin(this.player, this.dealer)) {
            this.log.setWinner(player);
            this.log.setLoser(dealer);
        } else {
            this.log.setWinner(dealer);
            this.log.setLoser(player);
            
        }
    }
}