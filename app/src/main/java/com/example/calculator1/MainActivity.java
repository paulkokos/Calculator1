package com.example.calculator1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button div;
    private Button mul;
    private Button equal;
    private Button clear;
    private TextView TextViewResult;
    private TextView TextViewControl;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

//        Button zero = (Button) findViewById(R.id.btn7);
//        zero.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetTextI18n")
//            public void onClick(View v) {
//                Context context = getApplicationContext();
//                TextViewResult.setText(TextViewResult.getText().toString() + "7");
//                Toast.makeText(context,"Hello!", Toast.LENGTH_LONG).show();
//            }
//        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s0", TextViewControl.getText().toString()));
//                Toast.makeText(context,"Hello!", Toast.LENGTH_LONG).show();


            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s1", TextViewControl.getText().toString()));

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s2", TextViewControl.getText().toString()));

            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s3", TextViewControl.getText().toString()));

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s4", TextViewControl.getText().toString()));

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s5", TextViewControl.getText().toString()));

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s6", TextViewControl.getText().toString()));

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s7", TextViewControl.getText().toString()));

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s8", TextViewControl.getText().toString()));

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewControl.setText(String.format("%s9", TextViewControl.getText().toString()));

            }
        });
//
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                TextViewResult.setText(String.format("%s+", String.valueOf(val1)));
                TextViewControl.setText(null);

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                TextViewResult.setText(String.format("%s-", String.valueOf(val1)));
                TextViewControl.setText(null);

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                TextViewResult.setText(String.format("%s*", String.valueOf(val1)));
                TextViewControl.setText(null);

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                TextViewResult.setText(String.format("%s/", String.valueOf(val1)));
                TextViewControl.setText(null);

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    compute();
                    ACTION = EQU;
                    TextViewResult.setText(TextViewResult.getText().toString() + String.valueOf(val2) + "=" + String.valueOf((val1)));
                    TextViewControl.setText("0");
                } catch (Exception ex) {
                    Context context = getApplicationContext();
                TextViewResult.setText(0);
                Toast.makeText(context,"Hello!", Toast.LENGTH_LONG).show();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextViewControl.getText().length() > 0) {
                    CharSequence name = TextViewResult.getText().toString();
                    TextViewControl.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    TextViewControl.setText("0");
                    TextViewResult.setText("0");

                }
            }
        });


    }

    private void setupUIViews() {

        one = (Button) findViewById(R.id.Btn1);
        zero = (Button) findViewById(R.id.btn0);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        add = (Button) findViewById(R.id.btnadd);
        sub = (Button) findViewById(R.id.btnsub);
        mul = (Button) findViewById(R.id.btnmul);
        div = (Button) findViewById(R.id.btndiv);
        equal = (Button) findViewById(R.id.btnequal);
        TextViewControl = (TextView) findViewById(R.id.TextViewControl);
        TextViewResult = (TextView) findViewById(R.id.TextViewResult);
        clear = (Button) findViewById(R.id.btnclear);

    }

    private void compute() {

        if (!Double.isNaN(val1) || !Double.isNaN(val2)) {
            val2 = Double.parseDouble(TextViewControl.getText().toString());
//            try {
            switch (ACTION) {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
//            if (Double.isNaN(val1)){
//                Context context = getApplicationContext();
//                TextViewResult.setText(0);
//                Toast.makeText(context,"Hello!", Toast.LENGTH_LONG).show();
//
//            }

//            } catch (Exception ex) {
//                Context context = getApplicationContext();
//                TextViewResult.setText(0);
//                Toast.makeText(context,"Hello!", Toast.LENGTH_LONG).show();
//            }

        } else {
            val1 = Double.parseDouble(TextViewControl.getText().toString());
        }

    }

}
