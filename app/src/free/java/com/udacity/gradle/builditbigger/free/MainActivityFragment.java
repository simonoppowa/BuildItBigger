package com.udacity.gradle.builditbigger.free;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.R;

import java.util.Objects;

import butterknife.ButterKnife;
import timber.log.Timber;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static final String INTERSTITIAL_AD_TEST_ID = "ca-app-pub-3940256099942544/1033173712";

    private InterstitialAd mInterstitialAd;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_activity, container, false);

        Timber.plant(new Timber.DebugTree());
        ButterKnife.bind(this, root);


        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Timber.d("InterstitialAd wasn't loaded yet");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        loadInterstitialAd();
    }

    private void loadInterstitialAd() {
        if(getActivity() != null) {
            mInterstitialAd = new InterstitialAd(getActivity());
            mInterstitialAd.setAdUnitId(INTERSTITIAL_AD_TEST_ID);
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }
}
