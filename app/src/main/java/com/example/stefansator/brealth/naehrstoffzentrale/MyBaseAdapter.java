package com.example.stefansator.brealth.naehrstoffzentrale;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stefansator.brealth.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class MyBaseAdapter extends BaseAdapter {

        AssetManager assetManager = null;

        LayoutInflater lif;
        ImageView sideArrow;
        TextView tv;


        public MyBaseAdapter(Context ctx) {
            lif = (LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
            assetManager = ctx.getAssets();

        }
//
        @Override
        public int getCount() {

//            return favarets.size();
            return 0;
        }
//
        @Override
        public Object getItem(int position) {
            return position;
        }
//
        @Override
        public long getItemId(int position) {
            return position;
        }
//
//
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                return null;
//            View vi = convertView;
//            if (convertView == null)
//                vi = lif.inflate(R.layout.inflate, null);
//            sideArrow = (ImageView) vi.findViewById(R.id.imageViewsidemark);
//
//
//            tv = (TextView) vi.findViewById(R.id.textFav);
//            tv.setText(favarets.get(position));
//
//            final Typeface tvFont = Typeface.createFromAsset(assetManager, "OPTIMA.TTF");
//            tv.setTypeface(tvFont);
//            tv.setTextColor(Color.BLACK);
//
//            return vi;
        }

    }

