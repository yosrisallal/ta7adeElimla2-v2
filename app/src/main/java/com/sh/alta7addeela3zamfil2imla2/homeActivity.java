package com.sh.alta7addeela3zamfil2imla2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class homeActivity extends AppCompatActivity {
ImageView offline_online;
TextView year12,year13,year14,year15,year16,year17,year18,year19,youtube,website,facebook;
    private InterstitialAd mInterstitialAd;
    AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                AdView adView = new AdView(homeActivity.this);

                adView.setAdSize(AdSize.BANNER);

                adView.setAdUnitId("ca-app-pub-3623255915762740/63325387051");
                 adRequest = new AdRequest.Builder().build();
                 showad();
            }
        });

        offline_online=findViewById(R.id.online_or_offline);
        year12=findViewById(R.id.year12);
        year13=findViewById(R.id.year13);
        year14=findViewById(R.id.year14);
        year15=findViewById(R.id.year15);
        year16=findViewById(R.id.year16);
        year17=findViewById(R.id.year17);
        year18=findViewById(R.id.year18);
        year19=findViewById(R.id.year19);
        youtube=findViewById(R.id.youtube);
        facebook=findViewById(R.id.facebook);
        website=findViewById(R.id.website);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCI6iERAueVFkEhrOKStFDNA"));
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nhwdotcom"));
                startActivity(intent);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.alnahw.com/"));
                startActivity(intent);
            }
        });
        year12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",12);
                startActivity(intent);
            }
        });
        year13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",13);
                startActivity(intent);
            }
        });
        year14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",14);
                startActivity(intent);
            }
        });

        year15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",15);
                startActivity(intent);
            }
        });
        year16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",16);
                startActivity(intent);
            }
        });
        year17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",17);
                startActivity(intent);
            }
        });
        year18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",18);
                startActivity(intent);
            }
        });
        year19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",19);
                startActivity(intent);
            }
        });


        switch ((getIntent().getStringExtra("internet connection"))){
                case "no":
                offline_online.setImageResource(R.drawable.offline);
                    break;
                case "yes":
                offline_online.setImageResource(R.drawable.online);
                    break;
            }

    }
    public void showad(){
        InterstitialAd.load(homeActivity.this,"ca-app-pub-3623255915762740/37063753692", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(homeActivity.this);
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.");

                        }
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when fullscreen content is dismissed.
                                Log.d("TAG", "The ad was dismissed.");
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when fullscreen content failed to show.
                                Log.d("TAG", "The ad failed to show.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when fullscreen content is shown.
                                // Make sure to set your reference to null so you don't
                                // show it a second time.
                                mInterstitialAd = null;
                                Log.d("TAG", "The ad was shown.");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

    }
}






