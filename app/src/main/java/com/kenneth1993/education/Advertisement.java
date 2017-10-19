package com.kenneth1993.education;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by alfo06-24 on 2017-08-25.
 */

public class Advertisement extends AppCompatActivity {

    AdView adView;
//    AdView adView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advertisement);


        adView=(AdView)findViewById(R.id.advertisement);
        AdRequest adRequest= new AdRequest.Builder().build();
        adView.loadAd(adRequest);

//        adView1=(AdView)findViewById(R.id.advertisement1);
//        AdRequest adRequest1= new AdRequest.Builder().build();
//        adView1.loadAd(adRequest1);

    }


}
