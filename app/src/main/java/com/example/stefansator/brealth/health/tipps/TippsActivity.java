package com.example.stefansator.brealth.health.tipps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stefansator.brealth.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TippsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipps);

        TextView tippsView = (TextView) findViewById(R.id.tippsView);
        String tippsText = readTextFromFile(R.raw.ernaehrungstipps);
        tippsView.setText(tippsText);
    }

    private String readTextFromFile(int file) {
        TextView instructionsView = (TextView) findViewById(R.id.instructionsView);
        InputStream inputStream = getResources().openRawResource(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer buffer = new StringBuffer();
        String str = "";

        if (inputStream != null) {
            try {
                while ((str = bufferedReader.readLine()) != null) {
                    buffer.append(str + "\n");
                }
            } catch (IOException e) {
                Toast.makeText(this, "Unerwarteter Fehler", Toast.LENGTH_LONG).show();
            }
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
