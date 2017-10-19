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

import static com.kenneth1993.education.Application_AtStore_For_Draw.life;
import static com.kenneth1993.education.Grammar.actlist;

public class Application_ListView_AtStore extends AppCompatActivity {

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
    static int tvCount5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atstore);

        actlist.add(this);
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
                tvCount5++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(life==30){
                            Toast.makeText(Application_ListView_AtStore.this, "fail", Toast.LENGTH_SHORT).show();

                            //패배했습니다 다이얼로그 띄우기
                            final AlertDialog.Builder builder=new AlertDialog.Builder(Application_ListView_AtStore.this);
                            builder.setTitle("복습을 더 하셔야겠어요!");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {



                                    Intent intent=new Intent(Application_ListView_AtStore.this,Application.class);
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            AlertDialog dialog= builder.create();
                            dialog.show();
                        }

                        //max 50초 5초 대화시작, [버튼 누를 기회 10초] 14초 cpu 대화 15초 버튼 바꾸기 25초 버튼 바꾸기.
                        if(tvCount5==65){ task.cancel();}
                        Toast.makeText(Application_ListView_AtStore.this, "곧 시작됩니다.", Toast.LENGTH_SHORT).show();
                        //kenneth가 말을 시작하기 전에 클릭 불가능
                        if(tvCount5<3){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount5==3){ cputv1.setText(" ");}
                        //말 한 이후로 클릭 가능하게 하기.
                        if(tvCount5==5){ cputv2.setText("Clerk : Hello, How are you? Do you need something?");}
                        if(tvCount5==6){ StartAnswer(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount5==8){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount5==9){ cputv3.setText("Clerk : How much do you want to top up for it?");}
                        if(tvCount5==10){ Answer1(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount5==12){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount5==13){ cputv4.setText("Clerk : I've got $30, here is for extra");}
                        if(tvCount5==14){ Answer2(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount5==15){ cputv5.setText("Clerk : ");}
//                        if(tvCount==15){ Answer3();}
                        if(tvCount5==16){ cputv6.setText("Clerk : ");}
//                        if(tvCount==17){ Answer5(); }
                        if(tvCount5==18){ cputv7.setText("Clerk :");}
//
                    }
                });
            }
        };



    timer.schedule(task,0,3000);
    }






    public void StartAnswer(){


        //버튼을 누르면 상태가 바뀌는 영역/////////////////////////////////////////////////////////////

        btn[A].setText(R.string.store1);
        btn[B].setText(R.string.store2);
        btn[C].setText(R.string.store3);
        btn[D].setText(R.string.store4);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[D] || btn[0]==btn[C]){
                    fail=true;
                }else if(btn[0]==btn[B]){
                    usertv2.setText("Me: Top up it please. ");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[D] || btn[0]==btn[C]){
                    fail=true;
                }else if(btn[1]==btn[B]){
                    usertv2.setText("Me: Top up it please. ");
                }if(btn[1]==btn[C]){
                    usertv2.setText("Me: Can you give me some money?. ");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[D]|| btn[0]==btn[C]){
                    fail=true;
                }else if(btn[2]==btn[B]){
                    usertv2.setText("Me: Top up it please. ");
                }if(btn[2]==btn[C]){
                    usertv2.setText("Me: Can you give me some money?. ");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[D]|| btn[0]==btn[C]){
                    fail=true;
                }else if(btn[3]==btn[B]){
                    usertv2.setText("Me: Top up it please. ");
                }if(btn[3]==btn[C]){
                    usertv2.setText("Me: Can you give me some money?. ");
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////


    }//startconverstation

    //0,1 fail
    public void Answer1() {



        btn[A].setText(R.string.store5);
        btn[B].setText(R.string.store6);
        btn[C].setText(R.string.store7);
        btn[D].setText(R.string.store8);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if (btn[0] == btn[D]) {
                    fail = true;
                } else if (btn[0] == btn[A]) {
                    usertv3.setText("Me : Please top up it for $20?.");
                } if(btn[0] == btn[B]){
                    usertv3.setText("Me : for $20 please.");
                }if(btn[0] == btn[C]){
                    usertv3.setText("Me : Please charge it for $20.");
                }


            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[1] == btn[D]) {
                    fail = true;
                } else if (btn[1] == btn[A]) {
                    usertv3.setText("Me : Please top up it for $20?.");
                } if(btn[1] == btn[B]){
                    usertv3.setText("Me : for $20 please.");
                }if(btn[1] == btn[C]){
                    usertv3.setText("Me : Please charge it for $20.");
                }

            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[2] == btn[D]) {
                    fail = true;
                } else if (btn[2] == btn[A]) {
                    usertv3.setText("Me : Please top up it for $20?.");
                } if(btn[2] == btn[B]){
                    usertv3.setText("Me : for $20 please.");
                }if(btn[2] == btn[C]){
                    usertv3.setText("Me : Please charge it for $20.");
                }

            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[3] == btn[D]) {
                    fail = true;
                } else if (btn[3] == btn[A]) {
                    usertv3.setText("Me : Please top up it for $20?.");
                } if(btn[3] == btn[B]){
                    usertv3.setText("Me : for $20 please.");
                }if(btn[3] == btn[C]){
                    usertv3.setText("Me : Please charge it for $20.");
                }

            }
        });
    }

//2,3 fail

    public void Answer2(){



        btn[A].setText(R.string.store9);
        btn[B].setText(R.string.store10);
        btn[C].setText(R.string.store11);
        btn[D].setText(R.string.store12);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[C]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv4.setText("Me : Thanks, now is it possible to use it?.");
                }if(btn[0]==btn[B]){
                    usertv4.setText("Me : Can you check my current balance?.");
                }if(btn[0]==btn[D]){
                    usertv4.setText("Me : Quit.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[C]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv4.setText("Me : Thanks, now is it possible to use it?.");
                }if(btn[1]==btn[B]){
                    usertv4.setText("Me : Can you check my current balance?.");
                }if(btn[1]==btn[D]){
                    usertv4.setText("Me : Quit.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[C]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv4.setText("Me : Thanks, now is it possible to use it?.");
                }if(btn[2]==btn[B]){
                    usertv4.setText("Me : Can you check my current balance?.");
                }if(btn[2]==btn[D]){
                    usertv4.setText("Me : Quit.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[C]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv4.setText("Me : Thanks, now is it possible to use it?.");
                }if(btn[3]==btn[B]){
                    usertv4.setText("Me : Can you check my current balance?.");
                }if(btn[3]==btn[D]){
                    usertv4.setText("Me : Quit.");
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
        tvCount5=0;
    }


}
