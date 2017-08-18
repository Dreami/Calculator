package com.example.maple.calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.maple.calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // ------ NUMBERS ------

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "0");
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "1");
            }
        });


        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "2");
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "3");
            }
        });

        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "4");
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "5");
            }
        });

        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "6");
            }
        });

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "7");
            }
        });

        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "8");
            }
        });

        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "9");
            }
        });

        binding.btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + ".");
            }
        });

        // ------ OPERATORS ------

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.textView2.setText(decimalFormat.format(valueOne) + " + ");
                binding.textView.setText(null);
            }
        });

        binding.btnSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.textView2.setText(decimalFormat.format(valueOne) + " - ");
                binding.textView.setText(null);
            }
        });

        binding.btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.textView2.setText(decimalFormat.format(valueOne) + " * ");
                binding.textView.setText(null);
            }
        });

        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.textView2.setText(decimalFormat.format(valueOne) + " / ");
                binding.textView.setText(null);
            }
        });

        binding.btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = '0';
                binding.textView2.setText(binding.textView2.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
            }
        });


        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                binding.textView.setText("");
                binding.textView2.setText("");
            }
        });

        binding.btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            if (binding.textView.getText().length() > 0) {
                CharSequence currentText = binding.textView.getText();
                binding.textView.setText(currentText.subSequence(0, currentText.length() - 1));
            }
        }
        });
    }

    private void computeCalculation() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.textView.getText().toString());
            binding.textView.setText(null);

            switch(CURRENT_ACTION) {
                case ADDITION :
                    valueOne = this.valueOne + valueTwo;
                    break;
                case SUBTRACTION :
                    valueOne = this.valueOne - valueTwo;
                    break;
                case MULTIPLICATION :
                    valueOne = this.valueOne * valueTwo;
                    break;
                case DIVISION :
                    valueOne = this.valueOne / valueTwo;
                    break;
            }
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.textView.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
