package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyJoke {

    private String jokeString;

    public String getData() {
        return jokeString;
    }

    public void setJokeData(String data) {
        jokeString = data;
    }
}