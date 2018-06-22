package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class BrealthTest extends AppCompatActivity {
    private TestScore testScore;
    private Intent testTasks[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthtest);

        testTasks = new Intent[3];
        testTasks[0] = new Intent(BrealthTest.this, VocableRunTask.class);
        testTasks[1] = new Intent(BrealthTest.this, YogaMemoryTask.class);
        testTasks[2] = new Intent(BrealthTest.this, EffortCalculatingTask.class);
        testTasks[2].putExtra("limit", 20);

        BrealthTest.this.startActivities(testTasks);
    }

    public void showTestResults(View view) {
        testScore = new TestScore(BrealthTest.this, "effortcalulating");

        Toast rightToast = Toast.makeText(getApplicationContext(), "Attempts: "+ testScore.loadAttempts(), Toast.LENGTH_SHORT);
        rightToast.show();
    }
}
