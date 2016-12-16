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
    TextView welcomeText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        welcomeText = (TextView)findViewById(R.id.welcome_text);


    }
}
