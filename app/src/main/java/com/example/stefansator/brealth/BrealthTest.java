package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BrealthTest extends AppCompatActivity {
    Intent testTasks[];
    int tasknr;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthtest);

        tasknr = 0;
        testTasks = new Intent[3];
        testTasks[0] = new Intent(BrealthTest.this, RechnenTask.class);
        testTasks[0].putExtra("limit", 1);
        testTasks[1] = new Intent(BrealthTest.this, MemoryTask.class);
        testTasks[2] = new Intent(BrealthTest.this, YogaMemoryTask.class);

        BrealthTest.this.startActivities(testTasks);
    }

    /* @Override
    public void onResume() {
        super.onResume();

        /if (tasknr == 0) return;
        if (tasknr >= testTasks.length) return;

        tasknr = tasknr + 1;
        BrealthTest.this.startActivity(testTasks[tasknr]);
    } */
}
