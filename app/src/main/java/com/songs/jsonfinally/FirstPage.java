package com.songs.jsonfinally;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button topbtn;
    Button share;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        button1=(Button)findViewById(R.id.firstbtn);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(i);
                finish();
            }
        });

        button2=(Button)findViewById(R.id.secondbtn);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),FirstList.class);
                startActivity(i);
                finish();
            }
        });

        button3=(Button)findViewById(R.id.thirdbtn);
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),SecondList.class);
                startActivity(i);
                finish();
            }
        });

        topbtn=(Button)findViewById(R.id.rateus);
        topbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                launchMarket();
                finish();
            }
        });

        share=(Button)findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                shareApp(getApplicationContext());
            }
        });



    }



    public void shareApp(Context context)
    {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Best Islamic Songs");
            String sAux = "\nTry this new application\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id="+ getPackageName();
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "choose one"));
        } catch(Exception e) {
            //e.toString();
        }
    }



    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(FirstPage.this);
        builder.setMessage("Are you sure want to do this ?");
        builder.setCancelable(true);
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
