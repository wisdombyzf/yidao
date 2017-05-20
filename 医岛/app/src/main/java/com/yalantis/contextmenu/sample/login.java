package com.yalantis.contextmenu.sample;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yalantis.contextmenu.R;

public class login extends AppCompatActivity {
    private String httpreturn="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b1= (Button) findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklogin();
            }
        });
    }

    private void checklogin() {
        String myid="";
        String mypassword="";
        TextView id= (TextView) findViewById(R.id.account);
        TextView password= (TextView) findViewById(R.id.password);
        myid=id.getText().toString();
        mypassword=password.getText().toString();
        final String finalMyid1 = myid;
        final String finalMypassword1 = mypassword;
        new Thread()
        {
            @Override
            public void run() {
                super.run();
                httpreturn=httpcheck();
                handler.sendEmptyMessage(0x123);
            }

            private String httpcheck() {
                String myurl="http://www.cxyzf.cn/internet/user.php";
                String myparam="id="+ finalMyid1+"&password="+ finalMypassword1;
                String res="";
                res=http.sendPost(myurl,myparam);
                return res;
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
        TextView id= (TextView) findViewById(R.id.account);
        if (httpreturn=="")
        {
            new AlertDialog.Builder(this).setTitle("提示").setMessage("您输入的密码有误，请重新输入").show();
        }else {
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);
        }
    }

    private void guahao() {
        //setContentView(R.layout.guanhao);

    }

    private void jiaofei() {
        //setContentView(R.layout.jiaofei);
    }
}
