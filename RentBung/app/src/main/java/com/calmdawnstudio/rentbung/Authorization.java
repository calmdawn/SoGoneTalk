package com.calmdawnstudio.rentbung;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Authorization extends AppCompatActivity implements View.OnClickListener {
    Button button_start;
    CheckBox checkBox_agreeAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        button_start = findViewById(R.id.button_start);
        checkBox_agreeAll = findViewById(R.id.checkbox_agreeAll);

        checkBox_agreeAll.setOnClickListener(this);
        button_start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.checkbox_agreeAll){
            if(checkBox_agreeAll.isChecked()){
                button_start.setEnabled(true);
                button_start.setTextColor(Color.rgb(204,0,0));
            }else{
                button_start.setEnabled(false);
                button_start.setTextColor(Color.rgb(255,255,255));
            }

        }

        if(v.getId() == R.id.button_start){

            SignUpActivity SUA = (SignUpActivity)SignUpActivity.SignUp_Activity;
            LicenseActivity LA = (LicenseActivity) LicenseActivity.License_Activity;
            SUA.finish();
            LA.finish();
            Authorization.this.finish();

        }
    }
}
