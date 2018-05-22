package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by stefansator on 05.05.18.
 */

public class BrainTaskMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braintaskmenu);
    }

    public void gotoTaskRechnen(View view) {
        Intent rechnenMenuIntent = new Intent(BrainTaskMenu.this, RechnenTaskMenu.class);
        BrainTaskMenu.this.startActivity(rechnenMenuIntent);
    }

    public void gotoTaskMemory(View view) {
        Intent memoryIntent = new Intent(BrainTaskMenu.this, MemoryTask.class);
        BrainTaskMenu.this.startActivity(memoryIntent);

    }

    public void gotoTaskFarben(View view) {
        Intent farbenMenuIntent = new Intent(BrainTaskMenu.this, FarbenTaskMenu.class);
        BrainTaskMenu.this.startActivity(farbenMenuIntent);
    }
}
