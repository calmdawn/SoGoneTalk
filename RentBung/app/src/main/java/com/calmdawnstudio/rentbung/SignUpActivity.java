package com.calmdawnstudio.rentbung;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    public static Activity SignUp_Activity;

    EditText edit_schoolName;
    EditText edit_loginId, edit_loginPassword, edit_loginPasswordConfirm, edit_loginEmail;

    EditText edit_realName, edit_nickName, edit_studentId;

    CheckBox checkbox_agree;
    Button button_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        SignUp_Activity = SignUpActivity.this;

        //학교 입력
        edit_schoolName = findViewById(R.id.edit_schoolName);

        //로그인 정보 입력
        edit_loginId = findViewById(R.id.edit_loginId);
        edit_loginPassword = findViewById(R.id.edit_loginPassword);
        edit_loginPasswordConfirm = findViewById(R.id.edit_loginPasswordConfirm);
        edit_loginEmail = findViewById(R.id.edit_loginEmail);

        //개인 정보 입력

        edit_realName = findViewById(R.id.edit_realName);
        edit_nickName = findViewById(R.id.edit_nickName);
        edit_studentId = findViewById(R.id.edit_studentId);

        //체크박스 동의 + 확인 버튼

        checkbox_agree = findViewById(R.id.checkbox_agree);
        button_confirm = findViewById(R.id.button_confirm);

        edit_schoolName.setOnClickListener(this);
        edit_loginId.setOnClickListener(this);
        edit_loginPassword.setOnClickListener(this);
        edit_loginPasswordConfirm.setOnClickListener(this);
        edit_loginEmail.setOnClickListener(this);
        edit_realName.setOnClickListener(this);
        edit_nickName.setOnClickListener(this);
        edit_studentId.setOnClickListener(this);
        checkbox_agree.setOnClickListener(this);
        button_confirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.edit_schoolName) {
            edit_schoolName.setText("");
            edit_schoolName.setTextColor(Color.rgb(0, 0, 0));
        } else if (v.getId() == R.id.edit_loginId) {
            edit_loginId.setText("");
            edit_loginId.setTextColor(Color.rgb(0, 0, 0));
        } else if (v.getId() == R.id.edit_loginPassword) {
            edit_loginPassword.setText("");
            edit_loginPassword.setTextColor(Color.rgb(0, 0, 0));
        } else if (v.getId() == R.id.edit_loginPasswordConfirm) {
            edit_loginPasswordConfirm.setText("");
            edit_loginPasswordConfirm.setTextColor(Color.rgb(0, 0, 0));
        } else if (v.getId() == R.id.edit_loginEmail) {
            edit_loginEmail.setText("");
            edit_loginEmail.setTextColor(Color.rgb(0, 0, 0));
        } else if (v.getId() == R.id.edit_realName) {
            edit_realName.setText("");
            edit_realName.setTextColor(Color.rgb(0, 0, 0));
        } else if (v.getId() == R.id.edit_nickName) {
            edit_nickName.setText("");
            edit_nickName.setTextColor(Color.rgb(0, 0, 0));
        } else if (v.getId() == R.id.edit_studentId) {
            edit_studentId.setText("");
            edit_studentId.setTextColor(Color.rgb(0, 0, 0));
        }

        if(v.getId() == R.id.checkbox_agree){
            if(checkbox_agree.isChecked()){ //체크박스 체크될시
                button_confirm.setEnabled(true);    //확인버튼 활성화
            }else{
                button_confirm.setEnabled(false);
            }
        }
        if(v.getId() == R.id.button_confirm){
            Intent intent_license = new Intent(getApplicationContext(), LicenseActivity.class);
            startActivity(intent_license);
        }


    }



}
