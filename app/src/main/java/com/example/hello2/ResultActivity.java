package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv_result=findViewById(R.id.tv_result2);


        Intent inIntent=getIntent();
        Bundle inBundle=inIntent.getExtras();

        Log.d("n1",Double.toString(inBundle.getDouble("n1")));
        Log.d("n2",Double.toString(inBundle.getDouble("n2")));
        Log.d("token",inBundle.getString("token"));
        Log.d("res",Double.toString(inBundle.getDouble("res")));

        tv_result.setText(Double.toString(inBundle.getDouble("n1"))+inBundle.getString("token")
                + Double.toString((inBundle.getDouble("n2")))
                +"="
                +Double.toString((inBundle.getDouble("res"))));
    }
}