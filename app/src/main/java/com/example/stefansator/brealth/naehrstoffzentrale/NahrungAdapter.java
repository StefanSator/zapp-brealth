package com.example.stefansator.brealth.naehrstoffzentrale;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stefansator.brealth.R;

import java.util.Collections;
import java.util.List;

public class NahrungAdapter extends RecyclerView.Adapter<NahrungAdapter.NahrungViewHolder>{

    List<NahrungItem> data = Collections.emptyList();
    private LayoutInflater inflater;

    public NahrungAdapter(Context context, List<NahrungItem> data) {
        inflater=LayoutInflater.from(context);
        this.data = data;
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
        holder.icon.setImageResource(current.iconId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NahrungViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;

        public NahrungViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
