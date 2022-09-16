package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculater.databinding.MainActivityBinding;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {



    MainActivityBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.mainCalculation.setShowSoftInputOnFocus(false);
        binding.mainCalculation.setSelection(binding.mainCalculation.length());


        binding.mainBtnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtnZero.getText().toString());
            }
        });


        binding.mainBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn1.getText().toString());
            }
        });


        binding.mainBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn2.getText().toString());

            }
        });


        binding.mainBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn3.getText().toString());

            }
        });


        binding.mainBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn4.getText().toString());

            }
        });


        binding.mainBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn5.getText().toString());

            }
        });


        binding.mainBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn6.getText().toString());

            }
        });


        binding.mainBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn7.getText().toString());

            }
        });


        binding.mainBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn8.getText().toString());

            }
        });


        binding.mainBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtn9.getText().toString());

            }
        });

        binding.mainBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtnAdd.getText().toString());

            }
        });

        binding.mainBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtnSub.getText().toString());

            }
        });

        binding.mainBtnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("×");

            }
        });


        binding.mainBtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText("÷");

            }
        });


        binding.mainBtnDote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtnDote.getText().toString());

            }
        });

        binding.mainBtnOpenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtnOpenBracket.getText().toString());
            }
        });

        binding.mainBtnCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText(binding.mainBtnCloseBracket.getText().toString());
            }
        });


        binding.mainBtnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.mainCalculation.setText("");
            }
        });

        binding.mainBtnDeleteOneChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selection = binding.mainCalculation.getSelectionStart();
                int strLen = binding.mainCalculation.length();

                if (selection != 0 && strLen != 0) {
                    SpannableStringBuilder sp = (SpannableStringBuilder) binding.mainCalculation.getText();
                    sp.replace(selection - 1, selection, "");
                    binding.mainCalculation.setText(sp);
                    binding.mainCalculation.setSelection(selection - 1);

                }

            }
        });


        binding.mainBtnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = binding.mainCalculation.getText().toString().
                        replaceAll("×","*").
                        replaceAll("÷","/");


                Expression ex = new Expression(result);
                binding.mainCalculation.setText(String.valueOf(ex.calculate()));
                binding.mainCalculation.setSelection(binding.mainCalculation.length());
            }
        });


    }

    public void updateText(String newText) {
        String oldText = binding.mainCalculation.getText().toString();
        int selection = binding.mainCalculation.getSelectionStart();
        String leftS = oldText.substring(0, selection);
        String RightS = oldText.substring(selection);
        binding.mainCalculation.setText(String.format("%s%s%s", leftS, newText, RightS));
        binding.mainCalculation.setSelection(selection + newText.length());
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
