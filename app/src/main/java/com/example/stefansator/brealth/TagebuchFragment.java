package com.example.stefansator.brealth;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class TagebuchFragment extends Fragment {
    Button button;
    TextView textView;
    String server_url =
            "https://api.edamam.com/api/food-database/parser?ingr=apple&app_id=bfe5aa37&app_key=c9cc3f70b3bf3964b7f583de92b22f10&page=0";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        button = getView().findViewById(R.id.getServerDataButton);
        textView = (TextView) getView().findViewById(R.id.text_tagebuch);
        textView.setMovementMethod(new ScrollingMovementMethod());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
                StringRequest stringRequest = new StringRequest(Request.Method.GET, server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                textView.setText(response);
                                requestQueue.stop();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Something went wrong...");
                        error.printStackTrace();
                        requestQueue.stop();
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tagebuch, null);
    }
}
