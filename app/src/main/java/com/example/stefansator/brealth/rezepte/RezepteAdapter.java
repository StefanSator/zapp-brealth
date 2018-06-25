package com.example.stefansator.brealth.rezepte;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RezepteAdapter extends BaseAdapter{

    private ArrayList<String> rezepteNames;
    private final Context context;

    public RezepteAdapter(Context context, ArrayList<String> rezepteNames) {
        this.context = context;
        this.rezepteNames = rezepteNames;
    }

    public void clear() {
    }

    @Override
    public int getCount() {
        return rezepteNames.size();
    }

    @Override
    public Object getItem(int position) {
        return rezepteNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Object obj = rezepteNames.get(position);
        TextView tv = new TextView(context);

        tv.setText(obj.toString());

        Typeface typeface = Typeface.create("casual", Typeface.BOLD);
        tv.setTypeface(typeface);

        tv.setTextSize(24);
        tv.setTextColor(Color.WHITE);

        return tv;
    }

    public void add(Rezept rezept) {
        rezepteNames.add(rezept.getName());
    }
}
