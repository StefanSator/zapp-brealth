package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesen);
        try {
            ReadTextFromFile();
        } catch (IOException ex) {
            Toast.makeText(getApplicationContext(), "Problems: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void ReadTextFromFile() throws IOException {
        String str = "";
        StringBuffer buf = new StringBuffer();
        InputStream is = LesenTask.this.getResources().openRawResource(R.raw.texttest);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is != null) {
            while ((str = reader.readLine()) != null) {
                buf.append(str + "\n");
            }
        }
        is.close();
        TextView tv = (TextView)findViewById(R.id.lesetext);
        tv.setText(buf.toString());
    }
}
