package com.kenneth1993.education;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by alfo06-24 on 2017-09-27.
 */

public class FeedBack extends AppCompatActivity {



    RadioButton man;
    RadioButton woman;

    RadioButton [] ages=new RadioButton[4];

    EditText subject;
    EditText contents;
    Button submit;

    String [] SexString=new String[2];
    int teenager=0;
    int adult20=0;
    int adult30=0;
    int adult40=0;

    String insertUrl="chosj2da.dothome.co.kr/Test/insertDB.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        subject=(EditText)findViewById(R.id.subject);
        contents=(EditText)findViewById(R.id.contents);
        submit=(Button)findViewById(R.id.submit);
        man=(RadioButton)findViewById(R.id.btnman);
        woman=(RadioButton)findViewById(R.id.btnwoman);
        submit=(Button)findViewById(R.id.submit);
        ages[0]=(RadioButton)findViewById(R.id.teenager);
        ages[1]=(RadioButton)findViewById(R.id.adult20);
        ages[2]=(RadioButton)findViewById(R.id.adult30);
        ages[3]=(RadioButton)findViewById(R.id.adult40);




        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                이 기록은 한 플레이어에 최초 한번만 가능하고 이게 서버로 전송되어야하고, 사용자들이 입력하는 값들을 1씩 더해줘야됨..

                new Thread(){
                    @Override
                    public void run() {

                        String sub=subject.getText().toString();
                        String con=contents.getText().toString();

                        try {
                            sub= URLEncoder.encode(sub,"utf-8");
                            con= URLEncoder.encode(con,"utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        try {
                            URL url= new URL(insertUrl);

                            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                            conn.setRequestMethod("POST");
                            conn.setDoInput(true);
                            conn.setDoOutput(true);
                            conn.setUseCaches(false);

                            String data="Subject="+sub+"&Contents="+con;

                            OutputStream os=conn.getOutputStream();
                            os.write(data.getBytes());
                            os.flush();
                            os.close();

                            InputStream is= conn.getInputStream();
                            InputStreamReader isr= new InputStreamReader(is);
                            BufferedReader reader= new BufferedReader(isr);
                            
                            final StringBuffer buffer=new StringBuffer();
                            String line=reader.readLine();
                            while(line!=null){
                                buffer.append(line);
                                line=reader.readLine();
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(FeedBack.this, buffer.toString(), Toast.LENGTH_SHORT).show();

                                    subject.setText("");
                                    contents.setText("");
                                }
                            });

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }.start();

//                성별구별
                if(man.isChecked()== true){
                    SexString[0]="남성";
                    man.setClickable(false);
                }if(woman.isChecked()==true){
                    SexString[1]="여성";
                    woman.setClickable(false);
                }


                if(ages[0].isChecked()){
                    teenager++;
                    ages[0].setClickable(false);
                    ages[1].setClickable(false);
                    ages[2].setClickable(false);
                    ages[3].setClickable(false);

                }
                if(ages[1].isChecked()){
                    adult20++;
                    ages[0].setClickable(false);
                    ages[1].setClickable(false);
                    ages[2].setClickable(false);
                    ages[3].setClickable(false);
                }
                if(ages[2].isChecked()){
                    adult30++;
                    ages[0].setClickable(false);
                    ages[1].setClickable(false);
                    ages[2].setClickable(false);
                    ages[3].setClickable(false);
                }
                if(ages[3].isChecked()){
                    adult40++;
                    ages[0].setClickable(false);
                    ages[1].setClickable(false);
                    ages[2].setClickable(false);
                    ages[3].setClickable(false);
                }






            }
        });


    }


}
