package com.example.stefansator.brealth.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.stefansator.brealth.R;

/**
 * Created by stefansator on 04.05.18.
 */

public class MainMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }

    public void gotoBrainMenu(View view) {
        Intent brainIntent = new Intent(MainMenu.this, BrainMenu.class);
        MainMenu.this.startActivity(brainIntent);
    }

    public void gotoHealthMenu(View view) {
        Intent healthIntent = new Intent(MainMenu.this, HealthMenu.class);
        MainMenu.this.startActivity(healthIntent);
    }

    public void gotoBrealthMenu(View view) {
        Intent brealthIntent = new Intent(MainMenu.this, BrealthMenu.class);
        MainMenu.this.startActivity(brealthIntent);
    }
}
