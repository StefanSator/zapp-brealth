package com.example.stefansator.brealth;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class BMIActivity extends AppCompatActivity {
//    double height = 0;
//    EditText heightInput = null;
//    EditText weightInput = null;
    double height;
    double weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        final EditText heightInput = (EditText)findViewById(R.id.enterHeightText);
        final EditText weightInput = (EditText)findViewById(R.id.enterWeightText);

        //Workaround to enter floating point numbers with comma instead of dot
        heightInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    try {
                        height = Double.parseDouble(s.toString().replace(',', '.'));
//                        weight = Double.parseDouble(weightInput.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Eingabe fehlgeschlagen", Toast.LENGTH_LONG);
                    }
                }

            }
        });

        weightInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s != null && !weightInput.getText().toString().isEmpty()) {
                    weight = Double.parseDouble(weightInput.getText().toString());
                } else {
                    weight = 0.0;
                }
            }
        });

        Button calculateBMIButton = (Button)findViewById(R.id.calculateBMIButton);
        calculateBMIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmi = calculateBMI(height, weight);
                setBMIResult(bmi);
                String bmiClass = getBMIClass(bmi);
                setBMIClassResult(bmiClass);

                //hide keyboard after button click
                View view = BMIActivity.this.getCurrentFocus();
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
    }

    private double calculateBMI(double height, double weight) {
        double bmi = weight / (height*height);
        return bmi;
    }

    private void setBMIResult(double bmi) {
        TextView bmiResult = (TextView)findViewById(R.id.bmiResult);
        bmiResult.setText(String.format("%.2f", bmi));
    }

    private void setBMIClassResult(String bmiClass) {
        TextView bmiResult = (TextView)findViewById(R.id.bmiClassResult);
        bmiResult.setText(bmiClass);
    }


    private String getBMIClass(double bmi) {
        if(bmi < 16) {
            return "Starkes Untergewicht";
        } else if (bmi >= 16 && bmi < 17) {
            return "Mäßiges Untergewicht";
        } else if (bmi >= 17 && bmi < 18.5) {
            return "Leichtes Untergewicht";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normalgewicht";
        } else if (bmi >= 25 && bmi < 30) {
            return "Präadipositas";
        } else if (bmi >= 30 && bmi < 35) {
            return "Adipositas Grad I";
        } else if (bmi >= 35 && bmi < 40) {
            return "Adipositas Grad II";
        } else if (bmi >= 40) {
            return "Adipositas Grad III";
        }
        return null;
    }

}
