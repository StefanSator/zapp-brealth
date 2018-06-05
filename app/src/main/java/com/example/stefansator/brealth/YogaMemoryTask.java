package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by StefanSator on 05.06.18.
 */

public class YogaMemoryTask extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogamemorytask);
    }

    public void revealYogaTask(View view) {
        ((ImageView) view).setImageResource(R.drawable.yoga_hund);
        ((ImageView) view).setBackgroundColor(getResources().getColor(R.color.white));
    }
}
