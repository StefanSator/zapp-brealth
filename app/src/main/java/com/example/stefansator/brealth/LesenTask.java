package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by stefansator on 20.05.18.
 */

public class LesenTask extends AppCompatActivity {
    private TextView tv;
    private Book book;
    private long startZeit, endZeit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesen);

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

        tv = (TextView) findViewById(R.id.lesetext);
        tv.setText(buf.toString());
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

    /* Rates your Skill in this particular Task */
    private int RateThePlayer(long duration) {
        long durationInSeconds = duration / 1000;
        if (durationInSeconds < 60) {
            return 5;
        } else if (durationInSeconds >= 60 && durationInSeconds < 120) {
            return 4;
        } else if (durationInSeconds >= 120 && durationInSeconds < 240) {
            return 3;
        } else if (durationInSeconds >= 240 && durationInSeconds < 360) {
            return 2;
        } else if (durationInSeconds >= 360 && durationInSeconds < 480) {
            return 1;
        } else {
            return 0;
        }
    }
}
