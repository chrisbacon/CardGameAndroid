package com.codeclan.example.cardgameandroid.activities;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codeclan.example.cardgameandroid.R;
import com.codeclan.example.cardgameandroid.cardGame.*;
import com.codeclan.example.cardgameandroid.cardGame.View;

/**
 * Created by user on 16/12/2016.
 */
public class mainActivity extends AppCompatActivity {
    Button twist;
    Button stick;
    Button reset;

    LinearLayout buttons;
    LinearLayout playerHand;
    LinearLayout dealerHand;

    TextView playerName;
    TextView dealerName;
    TextView result;

    View view;
    Game game;
    Log log;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        log = new Log();
        game = new Game(log);
        view = new View(log);

        game.addPlayer("Player");
        game.addDealer("Dealer");

        start();

        setContentView(R.layout.activity_main);

        playerName = (TextView)findViewById(R.id.player_name);
        playerName.setText("Player");

        dealerName = (TextView)findViewById(R.id.dealer_name);
        dealerName.setText("Dealer");

        result = (TextView)findViewById(R.id.result);

        twist = (Button)findViewById(R.id.twist);
        stick = (Button)findViewById(R.id.stick);
        reset = (Button)findViewById(R.id.reset);

        buttons = (LinearLayout)findViewById(R.id.buttons);
        playerHand = (LinearLayout)findViewById(R.id.player_hand);
        dealerHand = (LinearLayout)findViewById(R.id.dealer_hand);

        ObjectAnimator animator = prepareAnimator(playerHand);
        animator.start();

        twist.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                game.dealCardToCurrentPlayer();
                view.getPlayerMove("twist");
                game.handleMove();
                ObjectAnimator animator = prepareAnimator(playerHand);
                animator.start();

                if (log.getBust()) {
                    doResult();
                }
            }
        });

        stick.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                view.getPlayerMove("stick");
                game.handleMove();
                game.nextPlayer();

                while (log.getPlaying() && !log.getBust()) {
                    game.runDealerTurn();
                    if (log.getPlaying()) {
                        ObjectAnimator animator = prepareAnimator(dealerHand);
                        animator.start();
                    }
                }

                doResult();
            }
        });

        reset.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                game.endRound();

                dealerHand.removeAllViews();
                playerHand.removeAllViews();

                start();

                ObjectAnimator animator = prepareAnimator(playerHand);
                animator.start();

                result.setText("");
                buttons.setVisibility(android.view.View.VISIBLE);

            }
        });
    }

    private ObjectAnimator prepareAnimator(LinearLayout hand) {

        String fileName = view.getLastCardImageFileName();

        ImageView card = new ImageView(getBaseContext());

        card.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        int resID = getResources().getIdentifier(fileName , "drawable", getPackageName());
        card.setImageResource(resID);
        hand.addView(card);

        return ObjectAnimator.ofFloat(card, "translationX", 600, 0)
                .setDuration(300);
    }

    private void doResult() {
        buttons.setVisibility(android.view.View.INVISIBLE);
        game.setResult();
        result.setText(view.displayResult());
    }

    private void start() {
        game.setUp();
        game.dealCardToCurrentPlayer();
    }
}
