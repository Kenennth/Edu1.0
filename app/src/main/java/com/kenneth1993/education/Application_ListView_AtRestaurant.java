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

import static com.kenneth1993.education.Application_AtRestaurant_For_Draw.life;
import static com.kenneth1993.education.Grammar.actlist;

public class Application_ListView_AtRestaurant extends AppCompatActivity {

    Button[] btn= new Button[4];
    Random random=new Random();
    int A,B,C,D;
    public static boolean fail = false;
    TextView usertv1;TextView usertv4;TextView usertv7;
    TextView usertv2;TextView usertv5;TextView usertv8;
    TextView usertv3;TextView usertv6;TextView usertv9;

//    TextView [] userTv=new TextView[7];

    TextView cputv1;TextView cputv4;TextView cputv7;
    TextView cputv2;TextView cputv5;TextView cputv8;
    TextView cputv3;TextView cputv6;TextView cputv9;

//    TextView[] cpuTv=new TextView[7];


    Timer timer;
    TimerTask task;
    static int tvCount7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrestaurant);

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
        usertv8=(TextView)findViewById(R.id.user_07);
        usertv9=(TextView)findViewById(R.id.user_08);

        cputv1=(TextView)findViewById(R.id.cpu_00);
        cputv2=(TextView)findViewById(R.id.cpu_01);
        cputv3=(TextView)findViewById(R.id.cpu_02);
        cputv4=(TextView)findViewById(R.id.cpu_03);
        cputv5=(TextView)findViewById(R.id.cpu_04);
        cputv6=(TextView)findViewById(R.id.cpu_05);
        cputv7=(TextView)findViewById(R.id.cpu_06);
        cputv8=(TextView)findViewById(R.id.cpu_07);
        cputv9=(TextView)findViewById(R.id.cpu_08);




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
                tvCount7++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(life==30){
                            Toast.makeText(Application_ListView_AtRestaurant.this, "fail", Toast.LENGTH_SHORT).show();

                            //패배했습니다 다이얼로그 띄우기
                            final AlertDialog.Builder builder=new AlertDialog.Builder(Application_ListView_AtRestaurant.this);
                            builder.setTitle("복습을 더 하셔야겠어요!");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intent=new Intent(Application_ListView_AtRestaurant.this,Application.class);
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            AlertDialog dialog= builder.create();
                            dialog.show();
                        }

                        //max 50초 5초 대화시작, [버튼 누를 기회 10초] 14초 cpu 대화 15초 버튼 바꾸기 25초 버튼 바꾸기.
                        if(tvCount7==65){ task.cancel();}
                        Toast.makeText(Application_ListView_AtRestaurant.this, "곧 시작됩니다.", Toast.LENGTH_SHORT).show();
                        //kenneth가 말을 시작하기 전에 클릭 불가능
                        if(tvCount7<3){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount7==3){ cputv1.setText("Kenneth : Hello are you dining alone?");}
                        if(tvCount7==4){ StartAnswer();}
                        if(tvCount7==5){btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount7==7){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount7==8){ cputv2.setText("Kenneth : Smoking or non smoking?");}
                        if(tvCount7==9){ Answer1(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount7==11){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount7==12){ cputv3.setText("Kenneth : I have a table for you please follow me.");}
                        if(tvCount7==13){ Answer2(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount7==15){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount7==16){ cputv4.setText("Kenneth : A waitress will be a few shortly to take your order.");}
                        if(tvCount7==17){ Answer3(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount7==20){ cputv5.setText("After Having meal......And you have decided to go back to home..");}
                        if(tvCount7==21){ Answer4(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true); }
                        if(tvCount7==23){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount7==24){ cputv6.setText("Kenneth : Would you like some dessert?");}
                        if(tvCount7==25){ Answer5(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true); }
                        if(tvCount7==28){ cputv7.setText("Kenneth : Can i get you anything else?");}
                        if(tvCount7==29){ cputv8.setText("Kenneth : You had [foods],[drink],[others] that will be $50");}
                        if(tvCount7==30){ usertv8.setText("Me: Is that included what?");}
                        if(tvCount7==31){ cputv8.setText("Kenneth : That included 10% service charge and tax thank you");}
                        if(tvCount7==32){ usertv9.setText("Me: Bye I'll visit later");}


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

        btn[A].setText(R.string.restaurant1);
        btn[B].setText(R.string.restaurant2);
        btn[C].setText(R.string.restaurant3);
        btn[D].setText(R.string.restaurant4);

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[C]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv1.setText("Me: Yes, Table for one please. ");
                }if(btn[0]==btn[B]){
                    usertv1.setText("Me: I'm not a dining.");
                }if(btn[0]==btn[D]){
                    usertv1.setText("Me: No, I'm not we are all three");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[C]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv1.setText("Me: Yes, Table for one please. ");
                }if(btn[1]==btn[B]){
                    usertv1.setText("Me: I'm not a dining.");
                }if(btn[1]==btn[D]){
                    usertv1.setText("Me: No, I'm not we are all three");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[C]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv1.setText("Me: Yes, Table for one please. ");
                }if(btn[2]==btn[B]){
                    usertv1.setText("Me: I'm not a dining.");
                }if(btn[2]==btn[D]){
                    usertv1.setText("Me: No, I'm not we are all three");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[C]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv1.setText("Me: Yes, Table for one please. ");
                }if(btn[3]==btn[B]){
                    usertv1.setText("Me: I'm not a dining.");
                }if(btn[3]==btn[D]){
                    usertv1.setText("Me: No, I'm not we are all three");
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////


    }//startconverstation

    //0,1 fail
    public void Answer1() {


        btn[A].setText(R.string.restaurant5);
        btn[B].setText(R.string.restaurant6);
        btn[C].setText(R.string.restaurant7);
        btn[D].setText(R.string.restaurant8);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if (btn[0] == btn[D]) {
                    fail = true;
                } else if (btn[0] == btn[A]) {
                    usertv2.setText("Me : Can i see the menu please?.");
                } if(btn[0] == btn[B]){
                    usertv2.setText("Me : No thanks I'm just looking around.");
                }if(btn[0] == btn[C]){
                    usertv2.setText("Me : Can you give me a menu?");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[0] == btn[D]) {
                    fail = true;
                } else if (btn[0] == btn[A]) {
                    usertv2.setText("Me : Can i see the menu please?.");
                } if(btn[0] == btn[B]){
                    usertv2.setText("Me : No thanks I'm just looking around.");
                }if(btn[0] == btn[C]){
                    usertv2.setText("Me : Can you give me a menu?");
                }

            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[0] == btn[D]) {
                    fail = true;
                } else if (btn[0] == btn[A]) {
                    usertv2.setText("Me : Can i see the menu please?.");
                } if(btn[0] == btn[B]){
                    usertv2.setText("Me : No thanks I'm just looking around.");
                }if(btn[0] == btn[C]){
                    usertv2.setText("Me : Can you give me a menu?");
                }

            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[0] == btn[D]) {
                    fail = true;
                } else if (btn[0] == btn[A]) {
                    usertv2.setText("Me : Can i see the menu please?.");
                } if(btn[0] == btn[B]){
                    usertv2.setText("Me : No thanks I'm just looking around.");
                }if(btn[0] == btn[C]){
                    usertv2.setText("Me : Can you give me a menu?");
                }

            }
        });
    }

//2,3 fail

    public void Answer2(){


        btn[A].setText(R.string.restaurant9);
        btn[B].setText(R.string.restaurant10);
        btn[C].setText(R.string.restaurant11);
        btn[D].setText(R.string.restaurant12);

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[B]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv3.setText("Me : I'll have chicken please.");
                }if(btn[0]==btn[C]){
                    usertv3.setText("Me : I'll take a pizza please.");
                }if(btn[0]==btn[D]){
                    usertv3.setText("Me : I'll take juice please.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[B]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv3.setText("Me : I'll have chicken please.");
                }if(btn[1]==btn[C]){
                    usertv3.setText("Me : I'll take a pizza please.");
                }if(btn[1]==btn[D]){
                    usertv3.setText("Me : I'll take juice please.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[B]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv3.setText("Me : I'll have chicken please.");
                }if(btn[2]==btn[C]){
                    usertv3.setText("Me : I'll take a pizza please.");
                }if(btn[2]==btn[D]){
                    usertv3.setText("Me : I'll take juice please.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[B]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv3.setText("Me : I'll have chicken please.");
                }if(btn[3]==btn[C]){
                    usertv3.setText("Me : I'll take a pizza please.");
                }if(btn[3]==btn[D]){
                    usertv3.setText("Me : I'll take juice please.");
                }
            }
        });

    }

    //2,3
    public void Answer3(){


        btn[A].setText(R.string.restaurant13);
        btn[B].setText(R.string.restaurant14);
        btn[C].setText(R.string.restaurant15);
        btn[D].setText(R.string.restaurant16);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[C]||btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv4.setText("Me : Yes I'd like a cup of cafe latte please.");
                }if(btn[0]==btn[B]){
                    usertv4.setText("Me : No thanks");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[C]||btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv4.setText("Me : Yes I'd like a cup of cafe latte please.");
                }if(btn[1]==btn[B]){
                    usertv4.setText("Me : No thanks");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[C]||btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv4.setText("Me : Yes I'd like a cup of cafe latte please.");
                }if(btn[2]==btn[B]){
                    usertv4.setText("Me : No thanks");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[C]||btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv4.setText("Me : Yes I'd like a cup of cafe latte please.");
                }if(btn[3]==btn[B]){
                    usertv4.setText("Me : No thanks");
                }
            }
        });

    }

    public void Answer4(){


        btn[A].setText(R.string.restaurant17);
        btn[B].setText(R.string.restaurant18);
        btn[C].setText(R.string.restaurant19);
        btn[D].setText(R.string.restaurant20);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.

                if(btn[0]==btn[C]){
                    fail=true;
                }if(btn[0]==btn[A]){
                    usertv5.setText("Me : Could i have the bill please?.");
                }if(btn[0]==btn[B]){
                    usertv5.setText("Me : Can i have the bill please?.");
                }if(btn[0]==btn[D]){
                    usertv5.setText("Me : Can i get the bill please?.");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[C]){
                    fail=true;
                }if(btn[1]==btn[A]){
                    usertv5.setText("Me : Could i have the bill please?.");
                }if(btn[1]==btn[B]){
                    usertv5.setText("Me : Can i have the bill please?.");
                }if(btn[1]==btn[D]){
                    usertv5.setText("Me : Can i get the bill please?.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[C]){
                    fail=true;
                }if(btn[2]==btn[A]){
                    usertv5.setText("Me : Could i have the bill please?.");
                }if(btn[2]==btn[B]){
                    usertv5.setText("Me : Can i have the bill please?.");
                }if(btn[2]==btn[D]){
                    usertv5.setText("Me : Can i get the bill please?.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[C]){
                    fail=true;
                }if(btn[3]==btn[A]){
                    usertv5.setText("Me : Could i have the bill please?.");
                }if(btn[3]==btn[B]){
                    usertv5.setText("Me : Can i have the bill please?.");
                }if(btn[3]==btn[D]){
                    usertv5.setText("Me : Can i get the bill please?.");
                }
            }
        });

    }

    public void Answer5(){


        btn[A].setText(R.string.restaurant21);
        btn[B].setText(R.string.restaurant22);
        btn[C].setText(R.string.restaurant23);
        btn[D].setText(R.string.restaurant24);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[C]|| btn[0]==btn[D]){
                    fail=true;
                }if(btn[0]==btn[A]){
                    usertv6.setText("Me : I'd rather pay now please.");
                }if(btn[0]==btn[B]){
                    usertv6.setText("Me : I'd rather charge it to my room.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[C]|| btn[1]==btn[D]){
                    fail=true;
                }if(btn[1]==btn[A]){
                    usertv6.setText("Me : I'd rather pay now please.");
                }if(btn[1]==btn[B]){
                    usertv6.setText("Me : I'd rather charge it to my room.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[C]|| btn[2]==btn[D]){
                    fail=true;
                }if(btn[2]==btn[A]){
                    usertv6.setText("Me : I'd rather pay now please.");
                }if(btn[2]==btn[B]){
                    usertv6.setText("Me : I'd rather charge it to my room.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[C]|| btn[3]==btn[D]){
                    fail=true;
                }if(btn[3]==btn[A]){
                    usertv6.setText("Me : I'd rather pay now please.");
                }if(btn[3]==btn[B]){
                    usertv6.setText("Me : I'd rather charge it to my room.");
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
        tvCount7=0;
    }


}
