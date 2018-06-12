package com.github.simonoppowa.javajokeslib;

import java.util.Random;

public class JokeTeller {

    private static final int NUM_JOKES = JokeConstants.JOKE.length;

    public static String getJoke() {
        int randomNum = new Random().nextInt(NUM_JOKES);

        return JokeConstants.JOKE[randomNum];
    }

}
