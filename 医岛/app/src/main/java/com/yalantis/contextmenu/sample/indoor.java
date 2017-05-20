package com.yalantis.contextmenu.sample;

import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.library.PhotoView;
import com.yalantis.contextmenu.R;

public class indoor extends AppCompatActivity {

    private String destination="";
    private ViewPager mPager;

    private int[] imgsId = new int[]{R.drawable.f2, R.drawable.f2l};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.img);
        updateimg();
    }

    private void updateimg() {
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));
        mPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgsId.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PhotoView view = new PhotoView(indoor.this);
                view.enable();
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setImageResource(imgsId[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        Button b1= (Button) findViewById(R.id.findbuttun);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgsId= new int[]{R.drawable.goerke};
                updateimg();
            }
        });
        Button b2= (Button) findViewById(R.id.ditu);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgsId= new int[]{R.drawable.f2};
                updateimg();
            }
        });
        Button b3= (Button) findViewById(R.id.daoyin);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgsId= new int[]{R.drawable.f2l};
                updateimg();
            }
        });
    }
}