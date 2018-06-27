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
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int i = 0 ; i < arrayAttempts.length ; i++) {
            barEntries.add(new BarEntry(i,arrayAttempts[i]));
        }
        BarDataSet barDataSet = new BarDataSet(barEntries,"Versuche");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.YELLOW);
        barDataSet.setValueTextSize(10f);

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.8f);
        barDataSet.setValueTextColor(Color.YELLOW);

        attemptGraph.getDescription().setEnabled(false);
        attemptGraph.setTouchEnabled(false);
        attemptGraph.setData(data);

        XAxis xAxis = attemptGraph.getXAxis();
        xAxis.setTextColor(Color.YELLOW);
        xAxis.setValueFormatter(new MyXAxisValueFormatter(taskString));
        xAxis.setGranularityEnabled(true);

        YAxis yAxisLeft = attemptGraph.getAxisLeft();
        yAxisLeft.setTextColor(Color.YELLOW);
        yAxisLeft.setAxisMinimum(0f);
        YAxis yAxisRight = attemptGraph.getAxisRight();
        yAxisRight.setTextColor(Color.YELLOW);
        yAxisRight.setAxisMinimum(0f);

        Legend legend = attemptGraph.getLegend();
        legend.setTextColor(Color.YELLOW);
        legend.setTextSize(20f);
    }

    private void makeDurationGraph() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for (int i = 0 ; i < arrayDurations.length ; i++) {
           barEntries.add(new BarEntry(i,arrayDurations[i]));
        }

        BarDataSet barDataSet = new BarDataSet(barEntries,"Dauer in Sekunden");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.YELLOW);
        barDataSet.setValueTextSize(10f);

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.8f);

        durationGraph.getDescription().setEnabled(false);
        durationGraph.setTouchEnabled(false);
        durationGraph.setData(data);

        XAxis xAxis = durationGraph.getXAxis();
        xAxis.setTextColor(Color.YELLOW);
        xAxis.setValueFormatter(new MyXAxisValueFormatter(taskString));
        xAxis.setGranularityEnabled(true);

        YAxis yAxisLeft = durationGraph.getAxisLeft();
        yAxisLeft.setTextColor(Color.YELLOW);
        yAxisLeft.setAxisMinimum(0f);
        YAxis yAxisRight = durationGraph.getAxisRight();
        yAxisRight.setTextColor(Color.YELLOW);
        yAxisRight.setAxisMinimum(0f);

        Legend legend = durationGraph.getLegend();
        legend.setTextColor(Color.YELLOW);
        legend.setTextSize(20f);
    }

    public class MyXAxisValueFormatter implements IAxisValueFormatter {

        private String[] mValues;

        public MyXAxisValueFormatter(String[] values) {
            this.mValues = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int) value];
        }
    }
}
