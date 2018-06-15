package com.udacity.gradle.builditbigger.tasks;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.github.simonoppowa.androidjokeslib.JokeDisplayActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    private static final String ANDROID_VIRTUAL_EMULATOR_URL = "http://10.0.2.2:8080/_ah/api/";
    private static final String GENYMOTION_VIRTUAL_EMULATOR_URL = "http://10.0.3.2:8080/_ah/api/";

    private static MyApi myApiService = null;
    private final Context context;
    private final OnTaskCompleted mCallback;

    public interface OnTaskCompleted {
        void onTaskCompleted();
    }


    public JokeAsyncTask(Context context, OnTaskCompleted callback) {
        this.context = context;
        this.mCallback = callback;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(GENYMOTION_VIRTUAL_EMULATOR_URL)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
    @Override
    protected void onPostExecute(String result) {
        //start new JokeDisplayActivity
        Intent jokeIntent = new Intent(context, JokeDisplayActivity.class);
        jokeIntent.putExtra(JokeDisplayActivity.JOKE_INTENT_KEY, result);
        jokeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(jokeIntent);

        mCallback.onTaskCompleted();
    }
}
