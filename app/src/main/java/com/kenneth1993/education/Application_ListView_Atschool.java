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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static com.kenneth1993.education.Application_Atschool_For_Draw.life;
import static com.kenneth1993.education.Grammar.actlist;


public class Application_ListView_Atschool extends AppCompatActivity {


    Button [] btn= new Button[4];
    public static boolean fail = false;
    Random random=new Random();
    int A,B,C,D;
    int okay=0;


    TextView usertv1;TextView usertv4; TextView usertv7;
    TextView usertv2;TextView usertv5;
    TextView usertv3;TextView usertv6;

//    TextView [] userTv=new TextView[7];

    TextView cputv1;TextView cputv4; TextView cputv7;
    TextView cputv2;TextView cputv5; TextView cputv8;
    TextView cputv3;TextView cputv6;

//    TextView[] cpuTv=new TextView[7];


    Timer timer;
    TimerTask task;
    static int tvCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atschool);

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
        cputv8=(TextView)findViewById(R.id.cpu_07);



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


        //타이머를 이용해서 화면에
        timer=new Timer();
            task = new TimerTask() {
            @Override
            public void run() {
                tvCount++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(life==30){
                            Toast.makeText(Application_ListView_Atschool.this, "fail", Toast.LENGTH_SHORT).show();

                            //패배했습니다 다이얼로그 띄우기
                            final AlertDialog.Builder builder=new AlertDialog.Builder(Application_ListView_Atschool.this);
                            builder.setTitle("복습을 더 하셔야겠어요!");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {



                                    Intent intent=new Intent(Application_ListView_Atschool.this,Application.class);
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            AlertDialog dialog= builder.create();
                            dialog.show();
                        }


                        //max 50초 5초 대화시작, [버튼 누를 기회 10초] 14초 cpu 대화 15초 버튼 바꾸기 25초 버튼 바꾸기.
                        if(tvCount==65){ task.cancel();}
//                        Toast.makeText(Application_ListView_Atschool.this, tvCount+"", Toast.LENGTH_SHORT).show();
                        //kenneth가 말을 시작하기 전에 클릭 불가능
                        if(tvCount<3){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount==3){ cputv1.setText("Kenneth : 'Hi nice to meet you'라는 문장에서 맞는 어순은 무엇일까요?");}
                        //말 한 이후로 클릭 가능하게 하기.
                        if(tvCount==4){btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        //tvcount==7
                        if(tvCount==8){ btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}

                        if(tvCount==9){cputv2.setText("Kenneth : 'What does she do에 맞는 어순은 무엇일까요?'");}
                        if(tvCount==10){
                            Answer1();
                            btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);
                        }
                        if(tvCount==14){ btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount==15){
                            cputv3.setText("Kenneth : 'she went school to find out her glasses'에 맞는 어순 구조는 무엇일까요?");}

                        if(tvCount==16){
                            Answer2();
                            btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}

                        if(tvCount==20){ btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount==21){
                            cputv4.setText("Kenneth : 'she left for Australia to work with natives for a year ago'에 맞는 어순 구조는 무엇일까요?");}

                        if(tvCount==22){
                            Answer3();
                            btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}

                        if(tvCount==26){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount==27){
                            cputv5.setText("Kenneth : 'She has me to do something strange.'에 맞는 어순 구조는 무엇일까요?");}

                        if(tvCount==28){
                            Answer4();
                            btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);
                        }
                        if(tvCount==32){ btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount==33){
                            cputv6.setText("Kenneth : 수고하셨습니다. 문장의 구조를 이해하는 것이 초보자에게는 가장 중요합니다.");}

                        if(tvCount==34){ usertv6.setText("수고하셨습니다~"); }
                        if(tvCount==35){ cputv7.setText("Kenneth : 다음 부분으로 넘어갑니다.");}
                        if(tvCount==36){Intent intent=new Intent(Application_ListView_Atschool.this ,Application_ListView_Atschool1.class);
                            startActivity(intent);
                            finish();

                        }

                    }
                });
            }
        };
        timer.schedule(task,0,3000);
}//oncreate










public void StartAnswer(){


    //버튼을 누르면 상태가 바뀌는 영역/////////////////////////////////////////////////////////////

        btn[A].setText(R.string.sentences1);
        btn[B].setText(R.string.sentences2);
        btn[C].setText(R.string.sentences3);
        btn[D].setText(R.string.sentences4);


    btn[0].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
            //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
            if(btn[0]==btn[B]|| btn[0]==btn[C]||btn[0]==btn[D]){
                fail=true;
            }else if(btn[0]==btn[A]){
                usertv1.setText("Me: 부사+주어+동사+명사입니다!");
            }
        }
    });

    btn[1].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(btn[1]==btn[B]|| btn[1]==btn[C]||btn[1]==btn[D]){
                fail=true;
            }else if(btn[1]==btn[A]){
                usertv1.setText("Me: 부사+주어+동사+명사입니다!");
            }
        }
    });

    btn[2].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(btn[2]==btn[B]|| btn[2]==btn[C]||btn[2]==btn[D]){
                fail=true;
            }else if(btn[2]==btn[A]){
                usertv1.setText("Me: 부사+주어+동사+명사입니다!");
            }
        }
    });

    btn[3].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(btn[3]==btn[B]|| btn[3]==btn[C]||btn[3]==btn[D]){
                fail=true;
            }else if(btn[3]==btn[A]){
                usertv1.setText("Me: 부사+주어+동사+명사입니다!");
            }
        }
    });

    ///////////////////////////////////////////////////////////////////////////////////////////


}//startconverstation

//0,1 fail
public void Answer1() {

    btn[A].setText(R.string.sentences5);
    btn[B].setText(R.string.sentences6);
    btn[C].setText(R.string.sentences7);
    btn[D].setText(R.string.sentences8);

    btn[0].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
            //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
            if (btn[0] == btn[A] || btn[0] == btn[B] || btn[0] == btn[D]) {
                fail = true;
            } else if (btn[0] == btn[C]) {
                usertv2.setText("Me : 의문사+조동사+주어+동사입니다!");
            }

        }
    });

    btn[1].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btn[1] == btn[A] || btn[1] == btn[B] || btn[1] == btn[D]) {
                fail = true;
            } else if (btn[1] == btn[C]) {
                usertv2.setText("Me : 의문사+조동사+주어+동사입니다!");
            }
        }
    });

    btn[2].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btn[2] == btn[A] || btn[2] == btn[B] || btn[2] == btn[D]) {
                fail = true;
            } else if (btn[2] == btn[C]) {
                usertv2.setText("Me : 의문사+조동사+주어+동사입니다!");
            }
        }
    });

    btn[3].setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (btn[3] == btn[A] || btn[3] == btn[B] || btn[3] == btn[D]) {
                fail = true;
            } else if (btn[3] == btn[C]) {
                usertv2.setText("Me : 의문사+조동사+주어+동사입니다!");
            }
        }
    });
}

//2,3 fail

public void Answer2(){



        btn[A].setText(R.string.sentences9);
        btn[B].setText(R.string.sentences10);
        btn[C].setText(R.string.sentences11);
        btn[D].setText(R.string.sentences12);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A]|| btn[0]==btn[C]||btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[B]){
                    usertv3.setText("Me : 주어+동사+보어 입니다!");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A]|| btn[1]==btn[C]||btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[B]){
                    usertv3.setText("Me : 주어+동사+보어 입니다!");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A]|| btn[2]==btn[C]||btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[B]){
                    usertv3.setText("Me : 주어+동사+보어 입니다!");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A]|| btn[3]==btn[C]||btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[B]){
                    usertv3.setText("Me : 주어+동사+보어 입니다!");
                }
            }
        });

    }

//2,3
public void Answer3(){


        btn[A].setText(R.string.sentences13);
        btn[B].setText(R.string.sentences14);
        btn[C].setText(R.string.sentences15);
        btn[D].setText(R.string.sentences16);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[B]|| btn[0]==btn[C] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv4.setText("Me : 주어+동사+보어(부사)입니다!");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[B]|| btn[1]==btn[C] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv4.setText("Me : 주어+동사+보어(부사)입니다!");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[B]|| btn[2]==btn[C] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv4.setText("Me : 주어+동사+보어(부사)입니다!");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[B]|| btn[3]==btn[C] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv4.setText("Me : 주어+동사+보어(부사)입니다!");
                }
            }
        });

    }

public void Answer4(){


        btn[A].setText(R.string.sentences17);
        btn[B].setText(R.string.sentences18);
        btn[C].setText(R.string.sentences19);
        btn[D].setText(R.string.sentences20);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.

                if(btn[0]==btn[A]|| btn[0]==btn[C] || btn[0]==btn[D]){
                    fail=true;
                }if(btn[0]==btn[B]){
                    usertv5.setText("Me : 주어+동사+목적어+목적격보어입니다!");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A]|| btn[1]==btn[C] || btn[1]==btn[D]){
                    fail=true;
                }if(btn[1]==btn[B]){
                    usertv5.setText("Me : 주어+동사+목적어+목적격보어입니다!");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A]|| btn[2]==btn[C] || btn[2]==btn[D]){
                    fail=true;
                }if(btn[2]==btn[B]){
                    usertv5.setText("Me : 주어+동사+목적어+목적격보어입니다!");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A]|| btn[3]==btn[C] || btn[3]==btn[D]){
                    fail=true;
                }if(btn[3]==btn[B]){
                    usertv5.setText("Me : 주어+동사+목적어+목적격보어입니다!");
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
        tvCount=0;
    }


}//클래스

