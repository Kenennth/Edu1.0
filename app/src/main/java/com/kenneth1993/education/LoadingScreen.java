package com.kenneth1993.education;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

public class LoadingScreen extends AppCompatActivity {

    ViewPager pager;
    Loading_Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadingscreen);



        pager=(ViewPager)findViewById(R.id.pager);
        adapter=new Loading_Adapter(getLayoutInflater());
        pager.setAdapter(adapter);

       pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               int index=pager.getCurrentItem();
               if(index==9){
                   final AlertDialog.Builder builder=new AlertDialog.Builder(LoadingScreen.this);
                   builder.setTitle("Exit");
                   LayoutInflater inflater=getLayoutInflater();

                   LinearLayout layout=(LinearLayout)inflater.inflate(R.layout.activity_loadingscreen_dialog,null);
                   builder.setView(layout);

                   builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           finish();
                           Intent intent = new Intent(LoadingScreen.this, MainScreen.class);
                           startActivity(intent);

                       }
                   });


                   AlertDialog dialog= builder.create();
                   dialog.show();
               }

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }

    public void skip(View v){
        finish();
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}
