package com.example.sogonetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView titleTv = findViewById(R.id.mainactivity_title);
        final TextView groupChatTv = findViewById(R.id.group_chat_textview);
        Button peopleBtn = findViewById(R.id.people_button);
        Button chatBtn = findViewById(R.id.chat_button);
        Button accountBtn = findViewById(R.id.account_button);

        final Button groupChatBtn = findViewById(R.id.mainactivity_gruop_chat_button);


        groupChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SelectFriendActicity.class));
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.people_button:
                        titleTv.setText("친구목록");
                        groupChatBtn.setVisibility(View.VISIBLE);
                        groupChatTv.setVisibility(View.VISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainactivity_framelayout, new PeopleFragment()).commit();
                        break;
                    case R.id.chat_button:
                        titleTv.setText("채팅방목록");
                        groupChatBtn.setVisibility(View.INVISIBLE);
                        groupChatTv.setVisibility(View.INVISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainactivity_framelayout, new ChatFragment()).commit();
                        break;
                    case R.id.account_button:
                        titleTv.setText("프로필설정");
                        groupChatBtn.setVisibility(View.INVISIBLE);
                        groupChatTv.setVisibility(View.INVISIBLE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.mainactivity_framelayout, new AccountFragment()).commit();
                        break;
                    default:
                        break;
                }
            }
        };
        peopleBtn.setOnClickListener(listener);
        chatBtn.setOnClickListener(listener);
        accountBtn.setOnClickListener(listener);

        passPushTokenToServer();


    }

    void passPushTokenToServer() {

        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        String token = FirebaseInstanceId.getInstance().getToken();
        Map<String, Object> map = new HashMap<>();
        map.put("pushToken", token);

        FirebaseDatabase.getInstance().getReference().child("users").child(uid).updateChildren(map);


    }
}