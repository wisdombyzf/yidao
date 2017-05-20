package com.yalantis.contextmenu.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yalantis.contextmenu.R;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Button b1= (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        Button b2= (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guidance();
            }
        });
        Button b3= (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find_doctor();
            }
        });

    }

    private void find_doctor() {
        Intent i=new Intent(this,doctor.class);
        startActivity(i);
    }

    private void guidance() {
        Intent i=new Intent(this,guidance.class);
        startActivity(i);
    }

    private void login() {
       Intent i=new Intent(this,login.class);
        startActivity(i);
    }
}

