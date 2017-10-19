package com.kenneth1993.education;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.AbstractCursor;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class Grammar extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    int count=0;
    static int okay=0;

    public static ArrayList<Activity> actlist=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammer);





//        pager=(ViewPager)findViewById(R.id.pager);
//        adapter=new Grammar_pager(getLayoutInflater());
//        pager.setAdapter(adapter);
        setFullAd();
        dialog();

    }

    public void dialog(){

        if(okay==0){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("이용방법");


            LayoutInflater Inflater = getLayoutInflater();
            LinearLayout layout=(LinearLayout)Inflater.inflate(R.layout.customdialogforgra,null);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                okay=1;

                }
            });

            builder.setView(layout);
            AlertDialog dialog=builder.create();
            dialog.show();

        }


    }

    public void btn1(View v){
        //광고1.
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();
        }
            Intent intent =new Intent(Grammar.this,Grammar_01.class);
            startActivity(intent);




    }
    public void btn2(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고

        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();
        }
            Intent intent = new Intent(Grammar.this, Grammar_02.class);
            startActivity(intent);


    }
    public void btn3(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고

        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

            Intent intent = new Intent(Grammar.this, Grammar_03.class);
            startActivity(intent);



    }

    public void btn4(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

            Intent intent = new Intent(Grammar.this, Grammar_04.class);
            startActivity(intent);


    }

    public void btn5(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

            Intent intent = new Intent(Grammar.this, Grammar_05.class);
            startActivity(intent);


    }

    public void btn6(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

            Intent intent = new Intent(Grammar.this, Grammar_06.class);
            startActivity(intent);


    }

    public void btn7(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고

        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

            Intent intent = new Intent(Grammar.this, Grammar_07.class);
            startActivity(intent);


    }

    public void btn8(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고

        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

            Intent intent = new Intent(Grammar.this, Grammar_08.class);
            startActivity(intent);

    }
    public void btn9(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

        Intent intent=new Intent(Grammar.this,Grammar_09.class);
        startActivity(intent);
    }

    public void btn10(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

        Intent intent=new Intent(Grammar.this,Grammar_10.class);
        startActivity(intent);
    }
    public void btn11(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

        Intent intent=new Intent(Grammar.this,Grammar_11.class);
        startActivity(intent);
    }

    public void btn12(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

        Intent intent=new Intent(Grammar.this,Grammar_12.class);
        startActivity(intent);
    }

    public void btn13(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고

        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

        Intent intent=new Intent(Grammar.this,Grammar_13.class);
        startActivity(intent);
    }

    public void btn14(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

        Intent intent=new Intent(Grammar.this,Grammar_14.class);
        startActivity(intent);
    }
    public void btn15(View v){
        count++;
        if(count>2){
            if(mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
                count=0;
            }
        }//광고
        for(int i=0; i<actlist.size();i++) {
            actlist.get(i).finish();}

        Intent intent=new Intent(Grammar.this,Grammar_15.class);
        startActivity(intent);
    }
    public void btn16(View v){

    }

    public void btn17(View v){

    }
    public void btn18(View v){

    }
    public void btn19(View v){

    }
    public void btn20(View v){

    }
    public void btn21(View v){

    }
    public void btn22(View v){

    }
    public void btn23(View v){

    }
    public void btn24(View v){

    }
    public void btn25(View v){

    }

    public void setFullAd(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4630665392757339/5264978511");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }//광고
    public void clicked (View v){
        okay=1;
    }

}
