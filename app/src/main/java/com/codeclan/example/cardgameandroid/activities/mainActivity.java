package com.codeclan.example.cardgameandroid.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;

import com.codeclan.example.cardgameandroid.R;
import com.codeclan.example.cardgameandroid.cardGame.*;
import com.codeclan.example.cardgameandroid.cardGame.View;

/**
 * Created by user on 16/12/2016.
 */
public class mainActivity extends AppCompatActivity {
    TextView playerHand;
    Button twist;
    Button stick;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Log log = new Log();
        final Game game = new Game(log);
        final View view = new View(log);

        game.addPlayer("Player");
        game.addDealer("Dealer");

        game.setUp();
        game.dealCardToCurrentPlayer();
        game.dealCardToDealer();

        setContentView(R.layout.activity_main);



        playerHand = (TextView)findViewById(R.id.player_hand);
        twist = (Button)findViewById(R.id.twist);
        stick = (Button)findViewById(R.id.stick);

        playerHand.setText(view.displayCurrentPlayerHand());

        twist.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                game.dealCardToCurrentPlayer();
                view.getPlayerMove("twist");
                game.handleMove();
                playerHand.setText(view.displayCurrentPlayerHand());

                if (!log.getPlaying() || log.getBust()) {
                    twist.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });


    }
}
