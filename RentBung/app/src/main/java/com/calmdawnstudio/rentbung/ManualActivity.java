package com.calmdawnstudio.rentbung;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class ManualActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView loadImage;
    GlideDrawableImageViewTarget gifManual;
    Button button_manual;
    ImageView imageView_round;
    LinearLayout layout_manual;

    int roundCount = 0; //round이미지의 숫자
    int imgCount = 0; //gif이미지의 숫자
    int[] imgArray = {R.drawable.manual1, R.drawable.manual2, R.drawable.manual3, R.drawable.manual4, R.drawable.manual5};
    int[] rndArray = {R.id.imageView_round1, R.id.imageView_round2, R.id.imageView_round3, R.id.imageView_round4, R.id.imageView_round5, R.id.imageView_round6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        button_manual = findViewById(R.id.button_manual);

        layout_manual = findViewById(R.id.layout_manual);

        //원형 이미지 색칠
        imageView_round = findViewById(rndArray[roundCount]);


        loadImage = findViewById(R.id.image_manual);  //gif파일을 보여줄 이미지뷰
        gifManual = new GlideDrawableImageViewTarget(loadImage);
        Glide.with(this).load(imgArray[imgCount]).into(gifManual);

        button_manual.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_manual){

            // 동그라미 이미지뷰 색을 변경해주는 조건문들
            if(roundCount<4) {
                imageView_round.setBackground(getDrawable(R.drawable.round_customizing_orange));
                roundCount++;
                imageView_round = findViewById(rndArray[roundCount]);
                imageView_round.setBackground(getDrawable(R.drawable.round_customizing_darkblue));
            } else if(roundCount==4){
                imageView_round.setBackground(getDrawable(R.drawable.round_customizing_orange));
                roundCount++;
                imageView_round = findViewById(rndArray[roundCount]);
                imageView_round.setBackground(getDrawable(R.drawable.round_customizing_orange));
              for(int i=0; i<roundCount; i++){
                  imageView_round = findViewById(rndArray[i]);
                  imageView_round.setBackground(getDrawable(R.drawable.round_customizing_white));
              }
            }

            // 이미지를 변경해주는 조건문들
            imgCount++;

            if (imgCount < 5) { //저장된 이미지를 차례로 출력

                Glide.with(this).load(imgArray[imgCount]).into(gifManual);

            } else if (imgCount == 5) { //로그인 프래그먼트

                layout_manual.setBackgroundColor(Color.rgb(26,53,68));
                button_manual.setText("시작하기");
                button_manual.setTextColor(Color.rgb(26,53,68));
                button_manual.setBackgroundColor(Color.rgb(249,140,65));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_manual, new FragManualLast()).addToBackStack(null).commit();

            } else {  //메인으로

                Intent intent_main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent_main);


            }

        }
    }

    @Override
    public void onBackPressed() {
        //이전 원 이미지 뷰로 이동
        if(0<roundCount && roundCount<5) {
            imageView_round.setBackground(getDrawable(R.drawable.round_customizing_orange));
            roundCount--;
            imageView_round = findViewById(rndArray[roundCount]);
            imageView_round.setBackground(getDrawable(R.drawable.round_customizing_darkblue));
        }
        //이전 gif이미지로 이동
        if(0<imgCount&& imgCount<5){
        imgCount--;
        Glide.with(this).load(imgArray[imgCount]).into(gifManual);
        }else{
            this.finish();
        }

    }
}
