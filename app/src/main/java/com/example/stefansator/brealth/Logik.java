package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Logik extends AppCompatActivity{
    private ImageView firstSymbol,secondSymbol,thirdSymbol;
    private TextView firstRowResult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logik);

        firstSymbol = findViewById(R.id.logik_symbol1);
        secondSymbol = findViewById(R.id.logik_symbol2);
        thirdSymbol = findViewById(R.id.logik_symbol3);
        firstRowResult = findViewById(R.id.logik_firstRowResult);
        setInitialRows();
    }

    public void setInitialRows() {
        setRow();
    }

    public void setRows(View view) {
        setRow();
    }

    public void setRow() {
        int zahl;
        String firstResult;
        Random r = new Random();
        Random p = new Random();
        int mode = r.nextInt(3 - 1) + 1;

        switch (mode) {
            case 1:
                firstSymbol.setImageResource(R.drawable.circle);
                secondSymbol.setImageResource(R.drawable.circle);
                thirdSymbol.setImageResource(R.drawable.circle);
                break;
            case 2:
                firstSymbol.setImageResource(R.drawable.triangle);
                secondSymbol.setImageResource(R.drawable.triangle);
                thirdSymbol.setImageResource(R.drawable.triangle);
                break;
            default:
                break;
        }

        do {
            zahl = p.nextInt(50 - 1) + 1;
        } while( zahl%3 != 0 );

        firstResult = Integer.toString(zahl);
        firstRowResult.setText("= "+firstResult);
    }
}
