package com.smitchawda.casestudy1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //XML Design Components
    TextView results;
    Button btnClear;
    Button btnBackSpace;
    Button btnPercentage;
    Button btnDivide;
    Button btnMultiply;
    Button btnSubstract;
    Button btnAdd;
    Button btnDecimal;
    Button btnEquals;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    double leftOperand;
    double rightOperand;
    String operator;
    boolean isOperatorPresent=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initializeDesignComponents();
        }
        catch (Exception e) {
            System.out.println("Component Init Failed.");
            e.printStackTrace();
        }
        //Adding listners
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                results.setText("");
            }
        });
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentStr = results.getText().toString();
                String modStr = currentStr.substring(1);
                results.setText(modStr);
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double currentValue = Double.parseDouble(results.getText().toString());
                currentValue /= 100.00;
                results.setText(currentValue+"");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOperatorPresent=true;
                operator="/";
                String str = results.getText().toString();
                leftOperand = Double.parseDouble(str);
                str = str + " / ";
                results.setText(str);
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOperatorPresent=true;
                operator="X";
                String str = results.getText().toString();
                leftOperand = Double.parseDouble(str);
                str = str + " X ";
                results.setText(str);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOperatorPresent=true;
                operator="+";
                String str = results.getText().toString();
                leftOperand = Double.parseDouble(str);
                str = str + " + ";
                results.setText(str);
            }
        });
        btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOperatorPresent=true;
                operator="-";
                String str = results.getText().toString();
                leftOperand = Double.parseDouble(str);
                str = str + " - ";
                results.setText(str);
            }
        });

    }

    private void initializeDesignComponents(){
        //Component Initialization
        results = findViewById(R.id.results);
        btnClear = findViewById(R.id.btnClear);
        btnBackSpace = findViewById(R.id.btnBackSpace);
        btnPercentage = findViewById(R.id.btnPercent);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubstract = findViewById(R.id.btnSubstract);
        btnEquals = findViewById(R.id.btnEqual);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }
}