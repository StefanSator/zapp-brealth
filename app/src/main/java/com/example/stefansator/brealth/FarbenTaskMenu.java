package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FarbenTaskMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farbentaskmenu);
    }

    public void gotoEasyMode(View view) {
        Intent farbenModeIntent = new Intent(FarbenTaskMenu.this, FarbenEasyMode.class);
        FarbenTaskMenu.this.startActivity(farbenModeIntent);
    }

    public void gotoHardMode(View view) {
        Intent farbenModeIntent = new Intent(FarbenTaskMenu.this, FarbenHardMode.class);
        FarbenTaskMenu.this.startActivity(farbenModeIntent);
    }
}
