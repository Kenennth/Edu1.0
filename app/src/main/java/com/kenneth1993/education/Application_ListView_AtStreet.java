package com.kenneth1993.education;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.kenneth1993.education.Application_AtStreet_For_Draw.life;
import static com.kenneth1993.education.Grammar.actlist;

public class Application_ListView_AtStreet extends AppCompatActivity {

    Button[] btn= new Button[4];
    Random random=new Random();
    int A,B,C,D;
    public static boolean fail = false;
    TextView usertv1;TextView usertv4;TextView usertv7;
    TextView usertv2;TextView usertv5;
    TextView usertv3;TextView usertv6;

//    TextView [] userTv=new TextView[7];

    TextView cputv1;TextView cputv4;TextView cputv7;
    TextView cputv2;TextView cputv5;
    TextView cputv3;TextView cputv6;

//    TextView[] cpuTv=new TextView[7];


    Timer timer;
    TimerTask task;
    static int tvCount6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atstreet);

//
//        for(int i=0; i<7; i++){
//            userTv[i]=(TextView)findViewById(R.id.user_00+i);
//            cpuTv[i]=(TextView)findViewById(R.id.cpu_00+i);
//
//        }

        usertv1=(TextView)findViewById(R.id.user_00);
        usertv2=(TextView)findViewById(R.id.user_01);
        usertv3=(TextView)findViewById(R.id.user_02);
        usertv4=(TextView)findViewById(R.id.user_03);
        usertv5=(TextView)findViewById(R.id.user_04);
        usertv6=(TextView)findViewById(R.id.user_05);
        usertv7=(TextView)findViewById(R.id.user_06);

        cputv1=(TextView)findViewById(R.id.cpu_00);
        cputv2=(TextView)findViewById(R.id.cpu_01);
        cputv3=(TextView)findViewById(R.id.cpu_02);
        cputv4=(TextView)findViewById(R.id.cpu_03);
        cputv5=(TextView)findViewById(R.id.cpu_04);
        cputv6=(TextView)findViewById(R.id.cpu_05);
        cputv7=(TextView)findViewById(R.id.cpu_06);




        //버튼을 랜덤으로 띄우기위한 조건문//////////////////////////////////////////
        while(true) {
            A = random.nextInt(4); //랜덤값을 얻음0~3
            B = random.nextInt(4); //랜덤값을 얻음0~3
            C = random.nextInt(4); //랜덤값을 얻음0~3
            D = random.nextInt(4); //랜덤값을 얻음0~3

            if (A == B || A == C || A == D || B == C || B == D || C == D) {

                A = random.nextInt(4);
                B = random.nextInt(4);
                C = random.nextInt(4);
                D = random.nextInt(4);

            }else {
                btn[A] = (Button) findViewById(R.id.btn_0+A);
                btn[B] = (Button) findViewById(R.id.btn_0+B);
                btn[C] = (Button) findViewById(R.id.btn_0+C);
                btn[D] = (Button) findViewById(R.id.btn_0+D);
                break;
            }

        }
        ///////////////////////////////////////////////////////////////////////////



        StartAnswer();





        //타이머를 이용해서 화면에 cpu 텍스트 찍어내기..
        timer=new Timer();
        task=new TimerTask() {
            @Override
            public void run() {
                tvCount6++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(life==30){
                            Toast.makeText(Application_ListView_AtStreet.this, "fail", Toast.LENGTH_SHORT).show();

                            //패배했습니다 다이얼로그 띄우기
                            final AlertDialog.Builder builder=new AlertDialog.Builder(Application_ListView_AtStreet.this);
                            builder.setTitle("복습을 더 하셔야겠어요!");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intent=new Intent(Application_ListView_AtStreet.this,Application.class);
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            AlertDialog dialog= builder.create();
                            dialog.show();
                        }

                        //max 50초 5초 대화시작, [버튼 누를 기회 10초] 14초 cpu 대화 15초 버튼 바꾸기 25초 버튼 바꾸기.
                        if(tvCount6==65){ task.cancel();}
                        Toast.makeText(Application_ListView_AtStreet.this, "곧 시작됩니다.", Toast.LENGTH_SHORT).show();
                        //kenneth가 말을 시작하기 전에 클릭 불가능
                        if(tvCount6<3){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount6==3){ cputv1.setText("Friend : Oh, this is very nice street. There are many things to see!");}
                        if(tvCount6==4){ usertv1.setText("Me : Yes, I think so");}
                        if(tvCount6==9){ cputv2.setText("Friend : Hey, dude look at that!");}
                        if(tvCount6==10){ StartAnswer(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount6==16){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount6==17){ cputv3.setText("Friend : Don't you see that girl? Look at the girl closer");}
                        if(tvCount6==18){ Answer1(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount6==24){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount6==25){ cputv4.setText("Friend : She has pretty long brown hair, she looks beautiful");}
                        if(tvCount6==26){ Answer2(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount6==32){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount6==33){ cputv5.setText("Friend : Okay, I've ever heard that There is a famous club around here.");}
                        if(tvCount6==34){ Answer3(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount6==40){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount6==41){ cputv6.setText("Friend : Are you interested?");}
                        if(tvCount6==42){ Answer4(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount6==48){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount6==49){ cputv7.setText("Friend : Really? but you know? i don't have enough money sorry dude.");}



//                        if(tvCount<5){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
//                        if(tvCount==5){ cputv1.setText("Kenneth : Oh! Nice to meet you");}
//                        //말 한 이후로 클릭 가능하게 하기.
//                        if(tvCount==6){btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
//                        if(tvCount==14){ cputv2.setText("Kenneth : Where are you from?");}
//                        if(tvCount==15){ Answer1();}
//                        if(tvCount==24){ cputv3.setText("Kenneth : You are from korea!");}
//                        if(tvCount==25){ Answer2();}
//                        if(tvCount==34){ cputv4.setText("Kenneth : Welcome to School");}
//                        if(tvCount==35){ Answer3();}
//                        if(tvCount==44){ cputv5.setText("Kenneth : Now it is time to leave");}
//                        if(tvCount==45){ }
//                        if(tvCount==54){ cputv6.setText("Kenneth : See you then");}
//                        if(tvCount==55){ }
//                        if(tvCount==60){ cputv7.setText("Kenneth : bye!");}
                    }
                });
            }
        };


        ////////////////////////////////////////////////////////
        timer.schedule(task,0,3000);
    }




    public void StartAnswer(){


        //버튼을 누르면 상태가 바뀌는 영역/////////////////////////////////////////////////////////////

        btn[A].setText(R.string.street1);
        btn[B].setText(R.string.street2);
        btn[C].setText(R.string.street3);
        btn[D].setText(R.string.street4);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[C] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv2.setText("Me: Where are you looking at?. ");
                }if(btn[0]==btn[B]){
                    usertv2.setText("Me: What are you looking at?.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[C] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv2.setText("Me: Where are you looking at?. ");
                }if(btn[1]==btn[B]){
                    usertv2.setText("Me: What are you looking at?. ");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[C] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv2.setText("Me: Where are you looking at?.");
                }if(btn[2]==btn[B]){
                    usertv2.setText("Me: What are you looking at?. ");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[C] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv2.setText("Me: Where are you looking at?. ");
                }if(btn[3]==btn[B]){
                    usertv2.setText("Me: What are you looking at?. ");
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////


    }//startconverstation

    //0,1 fail
    public void Answer1() {




        btn[A].setText(R.string.street5);
        btn[B].setText(R.string.street6);
        btn[C].setText(R.string.street7);
        btn[D].setText(R.string.street8);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[B]){
                    usertv3.setText("Me: what does she look like?.");
                }if(btn[0]==btn[C]){
                    usertv3.setText("Me: does she look like?. ");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[B]){
                    usertv3.setText("Me: what does she look like?. ");
                }if(btn[1]==btn[C]){
                    usertv3.setText("Me: does she look like?. ");
                }

            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[B]){
                    usertv3.setText("Me: what does she look like?. ");
                }if(btn[2]==btn[C]){
                    usertv3.setText("Me: does she look like?. ");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[B]){
                    usertv3.setText("Me: what does she look like?. ");
                }if(btn[3]==btn[C]){
                    usertv3.setText("Me: does she look like?.");
                }

            }
        });
    }

//2,3 fail

    public void Answer2(){



        btn[A].setText(R.string.street9);
        btn[B].setText(R.string.street10);
        btn[C].setText(R.string.street11);
        btn[D].setText(R.string.street12);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[B]){
                    usertv4.setText("Me: I don't mind, let's just look around. ");
                }if(btn[0]==btn[C]){
                    usertv4.setText("Me: How does she look like?.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[B]){
                    usertv4.setText("Me: I don't mind, let's just look around.");
                }if(btn[1]==btn[C]){
                    usertv4.setText("Me: How does she look like?. ");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[B]){
                    usertv4.setText("Me: I don't mind, let's just look around.");
                }if(btn[2]==btn[C]){
                    usertv4.setText("Me: How does she look like?. ");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[B]){
                    usertv4.setText("Me: I don't mind, let's just look around.");
                }if(btn[3]==btn[C]){
                    usertv4.setText("Me: How does she look like?. ");
                }
            }
        });

    }

    //2,3
    public void Answer3(){


        btn[A].setText(R.string.street13);
        btn[B].setText(R.string.street14);
        btn[C].setText(R.string.street15);
        btn[D].setText(R.string.street16);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[B]){
                    usertv5.setText("Me: Really why don't you tell me about it?.");
                }if(btn[0]==btn[C]){
                    usertv5.setText("Me: Why not?.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[B]){
                    usertv5.setText("Me: Really why don't you tell me about it?.");
                }if(btn[1]==btn[C]){
                    usertv5.setText("Me: Why not?. ");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[B]){
                    usertv5.setText("Me: Really why don't you tell me about it?. ");
                }if(btn[2]==btn[C]){
                    usertv5.setText("Me: Why not?. ");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[B]){
                    usertv5.setText("Me: Really why don't you tell me about it?. ");
                }if(btn[3]==btn[C]){
                    usertv5.setText("Me: Why not?. ");
                }
            }
        });

    }

    public void Answer4(){


        btn[A].setText(R.string.street17);
        btn[B].setText(R.string.street18);
        btn[C].setText(R.string.street19);
        btn[D].setText(R.string.street20);

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.

                if(btn[0]==btn[B]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv6.setText("Me: Yes! of course. ");
                }if(btn[0]==btn[C] ){
                    usertv6.setText("Me: Let's visit there before we leave. ");
                }if(btn[0]==btn[D]){
                    usertv6.setText("Me: No, I'm ");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[B]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv6.setText("Me: Yes! of course. ");
                }if(btn[1]==btn[C] ){
                    usertv6.setText("Me: Let's visit there before we leave. ");
                }if(btn[1]==btn[D]){
                    usertv6.setText("Me: No, I'm ");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[B]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv6.setText("Me: Yes! of course. ");
                }if(btn[2]==btn[C] ){
                    usertv6.setText("Me: Let's visit there before we leave. ");
                }if(btn[2]==btn[D]){
                    usertv6.setText("Me: No, I'm ");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[B]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv6.setText("Me: Yes! of course. ");
                }if(btn[3]==btn[C] ){
                    usertv6.setText("Me: Let's visit there before we leave. ");
                }if(btn[3]==btn[D]){
                    usertv6.setText("Me: No, I'm ");
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        task.cancel();
        timer.cancel();
        timer.purge();
        timer=null;
        task=null;
        life=330;
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvCount6=0;
    }



}
