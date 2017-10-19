package com.kenneth1993.education;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainScreen extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);


    }

    public void HowToUse(View v){
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("어플 이용방법");

        LayoutInflater inflater=getLayoutInflater();
        LinearLayout layout=(LinearLayout)inflater.inflate(R.layout.activity_howtouse_dialog,null);
        builder.setView(layout);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog alertDialog=builder.create();
                alertDialog.cancel();


            }
        });


        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }

    public void Grammar(View v){
        Intent intent= new Intent(this,Grammar.class);
        startActivity(intent);
    }

    public void Application(View v){
        Intent intent=new Intent(this,Application.class);
        startActivity(intent);
    }
    public void FeedBack(View v){
        Intent intent=new Intent(this,FeedBack.class);
        startActivity(intent);
    }

    public void Advertisement (View v){
        Intent intent =new Intent(this, Advertisement.class);
        startActivity(intent);
    }


}
