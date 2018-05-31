package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BrealthUebungen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthuebungen);
    }

    public void gotoEffortCalculatingTask(View view) {
        Intent effortIntent = new Intent(BrealthUebungen.this, EffortCalculatingTask.class);
        effortIntent.putExtra("limit", 20);
        BrealthUebungen.this.startActivity(effortIntent);
    }
}
