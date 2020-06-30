package com.calmdawnstudio.rentbung;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragManualLast extends Fragment implements View.OnClickListener {



    public FragManualLast() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frag_manual_last, container, false);

        Button button_login_signUp = view.findViewById(R.id.button_login_signUp);

        button_login_signUp.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_login_signUp){

            Intent intent_signUp = new Intent(getActivity(), SignUpActivity.class);
            startActivity(intent_signUp);
        }
    }
}
