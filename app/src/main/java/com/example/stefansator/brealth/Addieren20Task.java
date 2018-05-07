package com.example.stefansator.brealth;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by stefansator on 06.05.18.
 */

public class Addieren20Task extends AppCompatActivity {
    private ImageSwitcher switcher;
    private TextView aufgabe;
    private EditText ergebnisfeld;
    private static final int  LIMIT = 20;
    private int aufgabeNr = 0;
    private Additionsaufgabe rechenaufgaben[] = new Additionsaufgabe[10];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnen);

        /* Initialize Array with Addition Tasks */
        for (int i = 0 ; i < 10 ; i++) {
            rechenaufgaben[i] = new Additionsaufgabe(LIMIT);
        }

        aufgabe = findViewById(R.id.rechenaufgabe);
        aufgabe.setText(rechenaufgaben[aufgabeNr].toString());

        switcher = findViewById(R.id.ImageSwitcher1);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(Addieren20Task.this, android.R.anim.fade_in);
        in.setDuration(3000);
        switcher.setInAnimation(in);
        Animation out = AnimationUtils.loadAnimation(Addieren20Task.this, android.R.anim.fade_out);
        out.setDuration(3000);
        switcher.setOutAnimation(out);
    }

    /* public void showIfRight(View view) throws InterruptedException {
        switcher.setImageResource(R.drawable.check);
        aufgabe.setText("1 + 1 =");
    } */

    public void showIfRight(View view) {
        if (aufgabeNr == 10) return; /* Prüfe ob 10 Aufgaben bereits vorbeit */

        ergebnisfeld = findViewById(R.id.rechenaufgabe_answer);
        Integer ergebnis = Integer.parseInt(ergebnisfeld.getText().toString());

        /* Control if result is right */
        if (rechenaufgaben[aufgabeNr].getErgebnis() == ergebnis) {
            switcher.setImageResource(R.drawable.check);
            aufgabeNr++;
            aufgabe.setText(rechenaufgaben[aufgabeNr].toString());
        } else {
            /* do nothing */
        }
    }
}
