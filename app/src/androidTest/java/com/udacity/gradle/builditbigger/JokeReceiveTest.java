package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.tasks.JokeAsyncTask;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

@RunWith(AndroidJUnit4.class)
public class JokeReceiveTest {

    private Context instrumentationCtx;

    @Before
    public void setup() {
        instrumentationCtx = InstrumentationRegistry.getContext();
    }

    @Test
    public void jokeAsyncTask_returns_randomJoke() {

        String joke = null;

        try {
            JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(instrumentationCtx, null) {

                @Override
                protected void onPostExecute(String result) {
                    //don't launch new activity
                }
            };

            jokeAsyncTask.execute();

            joke = jokeAsyncTask.get(30, TimeUnit.SECONDS);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            fail("Timed out");
        }

        assertNotNull(joke);
    }
}
