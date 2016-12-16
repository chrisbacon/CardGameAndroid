package com.codeclan.example.cardgameandroid;

public class View {
    private Log log;

    public View(Log log) {
        this.log = log;
    }

    public void displayCurrentPlayerHand() {
        Player player = this.log.getCurrentPlayer();
        System.out.println(player.getName() + ": " + player.getHandString());
    }

    public void displayDealerHand() {
        Dealer dealer = this.log.getDealer();
        System.out.println(dealer.getName() + ": " + dealer.getHandString());
    }

    public void displayResult() {
        Player winner = this.log.getWinner();
        Player loser = this.log.getLoser();
        String output;

        if (!this.log.getDraw()) {
            output = winner.getName() + " wins with " + winner.getHandValue() + " against " + loser.getHandValue() + "!";
        } else {
            output = "Draw! Both the player and the dealer have " + winner.getHandValue();
        }

        if (this.log.getBust()) {
            output = this.log.getCurrentPlayer().getName() + " went bust with " + this.log.getCurrentPlayer().getHandValue();
        }

        System.out.println(output); 

    }

    public void getPlayerMove() {
        System.out.println("Stick or Twist?: ");
        String move = System.console().readLine().toLowerCase();
        this.log.setMove(move);
    }
}