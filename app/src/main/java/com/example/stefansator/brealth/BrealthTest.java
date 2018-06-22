package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class BrealthTest extends AppCompatActivity {
    private Intent testTasks[];
    private int resultsAttempt[];
    private long resultsDuration[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthtest);

        testTasks = new Intent[4];
        testTasks[0] = new Intent(BrealthTest.this, YogaMemoryTask.class);
        testTasks[1] = new Intent(BrealthTest.this, VocableRunTask.class);
        testTasks[2] = new Intent(BrealthTest.this, LesenTask.class);
        testTasks[3] = new Intent(BrealthTest.this, EffortCalculatingTask.class);
        testTasks[3].putExtra("limit", 20);

        BrealthTest.this.startActivities(testTasks);
    }

    public void showTestResults(View view) {
        Intent statisticIntent = new Intent(BrealthTest.this, BrealthTestEndscreen.class);
        loadTestResults();
        statisticIntent.putExtra("test_attempts", resultsAttempt); // pass int array
        statisticIntent.putExtra("test_durations", resultsDuration); // pass long array
        BrealthTest.this.startActivity(statisticIntent);
    }

    private void loadTestResults() {
        TestScore testScore = new TestScore();
        resultsAttempt = new int[testTasks.length];
        resultsDuration = new long[testTasks.length];

        /* Load Attempt results of the Tasks from SharedPreferences File */
        resultsAttempt[0] = testScore.readTestAttempts(this, "EffortTest", "TEST_ATTEMPT_EFFORT");
        resultsAttempt[1] = testScore.readTestAttempts(this, "LesenTest", "TEST_ATTEMPT_LESEN");
        resultsAttempt[2] = testScore.readTestAttempts(this, "VocableRunTest", "TEST_ATTEMPT_VOCABLE");
        resultsAttempt[3] = testScore.readTestAttempts(this, "YogaTest", "TEST_ATTEMPT_YOGA");

        /* Load Duration results of the Tasks from SharedPreferences File */
        resultsDuration[0] = testScore.readTestDuration(this, "EffortTest", "TEST_DURATION_EFFORT");
        resultsDuration[1] = testScore.readTestDuration(this, "LesenTest", "TEST_DURATION_LESEN");
        resultsDuration[2] = testScore.readTestDuration(this, "VocableRunTest", "TEST_DURATION_VOCABLE");
        resultsDuration[3] = testScore.readTestDuration(this, "YogaTest", "TEST_DURATION_YOGA");
    }
}
