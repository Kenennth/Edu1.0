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

import static com.kenneth1993.education.Application_Atschool_For_Draw3.life;
import static com.kenneth1993.education.Grammar.actlist;

public class Application_ListView_Atschool3 extends AppCompatActivity {

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
    static int tvCount3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atschool3);

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
                tvCount3++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(life==30){
                            Toast.makeText(Application_ListView_Atschool3.this, "fail", Toast.LENGTH_SHORT).show();

                            //패배했습니다 다이얼로그 띄우기
                            final AlertDialog.Builder builder=new AlertDialog.Builder(Application_ListView_Atschool3.this);
                            builder.setTitle("복습을 더 하셔야겠어요!");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intent=new Intent(Application_ListView_Atschool3.this,Application.class);
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            AlertDialog dialog= builder.create();
                            dialog.show();
                        }


                        //max 50초 5초 대화시작, [버튼 누를 기회 10초] 14초 cpu 대화 15초 버튼 바꾸기 25초 버튼 바꾸기.
                        if(tvCount3==65){ task.cancel();}
                        Toast.makeText(Application_ListView_Atschool3.this, "곧 시작됩니다.", Toast.LENGTH_SHORT).show();
                        //kenneth가 말을 시작하기 전에 클릭 불가능
                        if(tvCount3<3){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount3==3){ cputv1.setText("Kenneth : 이어서 현재분사의 쓰임에 대해 맞추는 문제입니다.");}
                        //말 한 이후로 클릭 가능하게 하기.

                        if(tvCount3==5){ cputv2.setText("Kenneth : 현재진행형이 쓰인 것은 무슨문장일까요?");}
                        if(tvCount3==6){StartAnswer(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount3==11){ btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount3==12){ cputv3.setText("Kenneth : 현재완료형이 쓰인 것은 무슨 문장일까요?");}
                        if(tvCount3==13){ Answer1(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount3==18){ btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount3==19){ cputv4.setText("Kenneth : 현재완료형이 의미가 다르게 쓰인 것은 무엇일까요?");}
                        if(tvCount3==20){ Answer2(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount3==25){ btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount3==26){ cputv5.setText("Kenneth : 현재진행형이 다르게 쓰인 문장은 어느 것일까요?");}
                        if(tvCount3==27){ Answer3(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount3==32){ cputv6.setText("Kenneth : 잘하셨습니다 수고하셨습니다.");}
                        if(tvCount3==34){Intent intent=new Intent(Application_ListView_Atschool3.this ,Application_ListView_Atschool4.class);
                            startActivity(intent);
                            finish();}
//TODO 여기 문제 더 내기

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
        timer.schedule(task,0,3000);
        ////////////////////////////////////////////////////////
    }















    public void StartAnswer(){


        //버튼을 누르면 상태가 바뀌는 영역/////////////////////////////////////////////////////////////

        btn[A].setText(R.string.sentences69);
        btn[B].setText(R.string.sentences70);
        btn[C].setText(R.string.sentences71);
        btn[D].setText(R.string.sentences72);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[B] || btn[0]==btn[C] ||btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv2.setText("Me: After i feed dogs, They are sleeping.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[B] || btn[1]==btn[C] ||btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv2.setText("Me: After i feed dogs, They are sleeping.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[B] || btn[2]==btn[C] ||btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv2.setText("Me: After i feed dogs, They are sleeping.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[B] || btn[3]==btn[C] ||btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv2.setText("Me: After i feed dogs, They are sleeping.");
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////


    }//startconverstation

    //0,1 fail
    public void Answer1() {




        btn[A].setText(R.string.sentences73);
        btn[B].setText(R.string.sentences74);
        btn[C].setText(R.string.sentences75);
        btn[D].setText(R.string.sentences76);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[B] ||btn[0]==btn[C]){
                    fail=true;
                }else if(btn[0]==btn[D]){
                    usertv3.setText("Me: I have just finished cleaning the room. ");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[B] ||btn[1]==btn[C]){
                    fail=true;
                }else if(btn[1]==btn[D]){
                    usertv3.setText("Me: I have just finished cleaning the room. ");
                }

            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[B] ||btn[2]==btn[C]){
                    fail=true;
                }else if(btn[2]==btn[D]){
                    usertv3.setText("Me: I have just finished cleaning the room. ");
                }

            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[B] ||btn[3]==btn[C]){
                    fail=true;
                }else if(btn[3]==btn[D]){
                    usertv3.setText("Me: I have just finished cleaning the room. ");
                }

            }
        });
    }

//2,3 fail

    public void Answer2(){



        btn[A].setText(R.string.sentences77);
        btn[B].setText(R.string.sentences78);
        btn[C].setText(R.string.sentences79);
        btn[D].setText(R.string.sentences80);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A]||btn[0]==btn[C]||btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[B]){
                    usertv4.setText("Me : I have ever been to Japan.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A]||btn[1]==btn[C]||btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[B]){
                    usertv4.setText("Me : I have ever been to Japan.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A]||btn[2]==btn[C]||btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[B]){
                    usertv4.setText("Me : I have ever been to Japan.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A]||btn[3]==btn[C]||btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[B]){
                    usertv4.setText("Me : I have ever been to Japan.");
                }
            }
        });

    }

    //2,3
    public void Answer3(){


        btn[A].setText(R.string.sentences81);
        btn[B].setText(R.string.sentences82);
        btn[C].setText(R.string.sentences83);
        btn[D].setText(R.string.sentences84);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A]||btn[0]==btn[C]||btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[B]){
                    usertv5.setText("Me : He is always laughing.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[B]||btn[1]==btn[C]||btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv5.setText("Me : He is always laughing.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[B]||btn[2]==btn[C]||btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv5.setText("Me : He is always laughing.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[B]||btn[3]==btn[C]||btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv5.setText("Me : He is always laughing.");
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
        tvCount3=0;
    }


}
