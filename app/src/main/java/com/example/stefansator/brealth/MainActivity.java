package com.example.stefansator.brealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoMainMenu(View view) {
        Intent intent = new Intent(MainActivity.this, MainMenu.class);
        MainActivity.this.startActivity(intent);
    }
}
