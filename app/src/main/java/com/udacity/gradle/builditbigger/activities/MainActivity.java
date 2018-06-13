package com.udacity.gradle.builditbigger.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.simonoppowa.androidjokeslib.JokeDisplayActivity;
import com.github.simonoppowa.javajokeslib.JokeTeller;
import com.udacity.gradle.builditbigger.R;

import butterknife.ButterKnife;
import timber.log.Timber;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up libraries
        Timber.plant(new Timber.DebugTree());
        ButterKnife.bind(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        String joke = JokeTeller.getJoke();

        //start new JokeDisplayActivity
        Intent jokeIntent = new Intent(this, JokeDisplayActivity.class);
        jokeIntent.putExtra(JokeDisplayActivity.JOKE_INTENT_KEY, joke);
        startActivity(jokeIntent);
    }
}
