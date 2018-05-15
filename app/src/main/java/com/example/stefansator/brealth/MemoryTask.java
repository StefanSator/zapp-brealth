package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by StefanSator on 13.05.18.
 */

public class MemoryTask extends AppCompatActivity {
    MemKarten mem;
    ArrayList<String> cardStrings = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        mem = new MemKarten(12);
        cardStrings = mem.getKarten();
    }

    public void revealMemoryCard(View view) {
        TextView memoryText = findViewById(R.id.memory_card1);
        memoryText.setText(cardStrings.get(0));
    }
}
