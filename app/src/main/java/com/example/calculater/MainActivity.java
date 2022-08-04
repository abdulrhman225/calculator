package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    EditText tv_calculation;

    TextView tv_result;

    Button btn_clear, btn_div, btn_multi, btn_deleteOneChar, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_add, btn_sub, btn_equal, btn_dote, btn_openBracket, btn_closeBracket, btn_sqrt, btn_cubRt;
    Button btn_SqPow, btn_cubPow, btn_sin, btn_Cos, btn_tan, btn_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        tv_calculation = findViewById(R.id.main_calculation);
        btn_0 = findViewById(R.id.main_btn_zero);
        btn_1 = findViewById(R.id.main_btn_1);
        btn_2 = findViewById(R.id.main_btn_2);
        btn_3 = findViewById(R.id.main_btn_3);
        btn_4 = findViewById(R.id.main_btn_4);
        btn_5 = findViewById(R.id.main_btn_5);
        btn_6 = findViewById(R.id.main_btn_6);
        btn_7 = findViewById(R.id.main_btn_7);
        btn_8 = findViewById(R.id.main_btn_8);
        btn_9 = findViewById(R.id.main_btn_9);
        btn_add = findViewById(R.id.main_btn_add);
        btn_sub = findViewById(R.id.main_btn_sub);
        btn_div = findViewById(R.id.main_btn_div);
        btn_multi = findViewById(R.id.main_btn_multiplication);
        btn_equal = findViewById(R.id.main_btn_equal);
        btn_clear = findViewById(R.id.main_btn_deleteAll);
        btn_deleteOneChar = findViewById(R.id.main_btn_deleteOneChar);
        btn_dote = findViewById(R.id.main_btn_dote);
        btn_openBracket = findViewById(R.id.main_btn_openBracket);
        btn_closeBracket = findViewById(R.id.main_btn_closeBracket);
        btn_sqrt = findViewById(R.id.main_btn_sqrt);
        btn_cubRt = findViewById(R.id.main_btn_CbRoot);
        btn_SqPow = findViewById(R.id.main_btn_PwSq);
        btn_cubPow = findViewById(R.id.main_btn_PwCb);
        btn_sin = findViewById(R.id.main_btn_sin);
        btn_Cos = findViewById(R.id.main_btn_Cos);
        btn_tan = findViewById(R.id.main_btn_tan);
        btn_log = findViewById(R.id.main_btn_log);


        tv_calculation.setShowSoftInputOnFocus(false);
        tv_calculation.setSelection(tv_calculation.length());


        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_0.getText().toString());
            }
        });


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_1.getText().toString());
            }
        });


        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_2.getText().toString());

            }
        });


        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_3.getText().toString());

            }
        });


        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_4.getText().toString());

            }
        });


        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_5.getText().toString());

            }
        });


        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_6.getText().toString());

            }
        });


        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_7.getText().toString());

            }
        });


        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_8.getText().toString());

            }
        });


        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_9.getText().toString());

            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_add.getText().toString());

            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_sub.getText().toString());

            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("*");

            }
        });


        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("/");

            }
        });


        btn_dote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_dote.getText().toString());

            }
        });

        btn_openBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_openBracket.getText().toString());
            }
        });

        btn_closeBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(btn_closeBracket.getText().toString());
            }
        });


        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_calculation.setText("");
            }
        });

        btn_deleteOneChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selection = tv_calculation.getSelectionStart();
                int strLen = tv_calculation.length();

                if (selection != 0 && strLen != 0) {
                    SpannableStringBuilder sp = (SpannableStringBuilder) tv_calculation.getText();
                    sp.replace(selection - 1, selection, "");
                    tv_calculation.setText(sp);
                    tv_calculation.setSelection(selection - 1);

                }

            }
        });


        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = tv_calculation.getText().toString();

                Expression ex = new Expression(result);
                tv_calculation.setText(String.valueOf(ex.calculate()));
                tv_calculation.setSelection(tv_calculation.length());
            }
        });


    }

    public void updateText(String newText) {
        String oldText = tv_calculation.getText().toString();
        int selection = tv_calculation.getSelectionStart();
        String leftS = oldText.substring(0, selection);
        String RightS = oldText.substring(selection);
        tv_calculation.setText(String.format("%s%s%s", leftS, newText, RightS));
        tv_calculation.setSelection(selection + newText.length());
    }


    public void cos(View view) {
        updateText("cos(");

    }

    public void sine(View view) {
        updateText("sin(");
    }

    public void tan(View view) {
        updateText("tan(");
    }

    public void sqrt(View view) {
        updateText("sqrt(");
    }

    public void abs(View view) {
        updateText("abs(");
    }

    public void sqPow(View view) {
        updateText("^(2)");
    }

    public void power(View view) {
        updateText("^(");
    }

    public void log(View view) {
        updateText("log10(");
    }

}
