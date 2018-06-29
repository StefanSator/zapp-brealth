package com.example.stefansator.brealth.uebungen.test;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.stefansator.brealth.R;
import com.github.mikephil.charting.charts.BarChart;


public class BrealthStatistik extends AppCompatActivity {
    BarChart durationGraph, attemptGraph;
    int arrayAttempts[];
    long arrayDurations[] ;
    private String [] taskString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthstatistik);

        attemptGraph = findViewById(R.id.attemptgraph);
        durationGraph= findViewById(R.id.durationgraph);
        taskString = new String[] {"Effort","Lesen","Vocable","Yoga"};

        getExtras();
    }

    private void getExtras() {
        arrayAttempts = getIntent().getExtras().getIntArray("test_attempts");
        arrayDurations = getIntent().getExtras().getLongArray("test_durations");
        makeGraph();
    }

    private void makeGraph() {
        makeAttemptGraph();
        makeDurationGraph();
    }

    private void makeAttemptGraph() {
        MyBarChart myAttemptGraph = new MyBarChart(taskString, attemptGraph, "Versuche");
        myAttemptGraph.intBarEntry(arrayAttempts);
        myAttemptGraph.createChart();
    }

    private void makeDurationGraph() {
        MyBarChart myDurationGraph = new MyBarChart(taskString, durationGraph, "Dauer in Sekunden");
        myDurationGraph.longBarEntry(arrayDurations);
        myDurationGraph.createChart();
    }
}
