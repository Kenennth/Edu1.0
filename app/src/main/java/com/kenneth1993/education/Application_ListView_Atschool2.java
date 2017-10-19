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

import static com.kenneth1993.education.Application_Atschool_For_Draw2.life;
import static com.kenneth1993.education.Grammar.actlist;

public class Application_ListView_Atschool2 extends AppCompatActivity {

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
    static int tvCount2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atschool2);

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




        //TODO 여기 안했음
        //타이머를 이용해서 화면에 cpu 텍스트 찍어내기..
        timer=new Timer();
        task=new TimerTask() {
            @Override
            public void run() {
                tvCount2++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(life==30){
                            Toast.makeText(Application_ListView_Atschool2.this, "fail", Toast.LENGTH_SHORT).show();

                            //패배했습니다 다이얼로그 띄우기
                            final AlertDialog.Builder builder=new AlertDialog.Builder(Application_ListView_Atschool2.this);
                            builder.setTitle("복습을 더 하셔야겠어요!");
                            builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intent=new Intent(Application_ListView_Atschool2.this,Application.class);
                                    startActivity(intent);
                                    finish();

                                }
                            });
                            AlertDialog dialog= builder.create();
                            dialog.show();
                        }

                        //max 50초 5초 대화시작, [버튼 누를 기회 10초] 14초 cpu 대화 15초 버튼 바꾸기 25초 버튼 바꾸기.
                        if(tvCount2==65){ task.cancel();}
                        Toast.makeText(Application_ListView_Atschool2.this, "곧 시작됩니다.", Toast.LENGTH_SHORT).show();
                        //kenneth가 말을 시작하기 전에 클릭 불가능
                        if(tvCount2<3){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount2==3){ cputv1.setText("Kenneth : 현재분사의 쓰임에 대한 문제입니다.");}
                        //말 한 이후로 클릭 가능하게 하기.
                        if(tvCount2==9){ cputv2.setText("Kenneth : 지금까지 그는 계속 자고있습니다.");}
                        if(tvCount2==10){ StartAnswer(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount2==14){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount2==15){ cputv3.setText("Kenneth : 눈이 올때, 그들은 제설을 합니다.");}
                        if(tvCount2==16){ Answer1(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount2==20){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount2==21){ cputv4.setText("Kenneth : 빨리 가지 않으면, 친구들이 저를 기다릴거에요.");}
                        if(tvCount2==22){ Answer2(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount2==26){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount2==27){ cputv5.setText("Kenneth : 너 많이 변했다! 그리고 그녀는 전혀 놀라지 않았다.");}
                        if(tvCount2==28){ Answer3(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount2==32){btn[0].setClickable(false); btn[1].setClickable(false); btn[2].setClickable(false); btn[3].setClickable(false);}
                        if(tvCount2==33){ cputv6.setText("Kenneth : 그는 경찰이 되기 위해서 공부를 계속하고있습니다.");}
                        if(tvCount2==34){ Answer4(); btn[0].setClickable(true); btn[1].setClickable(true); btn[2].setClickable(true); btn[3].setClickable(true);}
                        if(tvCount2==39){ cputv7.setText("Kenneth : 수고하셨습니다.");}
                        if(tvCount2==40){Intent intent=new Intent(Application_ListView_Atschool2.this ,Application_ListView_Atschool3.class);
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
        timer.schedule(task, 0, 3000);
        ////////////////////////////////////////////////////////
    }







    public void StartAnswer(){


        //버튼을 누르면 상태가 바뀌는 영역/////////////////////////////////////////////////////////////

        btn[A].setText(R.string.sentences53);
        btn[B].setText(R.string.sentences54);
        btn[C].setText(R.string.sentences55);
        btn[D].setText(R.string.sentences56);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[B] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[C]){
                    usertv1.setText("Me: 현재 진행형입니다. ");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[B] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[C]){
                    usertv1.setText("Me: 현재 진행형입니다. ");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[B] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[C]){
                    usertv1.setText("Me: 현재 진행형입니다. ");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[B] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[C]){
                    usertv1.setText("Me: 현재 진행형입니다. ");
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////


    }//startconverstation

    //0,1 fail
    public void Answer1() {




        btn[A].setText(R.string.sentences57);
        btn[B].setText(R.string.sentences58);
        btn[C].setText(R.string.sentences59);
        btn[D].setText(R.string.sentences60);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[B] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[C]){
                    usertv2.setText("Me: 현재 진행형입니다. ");
                }

            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[B] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[C]){
                    usertv2.setText("Me: 현재 진행형입니다. ");
                }

            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[B] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[C]){
                    usertv2.setText("Me: 현재 진행형입니다. ");
                }

            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[B] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[C]){
                    usertv2.setText("Me: 현재 진행형입니다. ");
                }

            }
        });
    }

//2,3 fail

    public void Answer2(){



        btn[A].setText(R.string.sentences61);
        btn[B].setText(R.string.sentences62);
        btn[C].setText(R.string.sentences63);
        btn[D].setText(R.string.sentences64);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[A] || btn[0]==btn[B] || btn[0]==btn[C] ){
                    fail=true;
                }else if(btn[0]==btn[D]){
                    usertv3.setText("Me : 현재 진행형입니다.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[A] || btn[1]==btn[B] || btn[1]==btn[C] ){
                    fail=true;
                }else if(btn[1]==btn[D]){
                    usertv3.setText("Me : 현재 진행형입니다.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[A] || btn[2]==btn[B] || btn[2]==btn[C] ){
                    fail=true;
                }else if(btn[2]==btn[D]){
                    usertv3.setText("Me : 현재 진행형입니다.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[A] || btn[3]==btn[B] || btn[3]==btn[C] ){
                    fail=true;
                }else if(btn[3]==btn[D]){
                    usertv3.setText("Me : 현재 진행형입니다.");
                }
            }
        });

    }

    //2,3
    public void Answer3() {


        btn[A].setText(R.string.sentences65);
        btn[B].setText(R.string.sentences66);
        btn[C].setText(R.string.sentences67);
        btn[D].setText(R.string.sentences68);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if (btn[0] == btn[B] || btn[0] == btn[C] || btn[0] == btn[D]) {
                    fail = true;
                } else if (btn[0] == btn[A]) {
                    usertv4.setText("Me : 현재 완료형, 현재완료형입니다.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[1] == btn[B] || btn[1] == btn[C] || btn[1] == btn[D]) {
                    fail = true;
                } else if (btn[1] == btn[A]) {
                    usertv4.setText("Me : 현재 완료형, 현재완료형입니다.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[2] == btn[B] || btn[2] == btn[C] || btn[2] == btn[D]) {
                    fail = true;
                } else if (btn[2] == btn[A]) {
                    usertv4.setText("Me : 현재 완료형, 현재완료형입니다.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn[3] == btn[B] || btn[3] == btn[C] || btn[3] == btn[D]) {
                    fail = true;
                } else if (btn[3] == btn[A]) {
                    usertv4.setText("Me : 현재 완료형, 현재완료형입니다.");
                }
            }
        });
    }

    public void Answer4(){


        btn[A].setText(R.string.sentence1);
        btn[B].setText(R.string.sentence2);
        btn[C].setText(R.string.sentence3);
        btn[D].setText(R.string.sentence4);


        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //만약에 누른 버튼이 sentences1 이거나 sentences 2 라면 fail(인덱스와 주소값으로 비교)
                //만약에 btn[0]의 자리가 btn[A](랜덤 으로 나오는 인덱스와 같다면),또는 btn[0]의 자리가 btn[B](랜덤으로 나오는 인덱스와 같다면) fail, sentences1,2가 답변이 이상하니까 A,B로 지정.
                if(btn[0]==btn[B] || btn[0]==btn[C] || btn[0]==btn[D]){
                    fail=true;
                }else if(btn[0]==btn[A]){
                    usertv5.setText("Me : 현재 완료 진행형입니다.");
                }
            }
        });

        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[1]==btn[B] || btn[1]==btn[C] || btn[1]==btn[D]){
                    fail=true;
                }else if(btn[1]==btn[A]){
                    usertv5.setText("Me : 현재 완료 진행형입니다.");
                }
            }
        });

        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[2]==btn[B] || btn[2]==btn[C] || btn[2]==btn[D]){
                    fail=true;
                }else if(btn[2]==btn[A]){
                    usertv5.setText("Me : 현재 완료 진행형입니다.");
                }
            }
        });

        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn[3]==btn[B] || btn[3]==btn[C] || btn[3]==btn[D]){
                    fail=true;
                }else if(btn[3]==btn[A]){
                    usertv5.setText("Me : 현재 완료 진행형입니다.");
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
        tvCount2=0;
    }


}
