package com.example.coinchanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String displayTing, inputTing;
    double money;
    int dollar,fiftycent,twentycent,tencent,fivecent,onecent,ting;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
    }

    public void calculate(View view) {
        inputTing = editText.getText().toString();
        money = Double.parseDouble(inputTing);
        //get dollar amount
        dollar = (int)money;
        //get fifty cent amount
        inputTing = inputTing.substring(inputTing.indexOf(".")+1);
        ting = Integer.parseInt(inputTing);
        fiftycent=0;
        if(ting>50) {
            fiftycent = 1;
            ting = ting-50;
        }
        //get twenty cent amount
        twentycent=0;
        twentycent = ting/20;
        ting = ting - twentycent*20;
        //get ten cent amount
        tencent=0;
        tencent = ting/10;
        ting = ting - tencent*10;
        //get five cent amount
        fivecent=0;
        fivecent = ting/5;
        ting = ting - fivecent*5;
        //get one cent amount
        onecent=ting;
        displayTing = "$1.00: "+dollar+"\n$0.50: "+fiftycent+"\n$0.20: "+twentycent+"\n$0.10: "+tencent+"\n$0.05: "+fivecent+"\n$0.01: "+onecent;
        textView.setText(displayTing);
    }
}
