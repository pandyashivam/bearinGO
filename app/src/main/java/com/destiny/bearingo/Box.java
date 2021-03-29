package com.destiny.bearingo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class Box extends AppCompatActivity {
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
  //  private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);

       // interstitialAd=new InterstitialAd(this);
        //interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
       // interstitialAd.setAdUnitId("ca-app-pub-6491182242162559/6674587006");
       // interstitialAd.loadAd(new AdRequest.Builder().build());
       //interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

//

        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-4457607627039532/1418244445");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        image1 = findViewById(R.id.pic1);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, list_item.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t1 = findViewById(R.id.text1);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, list_item.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image2 = findViewById(R.id.pic2);

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, two.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t2 = findViewById(R.id.text2);

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, two.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image3 = (ImageView) findViewById(R.id.pic3);

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, three.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t3 = (TextView) findViewById(R.id.text3);

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, three.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image4 = (ImageView) findViewById(R.id.pic4);

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, four.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t4 = (TextView) findViewById(R.id.text4);

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, four.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image5 = (ImageView) findViewById(R.id.pic5);

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, five.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t5 = (TextView) findViewById(R.id.text5);

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, five.class);
                startActivity(intentLoadNewActivity);
            }
        });


        image6 = (ImageView) findViewById(R.id.pic6);

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, six.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t6 = (TextView) findViewById(R.id.text6);

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, six.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image7 = (ImageView) findViewById(R.id.pic7);

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, seven.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t7 = (TextView) findViewById(R.id.text7);

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, seven.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image8 = (ImageView) findViewById(R.id.pic11);

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, eight.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t8 = (TextView) findViewById(R.id.text8);

        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, eleven.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image9 = (ImageView) findViewById(R.id.pic9);

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, nine.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t9 = (TextView) findViewById(R.id.text9);

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, nine.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image10 = (ImageView) findViewById(R.id.pic10);

        image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, ten.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t10 = (TextView) findViewById(R.id.text10);

        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, ten.class);
                startActivity(intentLoadNewActivity);
            }
        });

        image11 = (ImageView) findViewById(R.id.pic8);

        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, eleven.class);
                startActivity(intentLoadNewActivity);
            }
        });

        t11 = (TextView) findViewById(R.id.text11);

        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Box.this, eleven.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }

    @Override
    public void onBackPressed() {
     finish();
       // showAdvertisement();
//        super.onBackPressed();
    }
   /* private void showAdvertisement() {
        if (interstitialAd.isLoaded()) {
            loadInterstitialAd();
            interstitialAd.show();
        } else {
            finish();
        }
    }
    private void loadInterstitialAd() {
        AdRequest adRequest1 = new AdRequest.Builder()
                .build();

        interstitialAd.loadAd(adRequest1);
    }*/

    // @Override
//    public void onBackPressed() {
//
//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//
//                if (mInterstitialAd.isLoaded()) {
//                    mInterstitialAd.show();
//                }
//
//            }
//
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//                finish();
//
//            }
//        });
//            if (mInterstitialAd.isLoaded()) {
//                mInterstitialAd.show();
//                mInterstitialAd.setAdListener(new AdListener() {
//                    @Override
//                    public void onAdClosed() {
//                        super.onAdClosed();
//                        finish();
//                    }
//                });
//            }else{
//                super.onBackPressed();
//            }

        }
