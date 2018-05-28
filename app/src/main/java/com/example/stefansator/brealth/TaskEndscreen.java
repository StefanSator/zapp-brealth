package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by stefansator on 07.05.18.
 * Revised by stefansator on 28.05.18
 */

public class TaskEndscreen extends AppCompatActivity {
    private TextView dauerFeld;
    private TextView falschFeld;
    private long bearbeitungsDauer;
    private int falseCounter;
    private int bewertung;
    private LottieAnimationView stars[]; // Stars for Rating the Game

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnenendscreen);

        /* Initialize stars Array with LottieViews */
        stars = new LottieAnimationView[6];
        stars[0] = findViewById(R.id.zero_stars_rating);
        stars[1] = findViewById(R.id.one_stars_rating);
        stars[2] = findViewById(R.id.two_stars_rating);
        stars[3] = findViewById(R.id.three_stars_rating);
        stars[4] = findViewById(R.id.four_stars_rating);
        stars[5] = findViewById(R.id.five_stars_rating);

        /* Hide at beginning all Star Rating LottieViews */
        for (int i = 0 ; i < stars.length ; i++) {
            stars[0].setVisibility(View.INVISIBLE);
        }

        dauerFeld = findViewById(R.id.zeit_rechnen);
        falschFeld = findViewById(R.id.falschCounter_rechnenend);

        if (getIntent().hasExtra("dauer") == true && getIntent().hasExtra("falsch") == true) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            falseCounter = getIntent().getExtras().getInt("falsch");
            setDauerAndFalschFeld();
        } else if (getIntent().hasExtra("dauer") == true && getIntent().hasExtra("falsch") == false) {
            bearbeitungsDauer = getIntent().getExtras().getLong("dauer");
            setOnlyDauerFeld();
        } else {
            System.out.println("Error in RechnenEnd");
            TaskEndscreen.this.finish();
        }

        /* Show right Star Rating */
        setStarRating();
    }

    private void setDauerAndFalschFeld() {
        dauerFeld.setText("" + (bearbeitungsDauer/1000) + " s");
        falschFeld.setText("" + falseCounter);
    }

    private void setOnlyDauerFeld() {
        dauerFeld.setText("" + (bearbeitungsDauer/1000) + " s");
        TextView falschText = findViewById(R.id.falsch_rechnenend);
        falschText.setText("");
    }

    private void setStarRating() {
        if (getIntent().hasExtra("rating") == true) {
            setNumberOfStars();
        } else {
            stars[0].setVisibility(View.VISIBLE);
        }
    }

    private void setNumberOfStars() {
        bewertung = getIntent().getExtras().getInt("rating");

        switch (bewertung) {
            case 0:
                stars[0].setVisibility(View.VISIBLE);
            case 1:
                stars[1].setVisibility(View.VISIBLE);
            case 2:
                stars[2].setVisibility(View.VISIBLE);
            case 3:
                stars[3].setVisibility(View.VISIBLE);
            case 4:
                stars[4].setVisibility(View.VISIBLE);
            case 5:
                stars[5].setVisibility(View.VISIBLE);
            default:
                stars[0].setVisibility(View.VISIBLE);
        }
    }

    public void endResultScreen(View view) {
        TaskEndscreen.this.finish();
    }
}
