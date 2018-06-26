package com.example.stefansator.brealth.naehrstoffzentrale;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.stefansator.brealth.R;

import java.util.ArrayList;

public class FoodListAdapter extends BaseAdapter {

    private ArrayList<String> foodLabels;
    private final Context context;

    public FoodListAdapter(Context context, ArrayList<String> foodLabels) {
        this.context = context;
        this.foodLabels = foodLabels;
    }

    @Override
    public int getCount() {
        return foodLabels.size();
    }

    @Override
    public Object getItem(int position) {
        return foodLabels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Object obj = foodLabels.get(position);
        TextView tv = new TextView(context);

        tv.setText(obj.toString());

        Typeface typeface = Typeface.create("casual", Typeface.BOLD);
        tv.setTypeface(typeface);

        tv.setTextSize(24);
        tv.setTextColor(Color.WHITE);

        if(position % 2 != 0) {
            tv.setBackgroundColor(tv.getResources().getColor(R.color.colorButton4));
        }

        return tv;
    }

    public void add(String label) {
        foodLabels.add(label);
    }

    public void clear() {
        foodLabels.clear();
    }
}