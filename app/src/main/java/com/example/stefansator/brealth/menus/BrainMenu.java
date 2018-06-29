package com.example.stefansator.brealth.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.uebungen.dailytask.BrainDailyMenu;

/**
 * Created by stefansator on 04.05.18.
 */

public class BrainMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brainmenu);
    }

    public void gotoBrainTasksMenu(View view) {
        Intent braintasksIntent = new Intent(BrainMenu.this, BrainTaskMenu.class);
        BrainMenu.this.startActivity(braintasksIntent);
    }

    public void gotoBrainDailyMenu(View view) {
        Intent dailyIntent = new Intent(BrainMenu.this, BrainDailyMenu.class);
        BrainMenu.this.startActivity(dailyIntent);
    }
}
