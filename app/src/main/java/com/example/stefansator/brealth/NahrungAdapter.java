package com.example.stefansator.brealth;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class NahrungAdapter extends RecyclerView.Adapter<NahrungAdapter.NahrungViewHolder>{

    List<NahrungItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    Context context;

    public NahrungAdapter(Context context, List<NahrungItem> data) {
        inflater=LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public NahrungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_nahrung_row, parent, false);
        return new NahrungViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NahrungViewHolder holder, int position) {
        NahrungItem current = data.get(position);

        holder.title.setText(current.title);
        if(position%2 == 0) {
            holder.setBackgroundColor("#FFFFFF");
        } else {
            holder.setBackgroundColor("#ABCDEF");
        }
//        holder.icon.setImageResource(current.iconId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NahrungViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
//        ImageView icon;
        Color color;

        public NahrungViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
//            icon = (ImageView) itemView.findViewById(R.id.listIcon);
//            icon.setOnClickListener(this);
            title.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, "Item clicket at" + getLayoutPosition(), Toast.LENGTH_SHORT).show();
        }

        public void setBackgroundColor(String color) {
            title.findViewById(R.id.listText).setBackgroundColor(Color.parseColor(String.valueOf(color)));
        }
    }
}
