package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class BrealthTest extends AppCompatActivity {
    private Intent testTasks[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthtest);

        testTasks = new Intent[3];
        testTasks[0] = new Intent(BrealthTest.this, LesenTask.class);
        testTasks[1] = new Intent(BrealthTest.this, YogaMemoryTask.class);
        testTasks[2] = new Intent(BrealthTest.this, EffortCalculatingTask.class);
        testTasks[2].putExtra("limit", 20);

        BrealthTest.this.startActivities(testTasks);
    }

    @Override
    public void onResume() {
        super.onResume();

        TestScore testScore = new TestScore();
        Toast rightToast = Toast.makeText(getApplicationContext(), "" + testScore.readTestAttempts(this, "EffortTest", "TEST_ATTEMPT_EFFORT") + ", " + testScore.readTestDuration(this, "EffortTest", "TEST_DURATION_EFFORT"), Toast.LENGTH_SHORT);
        rightToast.show();
    }

    public void showTestResults(View view) {

    }
}
