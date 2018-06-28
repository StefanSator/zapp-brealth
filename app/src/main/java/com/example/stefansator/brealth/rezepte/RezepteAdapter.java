package com.example.stefansator.brealth.rezepte;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stefansator.brealth.R;

import java.util.ArrayList;

public class RezepteAdapter extends BaseAdapter{

    private ArrayList<String> rezepteNames = new ArrayList<String>();
    private final Context context;

    public RezepteAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.d("NAMESIZE: ", "size = " + rezepteNames.size());
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
        if(position % 2 != 0) {
            tv.setBackgroundColor(tv.getResources().getColor(R.color.colorButton4));
        }

        return tv;
    }

    public void add(Rezept rezept) {
        rezepteNames.add(rezept.getName());
    }
}
