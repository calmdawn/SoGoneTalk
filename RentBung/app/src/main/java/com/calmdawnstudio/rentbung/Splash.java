package com.calmdawnstudio.rentbung;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/*
* 처음에 앱 구동시 보여주는 로딩화면
* */
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new SplashHandler(), 5000); //1000ms당 1초

        ImageView loadLayout =   findViewById(R.id.layout_loading);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(loadLayout);
        Glide.with(this).load(R.drawable.splash_loading).into(gifImage);


    }

    private class SplashHandler implements Runnable{
        @Override
        public void run() {
            startActivity(new Intent(getApplication(), ManualActivity.class));    //로딩이 끝난 후, ChoiceFunction 이동
            Splash.this.finish(); // 로딩페이지 Activity stack에서 제거
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed(); 초반 화면에서 뒤로가기버튼 방지
    }
}
