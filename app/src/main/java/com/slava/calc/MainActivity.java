package com.slava.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Button btnC, btnDiv, btnMult, btnBack, btn7, btn8, btn9, btnMin, btn4, btn5, btn6, btnPlus, btn1, btn2, btn3, btnBrack1, btn0, btnDot, btnBrack2, btnRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.myTextView);
        btnC = (Button) findViewById(R.id.btnC);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnBack = (Button) findViewById(R.id.btnBack);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnMin = (Button) findViewById(R.id.btnMin);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btnBrack1 = (Button) findViewById(R.id.btnBrack1);
        btn0 = (Button) findViewById(R.id.btn0);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnBrack2 = (Button) findViewById(R.id.btnBrack2);
        btnRes = (Button) findViewById(R.id.btnRes);

        View.OnClickListener pressBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnC:
                        myTextView.setText("");
                        break;
                    case R.id.btnDiv:
                        myTextView.setText(addOperator(myTextView.getText().toString(), '/'));
                        break;
                    case R.id.btnMult:
                        myTextView.setText(addOperator(myTextView.getText().toString(), '×'));
                        break;
                    case R.id.btnBack:
                        myTextView.setText(backSpace(myTextView.getText().toString()));
                        break;
                    case R.id.btn7:
                        myTextView.setText(myTextView.getText() + "7");
                        break;
                    case R.id.btn8:
                        myTextView.setText(myTextView.getText() + "8");
                        break;
                    case R.id.btn9:
                        myTextView.setText(myTextView.getText() + "9");
                        break;
                    case R.id.btnMin:
                        myTextView.setText(addOperator(myTextView.getText().toString(), '-'));
                        break;
                    case R.id.btn4:
                        myTextView.setText(myTextView.getText() + "4");
                        break;
                    case R.id.btn5:
                        myTextView.setText(myTextView.getText() + "5");
                        break;
                    case R.id.btn6:
                        myTextView.setText(myTextView.getText() + "6");
                        break;
                    case R.id.btnPlus:
                        myTextView.setText(addOperator(myTextView.getText().toString(), '+'));
                        break;
                    case R.id.btn1:
                        myTextView.setText(myTextView.getText() + "1");
                        break;
                    case R.id.btn2:
                        myTextView.setText(myTextView.getText() + "2");
                        break;
                    case R.id.btn3:
                        myTextView.setText(myTextView.getText() + "3");
                        break;
                    case R.id.btnBrack1:
                        myTextView.setText(myTextView.getText() + "(");
                        break;
                    case R.id.btn0:
                        myTextView.setText(myTextView.getText() + "0");
//                        myTextView.setText(addZero(myTextView.getText().toString()));
                        break;
                    case R.id.btnDot:
                        myTextView.setText(addDot(myTextView.getText().toString()));
                        break;
                    case R.id.btnBrack2:
                        myTextView.setText(addBrackets(myTextView.getText().toString()));
                        break;
                    case R.id.btnRes:
                        myTextView.setText(doEqual(myTextView.getText().toString()));
                        break;
                }
            }
        };
        btnC.setOnClickListener(pressBtn);
        btnDiv.setOnClickListener(pressBtn);
        btnMult.setOnClickListener(pressBtn);
        btnBack.setOnClickListener(pressBtn);
        btn7.setOnClickListener(pressBtn);
        btn8.setOnClickListener(pressBtn);
        btn9.setOnClickListener(pressBtn);
        btnMin.setOnClickListener(pressBtn);
        btn4.setOnClickListener(pressBtn);
        btn5.setOnClickListener(pressBtn);
        btn6.setOnClickListener(pressBtn);
        btnPlus.setOnClickListener(pressBtn);
        btn1.setOnClickListener(pressBtn);
        btn2.setOnClickListener(pressBtn);
        btn3.setOnClickListener(pressBtn);
        btnBrack1.setOnClickListener(pressBtn);
        btn0.setOnClickListener(pressBtn);
        btnDot.setOnClickListener(pressBtn);
        btnBrack2.setOnClickListener(pressBtn);
        btnRes.setOnClickListener(pressBtn);
    }

    private static String addOperator(String s, char c) {
        if ((s.length() > 0 && Character.isDigit(s.charAt(s.length() - 1))) || (s.length() > 0 && s.lastIndexOf(")") == s.length() - 1)) {
            switch (c) {
                case '/':
                    return s + " / ";
                case '×':
                    return s + " × ";
                case '+':
                    return s + " + ";
                case '-':
                    return s + " - ";
            }
        }
        return s;
    }

    private static String backSpace(String s) {
        if (s.length() > 0) {
            if (s.lastIndexOf(" ") == s.length() - 1)
                return s.substring(0, s.length() - 3);
            else
                return s.substring(0, s.length() - 1);
        }
        return s;
    }

/*    private static String addZero(String s) {
        if (s.length() == 0 || (s.length() == 1 && s.lastIndexOf("0") != s.length() - 1) || (s.lastIndexOf("0") != s.length() - 1 && s.lastIndexOf(" ") != s.length() - 2))
        return s + "0";
        return s;
    }*/

    private static String addDot(String s) {
        int numSpace = 0, numDot = 0;
        char c;
        if (s.length() > 0) {
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if (c == ' ')
                    numSpace = numSpace + 1;
                else if (c == '.')
                    numDot = numDot + 1;
            }
            if ((numDot == 0 && Character.isDigit(s.charAt(s.length() - 1))) || (numDot == numSpace / 2 && Character.isDigit(s.charAt(s.length() - 1))))
                return s + ".";
        }
        return s;
    }

    private static String addBrackets(String s) {
        int numBrackets = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                numBrackets = numBrackets + 1;
            } else if (c == ')')
                numBrackets = numBrackets - 1;
        }
        if (numBrackets > 0) {
            return s + ")";
        }
        return s;
    }

    private static String doEqual(String s) {
        if (s.length() > 0 && Character.isDigit(s.charAt(s.length() - 1)) || (s.length() > 0 && s.lastIndexOf(")") == s.length() - 1))
            return String.valueOf(Calculator.evaluate(s));
        return s;
    }
}


