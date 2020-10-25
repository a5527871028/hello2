package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MathActivity extends AppCompatActivity {
    EditText et_num1;
    EditText et_num2;
    Button bt_calculate2;
    TextView tv_result;
    RadioButton rb_a,rb_b,rb_c,rb_d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        initialization();

        Log.d("LifeCycle","onCreate"); //會顯示在Logcat裡面的文字，註解

//如果+號一開始沒被按是後來被按，將自動跑出答案
        rb_a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    String num1String=et_num1.getText().toString();
                    String num2String=et_num2.getText().toString();

                    if(num1String.isEmpty()||num2String.isEmpty()) {
                        Toast.makeText(MathActivity.this,"空白計算",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double num1 = Double.valueOf(num1String);
                        double num2 = Double.valueOf(num2String);
                        double result = 0;
                            result = num1 + num2;

                        tv_result.setText(Double.toString(result));
                    }
                }
            }
        });

//如果-號一開始沒被按是後來被按，將自動出答案
        rb_b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    String num1String=et_num1.getText().toString();
                    String num2String=et_num2.getText().toString();

                    if(num1String.isEmpty()||num2String.isEmpty()) {
                        Toast.makeText(MathActivity.this,"空白計算",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double num1 = Double.valueOf(num1String);
                        double num2 = Double.valueOf(num2String);
                        double result = 0;
                        result = num1 - num2;

                        tv_result.setText(Double.toString(result));
                    }
                }
            }
        });

//如果*號一開始沒被按是後來被按，將自動出答案
        rb_c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    String num1String=et_num1.getText().toString();
                    String num2String=et_num2.getText().toString();

                    if(num1String.isEmpty()||num2String.isEmpty()) {
                        Toast.makeText(MathActivity.this,"空白計算",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double num1 = Double.valueOf(num1String);
                        double num2 = Double.valueOf(num2String);
                        double result = 0;
                        result = num1 * num2;

                        tv_result.setText(Double.toString(result));
                    }
                }
            }
        });
//如果/號一開始沒被按，再按將自動出答案
        rb_d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    String num1String=et_num1.getText().toString();
                    String num2String=et_num2.getText().toString();

                    if(num1String.isEmpty()||num2String.isEmpty()) {
                        Toast.makeText(MathActivity.this,"空白計算",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        double num1 = Double.valueOf(num1String);
                        double num2 = Double.valueOf(num2String);
                        double result = 0;
                        result = num1/num2;

                        tv_result.setText(Double.toString(result));
                    }
                }
            }
        });


        bt_calculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1String=et_num1.getText().toString();
                String num2String=et_num2.getText().toString();

                if(num1String.isEmpty()||num2String.isEmpty()) {
                    Toast.makeText(MathActivity.this,"空白計算",Toast.LENGTH_SHORT).show();
                }
                else {
                    double num1 = Double.valueOf(num1String);
                    double num2 = Double.valueOf(num2String);
                    double result = 0;
                    String token=new String(" ");//結果的字串

                    if (rb_a.isChecked()){
                        result = num1 + num2;
                        token="+";}

                    else if (rb_b.isChecked()){
                        result = num1 - num2;
                        token="-";}

                    else if (rb_c.isChecked()){
                        result = num1 * num2;
                        token="*";}

                    else{
                        result = num1 / num2;
                        token="/";}

                    Log.d("MathResult",Double.toString(result));
                    Intent intent=new Intent(MathActivity.this,ResultActivity.class);
                    Bundle bundle=new Bundle();//貨櫃，負責運送第二頁運算變數過去第三頁
                    //運送之物品：(Key,Value)
                    bundle.putDouble("n1",num1);
                    bundle.putDouble("n2",num2);
                    bundle.putString("token",token);
                    bundle.putDouble("res",result);
                    //放好可以開車了
                    intent.putExtras(bundle);
                    startActivity(intent);
            }
            }
        });


}

    private void initialization() {
        et_num1=findViewById(R.id.et_num1);
        et_num2=findViewById(R.id.et_num2);
        bt_calculate2=findViewById(R.id.bt_calculate2);
        tv_result=findViewById(R.id.tv_result);
        rb_a=findViewById(R.id.rb_a);
        rb_b=findViewById(R.id.rb_b);
        rb_c=findViewById(R.id.rb_c);
        rb_d=findViewById(R.id.rb_d);
    }
    }