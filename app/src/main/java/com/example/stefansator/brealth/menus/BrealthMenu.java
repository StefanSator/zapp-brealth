package com.example.stefansator.brealth.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.uebungen.test.BrealthTest;

public class BrealthMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthmenu);
    }

    public void gotoTest(View view) {
        Intent testIntent = new Intent( BrealthMenu.this, BrealthTest.class);
        BrealthMenu.this.startActivity(testIntent);
    }

    public void gotoUebungen(View view) {
        Intent uebungenIntent = new Intent( BrealthMenu.this, BrealthUebungen.class);
        BrealthMenu.this.startActivity(uebungenIntent);
    }
}
