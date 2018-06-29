package com.example.stefansator.brealth.uebungen.test;

import android.graphics.Color;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MyBarChart {
    private BarChart barChart;
    private String[] taskString;
    private String labelName;
    private ArrayList<BarEntry> barEntries;

    public MyBarChart(String[] taskString,BarChart barChart, String labelName){
        this.taskString = taskString;
        this.barChart = barChart;
        this.labelName = labelName;
    }

    public String getFormattedValue(float value) {
        return "" + ((int) value);
    }

    public void longBarEntry(long[] arrayDurations) {
        barEntries = new ArrayList<>();
        for (int i = 0 ; i < arrayDurations.length ; i++) {
            barEntries.add(new BarEntry(i,arrayDurations[i]));
        }
    }

    public void intBarEntry(int[] arrayAttempts){
        barEntries = new ArrayList<>();
        for (int i = 0 ; i < arrayAttempts.length ; i++) {
            barEntries.add(new BarEntry(i,arrayAttempts[i]));
        }
    }

    public void createChart(){
        BarDataSet barDataSet = new BarDataSet(barEntries, labelName);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.YELLOW);
        barDataSet.setValueTextSize(10f);
        barDataSet.setValueFormatter(new MyValueFormatter());

        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.8f);

        barChart.getDescription().setEnabled(false);
        barChart.setTouchEnabled(false);
        barChart.setData(data);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setTextColor(Color.YELLOW);
        xAxis.setValueFormatter(new MyBarChart.MyXAxisValueFormatter(taskString));
        xAxis.setGranularityEnabled(true);

        YAxis yAxisLeft = barChart.getAxisLeft();
        yAxisLeft.setTextColor(Color.YELLOW);
        yAxisLeft.setAxisMinimum(0f);
        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setTextColor(Color.YELLOW);
        yAxisRight.setAxisMinimum(0f);

        Legend legend = barChart.getLegend();
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

    public class MyValueFormatter implements IValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(value);
        }
    }
}
