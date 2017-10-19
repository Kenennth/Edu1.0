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

import static com.kenneth1993.education.Application_AtBank_For_Draw.life;
import static com.kenneth1993.education.Grammar.actlist;

public class Application_ListView_AtBank extends AppCompatActivity {

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
    static int tvCount9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atbank);

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
        usertv7=(TextView)findViewById(R.id.user_07);

        cputv1=(TextView)findViewById(R.id.cpu_00);
        cputv2=(TextView)findViewById(R.id.cpu_01);
        cputv3=(TextView)findViewById(R.id.cpu_02);
        cputv4=(TextView)findViewById(R.id.cpu_03);
        cputv5=(TextView)findViewById(R.id.cpu_04);
        cputv6=(TextView)findViewById(R.id.cpu_05);
        cputv7=(TextView)findViewById(R.id.cpu_06);
        cputv7=(TextView)findViewById(R.id.cpu_07);





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
                tvCount9++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (life == 30) {
                            Toast.makeText(Application_ListView_AtBank.this, "fail", Toast.LENGTH_SHORT).show();

                            //패배했습니다 다이얼로그 띄우기
                            final AlertDialog.Builder builder = new AlertDialog.Builder(Application_ListView_AtBank.this);
                            builder.setTitle("복습을 더 하셔야겠어요!");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intent = new Intent(Application_ListView_AtBank.this, Application.class);
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }

                        //max 50초 5초 대화시작, [버튼 누를 기회 10초] 14초 cpu 대화 15초 버튼 바꾸기 25초 버튼 바꾸기.
                        Toast.makeText(Application_ListView_AtBank.this, "곧 시작됩니다.", Toast.LENGTH_SHORT).show();
                        if (tvCount9 < 3) {
                            btn[0].setClickable(false);
                            btn[1].setClickable(false);
                            btn[2].setClickable(false);
                            btn[3].setClickable(false);
                        }
                        if (tvCount9 == 4) {
                            cputv1.setText("Kenneth(Teller): Hi What can i do for you??");
                        }
                        //말 한 이후로 클릭 가능하게 하기.
                        if (tvCount9 == 5) {
                            StartAnswer();
                            btn[0].setClickable(true);
                            btn[1].setClickable(true);
                            btn[2].setClickable(true);
                            btn[3].setClickable(true);
                        }
                        if(tvCount9 == 9){
                            btn[0].setClickable(false);
                            btn[1].setClickable(false);
                            btn[2].setClickable(false);
                            btn[3].setClickable(false);
                        }
                        if (tvCount9 == 10) {
                            cputv2.setText("Kenneth(Teller) : What type of account? we have several types.");
                        }
                        if (tvCount9 == 11) {
                            Answer1();
                            btn[0].setClickable(true);
                            btn[1].setClickable(true);
                            btn[2].setClickable(true);
                            btn[3].setClickable(true);
                        }
                        if(tvCount9 ==15){
                            btn[0].setClickable(false);
                            btn[1].setClickable(false);
                            btn[2].setClickable(false);
                            btn[3].setClickable(false);
                        }

                        if (tvCount9 == 16) {
                            cputv3.setText("Kenneth(Teller) : Will you be using cash or debit for purchase transactions");
                        }

                        if (tvCount9 == 17) {
                            Answer2();
                            btn[0].setClickable(true);
                            btn[1].setClickable(true);
                            btn[2].setClickable(true);
                            btn[3].setClickable(true);
                        }
                        if(tvCount9 == 21){
                            btn[0].setClickable(false);
                            btn[1].setClickable(false);
                            btn[2].setClickable(false);
                            btn[3].setClickable(false);
                        }

                        if (tvCount9 == 22) {
                            cputv4.setText("Kenneth(Teller) : How do you pay your bills?. Through the mail or online? ");
                        }
                        if (tvCount9 == 24) {
                            usertv4.setText("Me : Normally I bring them to the bank and pay at the teller but i would like to start paying them online.");
                        }
                        if (tvCount9 == 26) {
                            cputv5.setText("Kenneth(Teller) : Many customers are paying bills online in fact we recommend it ");
                        }
                        if (tvCount9 == 27) {
                            Answer3();
                            btn[0].setClickable(true);
                            btn[1].setClickable(true);
                            btn[2].setClickable(true);
                            btn[3].setClickable(true);
                        }
                        if(tvCount9 == 31){
                            btn[0].setClickable(false);
                            btn[1].setClickable(false);
                            btn[2].setClickable(false);
                            btn[3].setClickable(false);
                        }
                        if (tvCount9 == 32) {
                            cputv6.setText("Kenneth(Teller) : Yes, absolutely, Alright I'll just need some photo identification and i can start processing your new banking application");
                        }
                        if (tvCount9 == 34) {
                            usertv6.setText("Me : sure, could i use my passport?");
                        }
                        if (tvCount9 == 36) {
                            cputv7.setText("Kenneth(Teller) : Absolutely, any government issue I.D is acceptable.");
                        }
                        if( tvCount9 == 38){
                            usertv7.setText("수고하셨습니다!~");
                        }

                    }
                });
            }
        };

        timer.schedule(task, 0, 3000);
    }//oncreate








    public void StartAnswer(){


        //버튼을 누르면 상태가 바뀌는 영역/////////////////////////////////////////////////////////////

        btn[A].setText(R.string.bank1);
        btn[B].setText(R.string.bank2);
        btn[C].setText(R.string.bank3);
        btn[D].setText(R.string.bank4);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[C] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv1.setText("Me : I'd like to open a bank account. ");
                }if(btn[0]==btn[B]){
                    usertv1.setText("Me : Please open a bank account.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[C] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv1.setText("Me : I'd like to open a bank account. ");
                }if(btn[1]==btn[B]){
                    usertv1.setText("Me : Please open a bank account.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[C] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv1.setText("Me : I'd like to open a bank account. ");
                }if(btn[2]==btn[B]){
                    usertv1.setText("Me : Please open a bank account.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[C] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv1.setText("Me : I'd like to open a bank account. ");
                }if(btn[3]==btn[B]){
                    usertv1.setText("Me : Please open a bank account.");
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////


    }//startconverstation

    //0,1 fail
    public void Answer1() {




        btn[A].setText(R.string.bank5);
        btn[B].setText(R.string.bank6);
        btn[C].setText(R.string.bank7);
        btn[D].setText(R.string.bank8);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if (btn[0] == btn[A] || btn[0] == btn[D]) {
                    fail = true;
                } else if (btn[0] == btn[B]) {
                    usertv2.setText("Me : I need a regular banking.");
                } if(btn[0] == btn[C]){
                   usertv2.setText("Me : What types do you have?.");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[1] == btn[A] || btn[1] == btn[D]) {
                    fail = true;
                } else if (btn[1] == btn[B]) {
                    usertv2.setText("Me : I need a regular banking.");
                } if(btn[1] == btn[C]){
                    usertv2.setText("Me : What types do you have?.");
                }

            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[2] == btn[A] || btn[2] == btn[D]) {
                    fail = true;
                } else if (btn[2] == btn[B]) {
                    usertv2.setText("Me : I need a regular banking.");
                } if(btn[2] == btn[C]){
                    usertv2.setText("Me : What types do you have?.");
                }

            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[3] == btn[A] || btn[3] == btn[D]) {
                    fail = true;
                } else if (btn[3] == btn[B]) {
                    usertv2.setText("Me : I need a regular banking.");
                } if(btn[3] == btn[C]){
                    usertv2.setText("Me : What types do you have?.");
                }

            }
        });
    }

//2,3 fail

    public void Answer2(){



        btn[A].setText(R.string.bank9);
        btn[B].setText(R.string.bank10);
        btn[C].setText(R.string.bank11);
        btn[D].setText(R.string.bank12);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[B] || btn[0]== btn[C]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv3.setText("Me : I use my debit card quite a bit.");
                }if(btn[0]==btn[D]){
                    usertv3.setText("Me : Both of them.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[B] || btn[1]== btn[C]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv3.setText("Me : I use my debit card quite a bit.");
                }if(btn[1]==btn[D]){
                    usertv3.setText("Me : Both of them.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[B] || btn[2]== btn[C]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv3.setText("Me : I use my debit card quite a bit.");
                }if(btn[2]==btn[D]){
                    usertv3.setText("Me : Both of them.");
                }

            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[B] || btn[3]== btn[C]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv3.setText("Me : I use my debit card quite a bit.");
                }if(btn[3]==btn[D]){
                    usertv3.setText("Me : Both of them.");
                }
            }
        });

    }

    //2,3
    public void Answer3(){


        btn[A].setText(R.string.bank13);
        btn[B].setText(R.string.bank14);
        btn[C].setText(R.string.bank15);
        btn[D].setText(R.string.bank16);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[B] || btn[0]== btn[C] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv5.setText("Me : Okay, can i set this up with my new account?");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[B] || btn[1]== btn[C] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv5.setText("Me : Okay, can i set this up with my new account?");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[B] || btn[2]== btn[C] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv5.setText("Me : Okay, can i set this up with my new account?");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[B] || btn[3]== btn[C] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv5.setText("Me : Okay, can i set this up with my new account?");
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
        tvCount9=0;
    }


}
