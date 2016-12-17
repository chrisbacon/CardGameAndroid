package com.codeclan.example.cardgameandroid.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;
import android.widget.LinearLayout;
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
    LinearLayout buttons;

    TextView dealerHand;
    TextView result;

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
        dealerHand = (TextView)findViewById(R.id.dealer_hand);
        result = (TextView)findViewById(R.id.result);


        twist = (Button)findViewById(R.id.twist);
        stick = (Button)findViewById(R.id.stick);

        buttons = (LinearLayout)findViewById(R.id.buttons);

        playerHand.setText(view.displayCurrentPlayerHand());

        twist.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                game.dealCardToCurrentPlayer();
                view.getPlayerMove("twist");
                game.handleMove();
                playerHand.setText(view.displayCurrentPlayerHand());

                if (log.getBust()) {
                    buttons.setVisibility(android.view.View.INVISIBLE);
                    game.setResult();
                    result.setText(view.displayResult());
                }
            }
        });

        stick.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                view.getPlayerMove("stick");
                game.handleMove();
                playerHand.setText(view.displayCurrentPlayerHand());

                buttons.setVisibility(android.view.View.INVISIBLE);

                game.nextPlayer();

                while (log.getPlaying() && !log.getBust()) {
                    game.runDealerTurn();
                    dealerHand.setText(view.displayDealerHand());
                }

                game.setResult();
                result.setText(view.displayResult());

            }
        });


    }
}
