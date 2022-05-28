package com.example.mp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.os.Handler;
import android.widget.Button;
//import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button senddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //send data
        senddata = findViewById(R.id.button2);

        senddata.setOnClickListener(v -> {
            DatabaseReference dbReference = FirebaseDatabase.getInstance().getReference();

            dbReference.child("feed").setValue(true);
            Handler mHandler = new Handler();

            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dbReference.child("feed").setValue(false);
                    Toast t = Toast.makeText(getApplicationContext(), "사료주기 완료", Toast.LENGTH_SHORT);
                    t.show();
                }
            },3000);
        });
        //

        //activity change
        btn1 = findViewById(R.id.button);

        //Change VideoActivity
        btn1.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
            startActivity(intent);
        });
    }
}