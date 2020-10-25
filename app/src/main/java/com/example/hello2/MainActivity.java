package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_height,et_weight;
    Button bt_calculate;
    TextView tv_bmi;
    ImageButton ib_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization(); //做新的函式去連結按鈕，避免這裡過多雜事

        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //抓使用者輸入的字串
                String heightString=et_height.getText().toString();
                String weightString=et_weight.getText().toString();

                if(heightString.isEmpty()||weightString.isEmpty()){ //如果是空字串就
                    Toast.makeText(MainActivity.this,"計算結果：喜歡你",Toast.LENGTH_SHORT).show();
                }
                else{//不然的話才去算BMI,Double是獨立類別,可以單獨存在,static
                    double height=Double.valueOf(heightString);
                    double weight=Double.valueOf(weightString)/100.0;
                    double bmi=height/(weight*weight);
                    tv_bmi.setText("BMI:"+Double.toString(bmi));
                }
            }
        });

        //換頁
        ib_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //大寫類別小寫物件
                Intent intent=new Intent(MainActivity.this,MathActivity.class);
                startActivity(intent);
                //finish(); //user會經常回上一頁就不要加這個
            }
        });

    }

    public void initialization(){
        et_weight=findViewById(R.id.et_weight);
        et_height=findViewById(R.id.et_height);
        bt_calculate=findViewById(R.id.bt_calculate);
        tv_bmi=findViewById(R.id.tv_bmi);
        ib_next=findViewById(R.id.ib_next);
    }

}