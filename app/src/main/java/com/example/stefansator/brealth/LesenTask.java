package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by stefansator on 20.05.18.
 * Revised by stefansator on 09.06.18
 */

public class LesenTask extends AppCompatActivity {
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;
    private RelativeLayout rl;
    private ScrollingTextView tv;
    private Book book;
    private long startZeit, endZeit;
    private String difficulty;
    private float animationSpeed;
    private static final boolean wipeHighscore = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesen);

        createDifficultyDialog();
    }

    private void startReadingGame() {
        rl = (RelativeLayout) findViewById(R.id.lesen_layout);
        tv = new ScrollingTextView(getApplicationContext(), animationSpeed);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        tv.setLayoutParams(lp);

        startZeit = System.currentTimeMillis();
        book = new Book();
        try {
            ReadTextFromFile(book.getBook());
        } catch (IOException ex) {
            Toast.makeText(getApplicationContext(), "Problems: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void ReadTextFromFile(int id) throws IOException {
        String str = "";
        StringBuffer buf = new StringBuffer();
        InputStream is = LesenTask.this.getResources().openRawResource(id);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is != null) {
            while ((str = reader.readLine()) != null) {
                buf.append(str + "\n");
            }
        }
        is.close();

        tv.setText(buf.toString());
        tv.setTextColor(Color.parseColor("#FFFE19"));
        tv.setTextSize(36.0f);

        rl.addView(tv);
    }

    public void endBookReading(View view) {
        endZeit = System.currentTimeMillis();
        long bearbeitungsdauer = endZeit - startZeit;
        int bewertung = RateThePlayer(bearbeitungsdauer);

        Highscore highscore = new Highscore(this,bearbeitungsdauer,bewertung,"lesen");
        boolean isNewHighscore = highscore.isNewHighscoreLesen();
        highscore.deleteHighscore(wipeHighscore);

        Intent finishscreenIntent = new Intent(LesenTask.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", bearbeitungsdauer);
        finishscreenIntent.putExtra("rating", bewertung);
        finishscreenIntent.putExtra("highscore", isNewHighscore);
        LesenTask.this.startActivity(finishscreenIntent);
        LesenTask.this.finish();
    }

    private int RateThePlayer(long duration) {
        long durationInSeconds = duration / 1000;
        GameRater gameRater = new LeseRater(durationInSeconds, difficulty);
        return gameRater.getRating();
    }

    private void createDifficultyDialog() {
        dlgBuilder = new AlertDialog.Builder(LesenTask.this);
        dlgBuilder.setTitle("Schwierigkeitsgrad");
        dlgBuilder.setMessage("Wählen Sie Ihren gewünschten Schwierigkeitsgrad");
        dlgBuilder.setCancelable(false);
        dlgBuilder.setPositiveButton("Schwer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                difficulty = "schwer";
                animationSpeed = 3.0f;
                startReadingGame();
            }
        });

        dlgBuilder.setNeutralButton("Leicht", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                difficulty = "leicht";
                animationSpeed = 6.5f;
                startReadingGame();
            }
        });

        dlgBuilder.setNegativeButton("Normal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                difficulty = "normal";
                animationSpeed = 5.0f;
                startReadingGame();
            }
        });

        alert = dlgBuilder.create();
        alert.show();
    }
}
