package com.destiny.bearingo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    ImageView img1;
    TextView txt1;
    TextView txt2;
    ImageView img2;
    ImageView img3, img4;
    TextView txt3, txt4;
    private InterstitialAd interstitialAd;
    Boolean isInternetPresent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isInternetPresent = isConnectingToInternet();

        if (!isInternetPresent) {
            showAlertDialog(MainActivity.this, "No Internet Connection",
                    "please check you connection.", false);
        }


        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-4457607627039532/8222653492");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        // interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdView mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId("ca-app-pub-4457607627039532/9693030727");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        InterstitialAd interstitialAd = null;


//        mAdView.setAdListener(new AdListener() {
//
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//                // Code to be executed when an ad request fails.
//                Toast.makeText(MainActivity.this, "Ad failed: " + errorCode, Toast.LENGTH_SHORT).show();
//            }
//
//
//
//
//        });


//        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);


        img1 = findViewById(R.id.berringBox);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Box.class);
                startActivity(intentLoadNewActivity);
               // showAdvertisement();
            }
        });

        img2 = findViewById(R.id.SearchBox);

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, searchBox.class);
                startActivity(intentLoadNewActivity);
            }
        });

        txt1 = findViewById(R.id.text1);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Box.class);
                startActivity(intentLoadNewActivity);
              //  showAdvertisement();
            }
        });


        txt2 = findViewById(R.id.text2);

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, searchBox.class);
                startActivity(intentLoadNewActivity);
            }
        });

        img3 = findViewById(R.id.AboutBox);

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Info.class);
                startActivity(intentLoadNewActivity);
            }
        });

        txt3 = findViewById(R.id.aboutName);

        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, Info.class);
                startActivity(intentLoadNewActivity);
            }
        });

        img4 = findViewById(R.id.product);

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, productList.class);
                startActivity(intentLoadNewActivity);
            }
        });

        txt4 = findViewById(R.id.productList);

        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, productList.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;

    }

    public void showAlertDialog(final Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        // Setting alert dialog icon
        alertDialog.setIcon(R.drawable.fail);

        // Setting OK Button
//        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                MainActivity.this.finish();
//            }
//        });

        // Showing Alert Message
        alertDialog.show();
    }



    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setIcon(R.drawable.exit)
                .setTitle("EXIT")
                .setMessage("Do you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.super.onBackPressed();
                       // finish();
                    }

                })
                .setNegativeButton("No", null)

                .show();
       // showAdvertisement();
//        super.onBackPressed();
    }
    private void showAdvertisement() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            finish();
        }
    }
    private void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        interstitialAd.loadAd(adRequest);
    }

}