package com.kenneth1993.education;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import static com.kenneth1993.education.Application_Atschool_For_Draw1.life;
import static com.kenneth1993.education.Grammar.actlist;

public class Application_ListView_Atschool1 extends AppCompatActivity {

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
    static int tvCount1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atschool1);

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
                tvCount1++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //max 50초 5초 대화시작, [버튼 누를 기회 10초] 14초 cpu 대화 15초 버튼 바꾸기 25초 버튼 바꾸기.
                        if(life==30){
                            Toast.makeText(Application_ListView_Atschool1.this, "fail", Toast.LENGTH_SHORT).show();

                            //패배했습니다 다이얼로그 띄우기
                            final AlertDialog.Builder builder=new AlertDialog.Builder(Application_ListView_Atschool1.this);
                            builder.setTitle("복습을 더 하셔야겠어요!");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

//                                    finish가 될때 onpause가 불려지기 때문에 굳이 여기서 또 하지않아도 됨.
                                    Intent intent=new Intent(Application_ListView_Atschool1.this,Application.class);
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            AlertDialog dialog= builder.create();
                            dialog.show();
                        }

                        if(tvCount1==65){ task.cancel();}
                        Toast.makeText(Application_ListView_Atschool1.this, "곧 시작됩니다.", Toast.LENGTH_SHORT).show();
                        //kenneth가 말을 시작하기 전에 클릭 불가능
                        if(tvCount1<3){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount1==3){ cputv1.setText("Kenneth : 올바른 Be 동사는 어느 것일까요?");}
                        //말 한 이후로 클릭 가능하게 하기.
                        if(tvCount1==4){StartAnswer(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}

                        if(tvCount1==8){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount1==9){ cputv2.setText("Kenneth : 올바른 Be 동사의 과거형은 어느 것일까요?");}
                        if(tvCount1==10){ Answer1(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount1==14){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount1==15){ cputv3.setText("Kenneth : 일반동사의 과거형은 동사 뒤에 어떻게 자리할까요?");}
                        if(tvCount1==16){ Answer2(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount1==20){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount1==21){ cputv4.setText("Kenneth : 일반동사의 과거분사형은 어느형식으로 자리할까요?");}
                        if(tvCount1==22){ Answer3(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount1==26){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount1==27){ cputv5.setText("Kenneth : 나 자신의 기분이나,상태를 나타내는 Be동사는 무엇일까요?");}
                        if(tvCount1==28){ Answer4(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount1==32){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount1==33){ cputv6.setText("Kenneth : 상대방의 기분이나 상태를 나타내려면 무슨 동사가 와야 할까요?");}
                        if(tvCount1==34){ Answer5(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true); }
                        if(tvCount1==38){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount1==39){ cputv7.setText("Kenneth : 나 자신이나 상대방의 행동을 나타내는 동사는 무엇일까요?");}
                        if(tvCount1==40){ Answer6(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true); }
                        if(tvCount1==41){Intent intent=new Intent(Application_ListView_Atschool1.this ,Application_ListView_Atschool2.class);
                            startActivity(intent);
                            finish();}


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

        btn[A].setText(R.string.sentences25);
        btn[B].setText(R.string.sentences26);
        btn[C].setText(R.string.sentences27);
        btn[D].setText(R.string.sentences28);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[B] || btn[0]==btn[C] || btn[0]==btn[A]){
                    fail=true;
                }else if(btn[0]==btn[D]){
                    usertv1.setText("Me: am, are, is. ");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A]|| btn[1]==btn[B] || btn[1]==btn[C]){
                    fail=true;
                }else if(btn[1]==btn[D]){
                    usertv1.setText("Me: are, is , am");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A]|| btn[2]==btn[B] || btn[2]==btn[C]){
                    fail=true;
                }else if(btn[2]==btn[D]){
                    usertv1.setText("Me: are, is , am");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A]|| btn[3]==btn[B] || btn[3]==btn[C]){
                    fail=true;
                }else if(btn[3]==btn[D]){
                    usertv1.setText("Me: are, is , am");
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////


    }//startconverstation

    //0,1 fail
    public void Answer1() {




        btn[A].setText(R.string.sentences29);
        btn[B].setText(R.string.sentences30);
        btn[C].setText(R.string.sentences31);
        btn[D].setText(R.string.sentences32);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if (btn[0] == btn[A] || btn[0] == btn[B] || btn[0] == btn[D]) {
                    fail = true;
                } else if (btn[0] == btn[C]) {
                    usertv2.setText("Me : were, was");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[1] == btn[A] || btn[1] == btn[B] || btn[1] == btn[D]) {
                    fail = true;
                } else if (btn[1] == btn[C]) {
                    usertv2.setText("Me : were, was");
                }


            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[2] == btn[A] || btn[2] == btn[B] || btn[2] == btn[D]) {
                    fail = true;
                } else if (btn[2] == btn[C]) {
                    usertv2.setText("Me : were, was");
                }


            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[3] == btn[A] || btn[3] == btn[B] || btn[3] == btn[D]) {
                    fail = true;
                } else if (btn[3] == btn[C]) {
                    usertv2.setText("Me : were, was");
                }


            }
        });
    }

//2,3 fail

    public void Answer2(){



        btn[A].setText(R.string.sentences33);
        btn[B].setText(R.string.sentences34);
        btn[C].setText(R.string.sentences35);
        btn[D].setText(R.string.sentences36);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[C] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[B]){
                    usertv3.setText("Me : 대부분의 일반동사의 과거형은 ed를 붙입니다!");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[C] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[B]){
                    usertv3.setText("Me : 대부분의 일반동사의 과거형은 ed를 붙입니다!");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[C] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[B]){
                    usertv3.setText("Me : 대부분의 일반동사의 과거형은 ed를 붙입니다!");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[C] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[B]){
                    usertv3.setText("Me : 대부분의 일반동사의 과거형은 ed를 붙입니다!");
                }
            }
        });

    }

    //2,3
    public void Answer3(){


        btn[A].setText(R.string.sentences37);
        btn[B].setText(R.string.sentences38);
        btn[C].setText(R.string.sentences39);
        btn[D].setText(R.string.sentences40);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[B] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[C]){
                    usertv4.setText("Me : 일반동사의 대부분은 ed 형이요!");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[B] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[C]){
                    usertv4.setText("Me : 일반동사의 대부분은 ed 형이요!");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[B] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[C]){
                    usertv4.setText("Me : 일반동사의 대부분은 ed 형이요!");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[B] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[C]){
                    usertv4.setText("Me : 일반동사의 대부분은 ed 형이요!");
                }
            }
        });

    }

    public void Answer4(){


        btn[A].setText(R.string.sentences41);
        btn[B].setText(R.string.sentences42);
        btn[C].setText(R.string.sentences43);
        btn[D].setText(R.string.sentences44);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.

                if(btn[0]==btn[C]|| btn[0]==btn[B] || btn[0]==btn[A] ){
                    fail=true;
                }if(btn[0]==btn[D]){
                    usertv5.setText("Me : 정답은..  Am 입니다!");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[C]|| btn[1]==btn[B] || btn[1]==btn[A] ){
                    fail=true;
                }if(btn[1]==btn[D]){
                    usertv5.setText("Me : 정답은..  Am 입니다!");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[C]|| btn[2]==btn[B] || btn[2]==btn[A] ){
                    fail=true;
                }if(btn[2]==btn[D]){
                    usertv5.setText("Me : 정답은..  Am 입니다!");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[C]|| btn[3]==btn[B] || btn[3]==btn[A] ){
                    fail=true;
                }if(btn[3]==btn[D]){
                    usertv5.setText("Me : 정답은..  Am 입니다!");
                }
            }
        });

    }

    public void Answer5(){


        btn[A].setText(R.string.sentences45);
        btn[B].setText(R.string.sentences46);
        btn[C].setText(R.string.sentences47);
        btn[D].setText(R.string.sentences48);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[D]|| btn[0]==btn[B]){
                    fail=true;
                }if(btn[0]==btn[C]){
                    usertv6.setText("Me : 정답은 Are 입니다!");
                }if(btn[0]==btn[A]){
                    Toast.makeText(Application_ListView_Atschool1.this, "감동입니다..", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[D]|| btn[1]==btn[B]){
                    fail=true;
                }if(btn[1]==btn[C]){
                    usertv6.setText("Me : 정답은 Are 입니다!");
                }if(btn[1]==btn[A]){
                    Toast.makeText(Application_ListView_Atschool1.this, "감동입니다..", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[D]|| btn[2]==btn[B]){
                    fail=true;
                }if(btn[2]==btn[C]){
                    usertv6.setText("Me : 정답은 Are 입니다!");
                }if(btn[2]==btn[A]){
                    Toast.makeText(Application_ListView_Atschool1.this, "감동입니다..", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[D]|| btn[3]==btn[B]){
                    fail=true;
                }if(btn[3]==btn[C]){
                    usertv6.setText("Me : 정답은 Are 입니다!");
                }if(btn[3]==btn[A]){
                    Toast.makeText(Application_ListView_Atschool1.this, "감동입니다..", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void Answer6(){


        btn[A].setText(R.string.sentences49);
        btn[B].setText(R.string.sentences50);
        btn[C].setText(R.string.sentences51);
        btn[D].setText(R.string.sentences52);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A]|| btn[0]==btn[B] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[C]){
                    usertv7.setText("Me : 물론! '일반동사' 입니다!");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A]|| btn[1]==btn[B] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[C]){
                    usertv7.setText("Me : 물론! '일반동사' 입니다!");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A]|| btn[2]==btn[B] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[C]){
                    usertv7.setText("Me : 물론! '일반동사' 입니다!");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A]|| btn[3]==btn[B] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[C]){
                    usertv7.setText("Me : 물론! '일반동사' 입니다!");
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
        tvCount1=0;
    }


}
