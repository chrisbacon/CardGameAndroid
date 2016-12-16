package com.codeclan.example.cardgameandroid.cardGame;

public class Log {
    private Player winner;
    private Player loser;
    private Player currentPlayer;
    private Dealer dealer;
    private boolean draw;
    private boolean bust;
    private String move;
    private boolean playing;

    public Log() {
        this.playing = true;
        this.draw = false;
        this.bust = false;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Dealer getDealer(){
        return this.dealer;
    }

    public void setPlaying(boolean flag){
        this.playing = flag;
    }

    public boolean getPlaying(){
        return this.playing;
    }

    public void setBust(boolean flag) {
        this.bust = flag;
    }

    public boolean getBust(){
        return this.bust;
    }

    public void setDraw(boolean flag) {
        this.draw = flag;
    }

    public boolean getDraw(){
        return this.draw;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return this.winner;
    }

    public void setLoser(Player loser) {
        this.loser = loser ;
    }

    public Player getLoser() {
        return this.loser;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getMove() {
        return this.move;
    }
}