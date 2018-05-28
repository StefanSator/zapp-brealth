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

        Intent finishscreenIntent = new Intent(LesenTask.this, TaskEndscreen.class);
        finishscreenIntent.putExtra("dauer", bearbeitungsdauer);
        LesenTask.this.startActivity(finishscreenIntent);
        LesenTask.this.finish();
    }
}
