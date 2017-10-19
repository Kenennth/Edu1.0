package com.kenneth1993.education;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import static android.support.v4.content.ContextCompat.startActivity;
import static com.kenneth1993.education.Application_ListView_Atschool.fail;
import static com.kenneth1993.education.Application_ListView_Atschool.tvCount;

/**
 * Created by stupidsungjin on 2017-07-15.
 */

public class Application_Atschool_For_Draw extends View{

    int width;
    int height;

    Bitmap waiting;
    Bitmap [] saying=new Bitmap[7];          //말하기


    Bitmap [] embarrassed=new Bitmap[6];
    Bitmap explode; // 오답시 나오는 이미지.
    Context context1;


    int i=0;//waiting
    static int life=342;
    int e;

    public Application_Atschool_For_Draw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        context1=context;

        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        width=display.getWidth();
        height=display.getHeight();

        Resources res=context.getResources();



            waiting=BitmapFactory.decodeResource(res,R.drawable.waiting_00);


        for(int k=0; k<=6; k++){
            saying[k]= BitmapFactory.decodeResource(res,R.drawable.saying_00+k);
        }
        for(int j=0; j<=5; j++){
            embarrassed[j]=BitmapFactory.decodeResource(res,R.drawable.em0+j);
        }





        explode=BitmapFactory.decodeResource(res,R.drawable.explode);
        //적정 사이즈 400,300 width와 height가 400,300정도로 오게끔..

        waiting=Bitmap.createScaledBitmap(waiting,width/2,height/2-50,false);

        embarrassed[0]=Bitmap.createScaledBitmap(embarrassed[0],width/2,height/2-50,false);
        embarrassed[1]=Bitmap.createScaledBitmap(embarrassed[1],width/2,height/2-50,false);
        embarrassed[2]=Bitmap.createScaledBitmap(embarrassed[2],width/2,height/2-50,false);
        embarrassed[3]=Bitmap.createScaledBitmap(embarrassed[3],width/2,height/2-50,false);
        embarrassed[4]=Bitmap.createScaledBitmap(embarrassed[4],width/2,height/2-50,false);
        embarrassed[5]=Bitmap.createScaledBitmap(embarrassed[5],width/2,height/2-50,false);




        saying[0]=Bitmap.createScaledBitmap(saying[0],width/2,height/2-50,false);
        saying[1]=Bitmap.createScaledBitmap(saying[1],width/2,height/2-50,false);
        saying[2]=Bitmap.createScaledBitmap(saying[2],width/2,height/2-50,false);
        saying[3]=Bitmap.createScaledBitmap(saying[3],width/2,height/2-50,false);
        saying[4]=Bitmap.createScaledBitmap(saying[4],width/2,height/2-50,false);
        saying[5]=Bitmap.createScaledBitmap(saying[5],width/2,height/2-50,false);
        saying[6]=Bitmap.createScaledBitmap(saying[6],width/2,height/2-50,false);



        handler.sendEmptyMessageDelayed(0,100);

    }



    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint=new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(20);




        //실패하면 값이깎임
        if(fail==true){
            e++;
            canvas.drawBitmap(explode,life,width/60+20,null);

            if(life<=342 && life>=292){
//                만약에 life가 330보다 작거나 같거나 280과 같거나 큰 경우
                life=life-2;
                canvas.drawBitmap(embarrassed[e],0,height/5,null);
                canvas.drawRect(30,width/60+30,life,width/60,paint);
                if(e==5){e=0;}

            }

            if(life<=290 && life>=240){
//                만약에 life가 330보다 작거나 같거나 280과 같거나 큰 경우
                life--;
                canvas.drawBitmap(embarrassed[e],0,height/5,null);
                canvas.drawRect(30,width/60+30,life,width/60,paint);
                if(e==5){e=0;}
            }

            if(life<=238 && life>=188){
//                만약에 life가 330보다 작거나 같거나 280과 같거나 큰 경우
                life--;
                canvas.drawBitmap(embarrassed[e],0,height/5,null);
                canvas.drawRect(30,width/60+30,life,width/60,paint);
                if(e==5){e=0;}
            }

            if(life<=186 && life>=136){
//                만약에 life가 330보다 작거나 같거나 280과 같거나 큰 경우
                life--;
                canvas.drawBitmap(embarrassed[e],0,height/5,null);
                canvas.drawRect(30,width/60+30,life,width/60,paint);
                if(e==5){e=0;}
            }

            if(life<=134 && life>=84){
//                만약에 life가 330보다 작거나 같거나 280과 같거나 큰 경우
                life--;
                canvas.drawBitmap(embarrassed[e],0,height/5,null);
                canvas.drawRect(30,width/60+30,life,width/60,paint);
                if(e==5){e=0;}
            }

            if(life<=82 && life>=32){
//                만약에 life가 330보다 작거나 같거나 280과 같거나 큰 경우
                life--;
                canvas.drawBitmap(embarrassed[e],0,height/5,null);
                canvas.drawRect(30,width/60+30,life,width/60,paint);
                if(e==5){e=0;}
            }

            if(life==291 || life==239 || life==187 || life==135 || life==83 || life==31){fail=false; life--;}







        }else{// 일반상태 그대로
//            canvas.drawRect(30,60,life,80,paint); //(a,b,c,d)
//            canvas.drawRect(height/15,width/17,life,width/14,paint);//(그릴 처음위치(height) x, 그릴 처음위치(width) y, 가로,세로)
            canvas.drawRect(30,width/60+30,life,width/60,paint);
            //height(800)/12 width(480)
        }

        i++;
        //left top
        if(fail!=true) {
            canvas.drawBitmap(waiting,0,height/5,null);
        }

        if(i==6){i=0;}
        if(tvCount==3){canvas.drawBitmap(saying[i],0,height/5,null);}
        if(tvCount==9){canvas.drawBitmap(saying[i],0,height/5,null);}
        if(tvCount==15){canvas.drawBitmap(saying[i],0,height/5,null);}
        if(tvCount==21){canvas.drawBitmap(saying[i],0,height/5,null);}
        if(tvCount==27){canvas.drawBitmap(saying[i],0,height/5,null);}
        if(tvCount==33){canvas.drawBitmap(saying[i],0,height/5,null);}
        if(tvCount==35){canvas.drawBitmap(saying[i],0,height/5,null);}







//            canvas.drawBitmap(mansmile[0+i],200,50,null);


    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            invalidate();
            handler.sendEmptyMessageDelayed(0,100);
        }
    };

}//class
