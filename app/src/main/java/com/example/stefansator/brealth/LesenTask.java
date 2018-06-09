package com.example.stefansator.brealth;

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
    private RelativeLayout rl;
    private ScrollingTextView tv;
    private Book book;
    private long startZeit, endZeit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesen);

        rl = (RelativeLayout) findViewById(R.id.lesen_layout);
        tv = new ScrollingTextView(getApplicationContext(), 1.2f);

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

        Intent finishscreenIntent = new Intent(LesenTask.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", bearbeitungsdauer);
        finishscreenIntent.putExtra("rating", bewertung);
        LesenTask.this.startActivity(finishscreenIntent);
        LesenTask.this.finish();
    }

    private int RateThePlayer(long duration) {
        long durationInSeconds = duration / 1000;
        GameRater gameRater = new LeseRater(durationInSeconds);
        return gameRater.getRating();
    }
}
