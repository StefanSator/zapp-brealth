package com.example.stefansator.brealth;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


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
