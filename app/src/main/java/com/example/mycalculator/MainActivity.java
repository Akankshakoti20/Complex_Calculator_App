package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    private Button zero, one, two, three, four, five, six, seven, eight, nine, add, mul, sub, div, brackets, clear, equal, dot, percentage;
    private ImageButton backspace;
    private TextView tvinput, tvout;
    private String process;
    private boolean checkBracket;
    private String finalResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = findViewById(R.id.button0);
        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        add = findViewById(R.id.buttonaddition);
        sub = findViewById(R.id.buttonsubtraction);
        mul = findViewById(R.id.buttonmultiplication);
        div = findViewById(R.id.buttondivision);
        percentage = findViewById(R.id.buttonmodulus);
        dot = findViewById(R.id.buttondecimalpt);
        brackets = findViewById(R.id.buttonbracket);
        clear = findViewById(R.id.buttonclear);
        equal = findViewById(R.id.buttonequal);
        clear = findViewById(R.id.buttonclear);
        backspace = findViewById(R.id.buttonback);
        tvinput = findViewById(R.id.textView);
        tvout = findViewById(R.id.textView2);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvinput.setText("");
                tvout.setText("");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "0");

            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "1");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "2");

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "3");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "4");

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "5");

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "6");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "7");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "8");

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "9");

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "+");

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "-");

            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "×");

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "÷");

            }
        });


        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + "%");

            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvinput.getText().toString();
                tvinput.setText(process + ".");

            }
        });
        brackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBracket == true) {
                    process = tvinput.getText().toString();
                    tvinput.setText(process + ")");
                    checkBracket = false;
                } else {
                    process = tvinput.getText().toString();
                    tvinput.setText(process + "(");
                    checkBracket = true;
                }
            }


        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process = tvinput.getText().toString();
                process = process.replaceAll("×", "*");
                process = process.replaceAll("÷", "/");
                process = process.replaceAll("%", "/100");


                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);


                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();

                } catch (Exception e) {
                    finalResult = "0";
                }
                tvout.setText(finalResult);
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!process.equals("")) {
                    process = tvinput.getText().toString();
                    if (process.length() > 0) {
                        process = process.substring(0, process.length() - 1);
                        tvinput.setText(process);
                    }
                }
            }
        });
    }
}


