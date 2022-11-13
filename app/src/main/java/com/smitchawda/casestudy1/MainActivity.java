package com.smitchawda.casestudy1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Name: Smit Chawda
 * 
 * Email: chawdas@sheridancollege.ca
 */
public class MainActivity extends AppCompatActivity {
    //Layouts
    LinearLayout resultsArea;
    LinearLayout functionsArea;

    //XML configuration
    TextView results;
    TextView resultsPreview;
    Button btnClear;
    Button btnBackSpace;
    Button btnPercentage;
    Button btnDivide;
    Button btnMultiply;
    Button btnSubstract;
    Button btnAdd;
    Button btnDecimal;
    Button btnEquals;
    Button btnExponent;
    Button btnPi;

    //numericals
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

    //memory functions
    Button btnMadd;
    Button btnMsub;
    Button btnMr;
    Button btnMclear;

    //Operations variable
    boolean isOperatorPresent=false;
    double memory = 0.0;
    short clearCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onConfigurationChanged(getResources().getConfiguration());
        initializeDesignComponents();

        //Busniess logic goes here
        eventListeners();
    }
    /**
     * Business Logic of the application
     * Note: To add new features/fix bugs
     * create a new branch and then
     * merge it. (Do not modify
     * the master branch)
     */
    private void eventListeners(){
        btnClear.setOnClickListener(view -> {
            clearCounter++;
            switch (clearCounter){
                case 1: {
                    results.setText("");
                    break;
                }
                case 2: {
                    isOperatorPresent = false; //clear operator
                    results.setText(""); //clear calc text
                    resultsPreview.setText(""); //clear calc preview
                    memory = 0.0D; //clear memory
                    break;
                }
                default: {
                    clearCounter = 0;
                    break;
                }
            }

        });
        btnBackSpace.setOnClickListener(view -> {
            try {
                Double.parseDouble(results.getText().toString());
                String currentStr = results.getText().toString();
                String modStr = currentStr.substring(1);
                results.setText(modStr);
                String prev = resultsPreview.getText().toString().substring(1);
                resultsPreview.setText(prev);
            }
            catch(Exception e){
                results.setText("");
                resultsPreview.setText("");
            }
        });
        btnPercentage.setOnClickListener(view -> {
            try {
                String strPrev = resultsPreview.getText().toString();

                resultsPreview.setText(strPrev + "%");
            }
            catch(Exception e){
                results.setText("Not a double");
            }
        });
        btnDivide.setOnClickListener(view -> {
            try {
                isOperatorPresent = true;
                String strPrev = resultsPreview.getText().toString();
                resultsPreview.setText(strPrev + " / ");
            }
            catch(Exception e){
                results.setText("Enter a Number first");
            }
        });
        btnMultiply.setOnClickListener(view -> {
            try {
                isOperatorPresent = true;
                String strPrev = resultsPreview.getText().toString();
                resultsPreview.setText(strPrev + " * ");
            }
            catch(Exception e){
                results.setText("Enter a Number first");
            }
        });
        btnAdd.setOnClickListener(view -> {
            try {
                isOperatorPresent = true;
                String str = results.getText().toString();
                String strPrev = resultsPreview.getText().toString();
                resultsPreview.setText(strPrev + " + ");
            }
            catch(Exception e){
                results.setText("Enter a Number first");
            }
        });
        btnSubstract.setOnClickListener(view -> {
            try {
                isOperatorPresent = true;
                String str = results.getText().toString();
                String strPrev = resultsPreview.getText().toString();
                resultsPreview.setText(strPrev + " - ");
            }
            catch(Exception e){
                results.setText("Enter a Number first");
            }
        });
        btnExponent.setOnClickListener(view -> {
            try {
                isOperatorPresent = true;
                String str = results.getText().toString();
                String strPrev = resultsPreview.getText().toString();
                resultsPreview.setText("e^("+strPrev+")");
            }
            catch(Exception e){
                results.setText("Enter a Number first");
            }
        });
        btn0.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "0";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
                results.setText("");isOperatorPresent=false;
            String str = results.getText().toString();
            if(str.equals(""))
            {
                results.setText("0");
            }
            else {
                str = str + "0";
                results.setText(str);
            }
        });
        btn1.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "1";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
            {
                results.setText("");isOperatorPresent=false;
            }

            String str = results.getText().toString();

            if(str.equals(""))
            {
                results.setText("1");
            }
            else {
                str = str + "1";
                results.setText(str);
            }
        });
        btn2.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "2";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
            {
                results.setText("");isOperatorPresent=false;
            }

            String str = results.getText().toString();
            if(str.equals(""))
            {
                results.setText("2");

            }
            else {
                str = str + "2";
                results.setText(str);
            }
        });
        btn3.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "3";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
                results.setText("");isOperatorPresent=false;
            String str = results.getText().toString();

            if(str.equals(""))
            {
                results.setText("3");
            }
            else {
                str = str + "3";
                results.setText(str);

            }
        });
        btn4.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "4";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
                results.setText("");isOperatorPresent=false;
            String str = results.getText().toString();

            if(str.equals(""))
            {
                results.setText("4");

            }
            else {
                str = str + "4";
                results.setText(str);

            }
        });
        btn5.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "5";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
                results.setText("");isOperatorPresent=false;

            String str = results.getText().toString();

            if(str.equals(""))
            {
                results.setText("5");

            }
            else {
                str = str + "5";
                results.setText(str);

            }
        });
        btn6.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "6";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
                results.setText("");isOperatorPresent=false;

            String str = results.getText().toString();

            if(str.equals(""))
            {
                results.setText("6");

            }
            else {
                str = str + "6";
                results.setText(str);

            }
        });
        btn7.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "7";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
                results.setText("");isOperatorPresent=false;
            String str = results.getText().toString();

            if(str.equals(""))
            {
                results.setText("7");

            }
            else {
                str = str + "7";
                results.setText(str);

            }
        });
        btn8.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "8";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
                results.setText("");isOperatorPresent=false;
            String str = results.getText().toString();

            if(str.equals(""))
            {
                results.setText("8");

            }
            else {
                str = str + "8";
                results.setText(str);

            }
        });
        btn9.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "9";
            resultsPreview.setText(strPrev);
            if(isOperatorPresent)
                results.setText("");isOperatorPresent=false;
            String str = results.getText().toString();

            if(str.equals(""))
            {
                results.setText("9");
            }
            else {
                str = str + "9";
                results.setText(str);
            }
        });
        btnPi.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            strPrev = strPrev + "\u03C0";
            resultsPreview.setText(strPrev);
            if (isOperatorPresent)
                results.setText("");isOperatorPresent=false;
            String str = results.getText().toString();

            if(str.equals(""))
                results.setText("\u03C0");
            else {
                str = str + "\u03C0";
                results.setText(str);
            }
        });
        btnDecimal.setOnClickListener(view -> {
            String str = results.getText().toString();
            String strPrev = resultsPreview.getText().toString();
            if(str.contains(".")){}
            else {
                strPrev = strPrev + ".";
                resultsPreview.setText(strPrev);
                if(str.equals("")) {
                    results.setText("0.");
                }
                else {
                    str = str + ".";
                    results.setText(str);
                }
            }
        });
        btnMadd.setOnClickListener(view -> {
            try{
                if(results.getText().toString().equals("\u03C0")) {
                    memory+=Math.PI;
                }
                else
                {
                    Double currentValue = Double.parseDouble(results.getText().toString());
                    memory += currentValue;
                }
            }
            catch(Exception e)
            {
                System.out.println("No decimal found");
            }
        });
        btnMsub.setOnClickListener(view -> {
            try{
                Double currentValue = Double.parseDouble(results.getText().toString());
                memory -= currentValue;
            }
            catch(Exception e)
            {
                System.out.println("No decimal found");
            }
        });
        btnMr.setOnClickListener(view -> {
            String strPrev = resultsPreview.getText().toString();
            if(memory==Math.PI)
            {
                resultsPreview.setText(strPrev + " \u03C0");
                results.setText("\u03C0" + "");
            }
            else {
                resultsPreview.setText(strPrev + " " + memory);
                results.setText(memory + "");
            }
        });
        btnMclear.setOnClickListener(view -> memory = 0.0);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(results.getText().toString().equals(""))
                {
                    results.setText("");
                }
                else {
                    ExpressionSolver solver = new ExpressionSolver(resultsPreview.getText().toString());
                    double answer = solver.evaluate();
                    results.setText(answer+"");
                    resultsPreview.setText(answer+"");
                }
            }
        });
    }

    /**
     * Listens to the screen orientation and
     * selects the activities accordingly
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main_landscape);
            Toast.makeText(MainActivity.this, "Landscape", Toast.LENGTH_SHORT).show();
            initializeDesignComponents();
            eventListeners();
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main);
            Toast.makeText(MainActivity.this, "Potrait", Toast.LENGTH_SHORT).show();
            initializeDesignComponents();
            eventListeners();
        }
    }

    private void initializeDesignComponents(){
        //Component Initialization
        try {
            resultsArea = findViewById(R.id.resultArea);
            functionsArea = findViewById(R.id.functionArea);

            results = findViewById(R.id.results);
            resultsPreview = findViewById(R.id.resultPreview);
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
            btnPi = findViewById(R.id.btnPi);

            btnMadd = findViewById(R.id.btnMadd);
            btnMsub = findViewById(R.id.btnMsub);
            btnMr = findViewById(R.id.btnMr);
            btnMclear = findViewById(R.id.btnMclear);
            btnExponent = findViewById(R.id.btnExponent);
        }
        catch(Exception e)
        {
            System.out.println("Component Init failed");
            e.printStackTrace();
        }
    }
}