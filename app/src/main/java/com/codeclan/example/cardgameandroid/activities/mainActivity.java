package com.codeclan.example.cardgameandroid.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codeclan.example.cardgameandroid.R;
import com.codeclan.example.cardgameandroid.cardGame.*;

/**
 * Created by user on 16/12/2016.
 */
public class mainActivity extends AppCompatActivity {
    TextView playerHand;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log log = new Log();
        Game game = new Game(log);
        View view = new View(log);

        game.addPlayer("Player");
        game.addDealer("Dealer");

        game.setUp();
        game.dealCardToCurrentPlayer();
        game.dealCardToDealer();

        setContentView(R.layout.activity_main);



        playerHand = (TextView)findViewById(R.id.player_hand);
        
        playerHand.setText(view.displayCurrentPlayerHand());




    }
}
