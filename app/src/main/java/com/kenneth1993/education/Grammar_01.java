package com.kenneth1993.education;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import static com.kenneth1993.education.Grammar.actlist;

public class Grammar_01 extends AppCompatActivity {

    ViewPager pager;
    Grammar_pager adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_01);

        actlist.add(this);

        pager=(ViewPager)findViewById(R.id.pager1);
        adapter=new Grammar_pager(getLayoutInflater());
        pager.setAdapter(adapter);

        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {

                page.setAlpha(1-Math.abs(position));//page가 움직이면 조금씩 흐려지게 하는 메서드
                // postition이 0일때 alpha는 1.0
                // postition이 0.1일때 alpha는 0.9 이런식으로 나오게하려면 1-position의 절대값을 빼줘야함.

                //이미지를 돌리기,
                page.setRotationY(position*90);
                //postition이 0일때 alpha는 0도
                //postition이 0.1일때, 9도 이런식으로 나오게하려면, position*90도를 해야함,

                //이미지가 돌려질때, 원근감을 주는 방법
                page.setScaleX((1-Math.abs(position))/2+0.5f);
                page.setScaleY((1-Math.abs(position))/2+0.5f);

            }
        });

    }






}
