package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button execCalcBMI;      //計算開始ボタンへの参照
    private EditText hightnumber;   //身長入力欄への参照
    private EditText weightnumber;  //体重入力欄への参照
    private TextView kekka;         //BMI結果への参照


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        execCalcBMI = findViewById(R.id.button);  //ボタンの参照を取得
        hightnumber = findViewById(R.id.hightnumber); //身長入力欄の参照を取得
        weightnumber = findViewById(R.id.weightnumber); //体重入力欄の参照を取得
        kekka = findViewById(R.id.kekka); //BMI結果表示欄の参照を取得


        execCalcBMI.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double hightnumber_double = Double.valueOf(hightnumber.getText().toString());
                double weightnumber_double = Double.valueOf(weightnumber.getText().toString());
                double BMI = calcBMI(hightnumber_double, weightnumber_double);
                String result = String.format("%.2f" , BMI);
                kekka.setText(result);
            }
        });
    }
    //BMI算出
    private double calcBMI( double h, double w ){
        double bmi= 0;
        if(h > 0 && w > 0 ){
            bmi =  w / (h * h) * 10000;
        }
        return bmi;
    }
}
