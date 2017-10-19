package com.kenneth1993.education;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.kenneth1993.education.Grammar.actlist;

public class Application extends AppCompatActivity {

    ListView listView;
    ArrayList<Application_Items_For_ListView> item = new ArrayList<>();
    Application_Items_For_Adapter Adapter;

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_application);






        listView=(ListView)findViewById(R.id.listView);
        item.add(new Application_Items_For_ListView(R.drawable.background_school,"기초 복습하기","여태배운 문법중에서도 엄청 기초적인 것들을 다시 떠올려봅니다."));
        item.add(new Application_Items_For_ListView(R.drawable.background_bus,"버스에서","버스에서 있을 법한 상황에 대해서 알아봅니다."));
        item.add(new Application_Items_For_ListView(R.drawable.background_street,"거리에서","거리에서 있을 법한 상황에 대해서 알아봅니다."));
        item.add(new Application_Items_For_ListView(R.drawable.background_store,"상점에서","상점에서 있을 법한 상황에 대해서 알아봅니다."));
        item.add(new Application_Items_For_ListView(R.drawable.background_bank,"은행에서","은행에서 있을 법한 상황에 대해서 알아봅니다."));
        item.add(new Application_Items_For_ListView(R.drawable.background_restaurants,"식당에서","식당에서 있을 법한 상황에 대해서 알아봅니다."));
//        item.add(new Application_Items_For_ListView(R.drawable.number_07,"전화통화","통화할때의 기본 회화를 알아봅니다."));
//        item.add(new Application_Items_For_ListView(R.drawable.number_08,"집안에서","말다툼했다."));



        LayoutInflater inflater= getLayoutInflater();
        Adapter=new Application_Items_For_Adapter(item,inflater);
        listView.setAdapter(Adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(position){
                    case 0:{//학교에서
                        for(int i=0; i<actlist.size();i++) {
                            actlist.get(i).finish();}
                        Intent intent=new Intent(Application.this,Application_ListView_Atschool.class);
                        startActivity(intent);
                    }break;

                    case 1:{//버스에서
                        for(int i=0; i<actlist.size();i++) {
                            actlist.get(i).finish();}
                        Intent intent=new Intent(Application.this,Application_ListView_AtBus.class);
                        startActivity(intent);
                    }break;

                    case 2:{//거리에서
                        for(int i=0; i<actlist.size();i++) {
                            actlist.get(i).finish();}
                        Intent intent=new Intent(Application.this,Application_ListView_AtStreet.class);
                        startActivity(intent);
                    }break;

                    case 3:{//상점에서
                        for(int i=0; i<actlist.size();i++) {
                            actlist.get(i).finish();}
                        Intent intent=new Intent(Application.this,Application_ListView_AtStore.class);
                        startActivity(intent);
                    }break;

                    case 4:{//은행에서
                        for(int i=0; i<actlist.size();i++) {
                            actlist.get(i).finish();}
                        Intent intent=new Intent(Application.this,Application_ListView_AtBank.class);
                        startActivity(intent);
                    }break;

                    case 5:{//식당에서
                        for(int i=0; i<actlist.size();i++) {
                            actlist.get(i).finish();}
                        Intent intent=new Intent(Application.this,Application_ListView_AtRestaurant.class);
                        startActivity(intent);
                    }break;

                    case 6:{//전화
                        for(int i=0; i<actlist.size();i++) {
                            actlist.get(i).finish();}
                        Toast.makeText(Application.this, "준비중입니다..", Toast.LENGTH_SHORT).show();
                    }break;

                }
            }
        });


    }
    public void BtnList(View v){
        //activity_grammar_listitem.xml 띄워야함



        AlertDialog.Builder builder=new AlertDialog.Builder(Application.this);
        builder.setTitle("플레이 목차");
        LayoutInflater inflator= getLayoutInflater();
        LinearLayout layout=(LinearLayout)inflator.inflate(R.layout.activity_applicaiton_listitem,null);
        builder.setView(layout);


        AlertDialog dialog=builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();



    }

    public void showdia(View v){
        showdialog();
    }

    public void text1_1(View v){
        Intent intent=new Intent(this,Application_ListView_Atschool.class);
        startActivity(intent);
    }

    public void text1_2(View v){
        Intent intent=new Intent(this,Application_ListView_Atschool1.class);
        startActivity(intent);
    }

    public void text1_3(View v){
        Intent intent=new Intent(this,Application_ListView_Atschool2.class);
        startActivity(intent);
    }

    public void text1_4(View v){
        Intent intent=new Intent(this,Application_ListView_Atschool3.class);
        startActivity(intent);
    }

    public void text1_5(View v){
        Intent intent=new Intent(this,Application_ListView_Atschool4.class);
        startActivity(intent);
    }

    public void text2_1(View v){
        Intent intent=new Intent(this,Application_ListView_AtBus.class);
        startActivity(intent);
    }

    public void text3_1(View v){
        Intent intent=new Intent(this,Application_ListView_AtStreet.class);
        startActivity(intent);
    }

    public void text4_1(View v){
        Intent intent=new Intent(this,Application_ListView_AtStore.class);
        startActivity(intent);
    }

    public void text5_1(View v){
        Intent intent=new Intent(this,Application_ListView_AtBank.class);
        startActivity(intent);
    }

    public void text6_1(View v){
        Intent intent=new Intent(this,Application_ListView_AtRestaurant.class);
        startActivity(intent);
    }


    public void showdialog(){

        //이 섹션에대한 플레이방법 띄우는 다이얼로그
        Application_Atschool_For_Draw view = new Application_Atschool_For_Draw(this, null);
        view.findViewById(R.id.view);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("이용 방법");

        LayoutInflater inflater = getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.customdialog, null);
        builder.setPositiveButton("확인",null);
        builder.setView(layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        ////////////////////////////////////////////////


    }//showdialog 메서드

}
