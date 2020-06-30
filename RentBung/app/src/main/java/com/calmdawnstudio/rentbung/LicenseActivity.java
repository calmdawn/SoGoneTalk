package com.calmdawnstudio.rentbung;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LicenseActivity extends AppCompatActivity implements View.OnClickListener {

    public  static Activity License_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);

        License_Activity = LicenseActivity.this;

        Button signUp = findViewById(R.id.button_signUp);
        TextView signLater  = findViewById(R.id.text_signLater);



        signUp.setOnClickListener(this);
        signLater.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_signUp) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_license, new FragLicenseLast()).addToBackStack(null).commit();

        }

        if(v.getId() == R.id.text_signLater){

            Intent intent_authorization = new Intent(getApplicationContext(), Authorization.class);
            startActivity(intent_authorization);

        }

    }
}
