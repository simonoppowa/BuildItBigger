package com.github.simonoppowa.androidjokeslib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import timber.log.Timber;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_INTENT_KEY = "jokeIntentKey";

    private String mJoke;

    private TextView mJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        //set up libraries
        Timber.plant(new Timber.DebugTree());

        //bind views
        mJokeTextView = findViewById(R.id.joke_textView);

        //get joke from intent
        Intent jokeIntent = getIntent();
        mJoke = jokeIntent.getStringExtra(JOKE_INTENT_KEY);

        if(mJoke == null) {
            throw new NullPointerException("No Joke was passed to JokeDisplayActivity");
        }

        mJokeTextView.setText(mJoke);
    }
}
