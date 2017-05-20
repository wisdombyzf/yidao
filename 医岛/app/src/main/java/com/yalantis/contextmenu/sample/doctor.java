package com.yalantis.contextmenu.sample;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yalantis.contextmenu.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class doctor extends AppCompatActivity {
    private String myresult="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Button find= (Button) findViewById(R.id.doctor);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find_doctor();
            }
        });
    }

    private void find_doctor()
    {
        TextView text1= (TextView) findViewById(R.id.editText);
        String name=text1.getText().toString();
        http(name);

        TextView t2= (TextView) findViewById(R.id.editText2);
        t2.setText(name);
    }

    private void http(final String name) {
        new Thread()
        {
            @Override
            public void run() {
                super.run();
                myresult= message(name);
                handler.sendEmptyMessage(0x123);
            }

            private String message(String name) {
                String result="";
                String pp="http://www.cxyzf.cn/internet/doctor.php?name="+name;
                try {
                    URL myurl=new URL(pp);
                    HttpURLConnection con= (HttpURLConnection) myurl.openConnection();
                    con.connect();
                    BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line="";
                    while ((line=in.readLine())!=null)
                    {
                        result+=line;
                    }
                    return result;
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }
        }.start();
    }

    android.os.Handler handler = new android.os.Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what == 0x123)
            {
                update();
            }
        }
    };

    private void update() {
        TextView t3= (TextView) findViewById(R.id.editText2);
        t3.setText(myresult);
    }

}
