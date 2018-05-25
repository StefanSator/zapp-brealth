package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NahrungsMittelFragment extends Fragment {

    private RecyclerView recyclerView;
    private NahrungAdapter adapter;

    public static List<NahrungItem> getData() {
        List<NahrungItem> data = new ArrayList<>();
//        int[] icons = {R.drawable.broccoli, R.drawable.ic_home_black_24dp};
        String[] titles = {"Brokkoli", "Spargel"};
        for(int i = 0; i < titles.length; i++) {
            NahrungItem current = new NahrungItem();
//            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }

        return data;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_nahrungsmittel, null);
        recyclerView = (RecyclerView)layout.findViewById(R.id.nahrungsmittel_list);
        adapter = new NahrungAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }
}
