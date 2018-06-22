package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.stefansator.brealth.R;

/**
 * Created by StefanSator on 22.06.18.
 */

public class BrealthTestEndscreen extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthtest_endscreen);

        showExtras();
    }

    private void showExtras() {
        int arrayAttempts[] = getIntent().getExtras().getIntArray("test_attempts");
        long arrayDurations[] = getIntent().getExtras().getLongArray("test_durations");
        for (int i = 0 ; i < arrayAttempts.length ; i++) {
            Toast attemptsToast = Toast.makeText(getApplicationContext(), "" + arrayAttempts[i], Toast.LENGTH_SHORT);
            attemptsToast.show();
        }

        for (int i = 0 ; i < arrayDurations.length ; i++) {
            Toast durationsToast = Toast.makeText(getApplicationContext(), "" + arrayDurations[i], Toast.LENGTH_SHORT);
            durationsToast.show();
        }
    }
}
