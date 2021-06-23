package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weight1, height1;
    TextView resultTxt;
    private float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         height1= findViewById(R.id.heightEnter);
         weight1= findViewById(R.id.weightEnter);
         resultTxt = findViewById(R.id.resultView);

    }

    private float calculateBMI(float weight , float height) {

        return (float) (weight / (Math.pow((height/100),2)));
    }

    private String interpretBMI(float bmiValue){
        if(bmiValue<16){
            return "Severly Underweight";
        }
        else if(bmiValue < 18.5){
            return "Underweight";
        }
        else if(bmiValue < 25){
            return "Normal";
        }
        else if(bmiValue < 30){
            return "Overweight";
        }else{
            return "Obese";
        }
    }

    @SuppressLint("SetTextI18n")
    public void btnOnClick(View view) {
        result = calculateBMI(Float.parseFloat(weight1.getText().toString()),Float.parseFloat(height1.getText().toString()));
        resultTxt.setText(String.valueOf(result) + "\n" + interpretBMI(result));
    }
}