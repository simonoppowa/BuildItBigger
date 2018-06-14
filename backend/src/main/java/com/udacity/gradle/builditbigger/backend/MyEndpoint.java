package com.udacity.gradle.builditbigger.backend;

import com.github.simonoppowa.javajokeslib.JokeTeller;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * Creates a random joke from javaJokesLib
     * @return created random joke
     */
    @ApiMethod(name = "getJoke")
    public MyJoke getJoke() {
        MyJoke myJoke = new MyJoke();
        myJoke.setJokeData(JokeTeller.getJoke());

        return myJoke;
    }

}
