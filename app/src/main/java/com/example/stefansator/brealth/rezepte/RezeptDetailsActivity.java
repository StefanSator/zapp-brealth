package com.example.stefansator.brealth.rezepte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stefansator.brealth.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RezeptDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept_details);

        TextView titleView = (TextView) findViewById(R.id.recipeTitleView);
        TextView instructionsView = (TextView)findViewById(R.id.instructionsView);
        ImageView imageView = (ImageView) findViewById(R.id.recipeImageView);

        String title = getIntent().getExtras().get("title").toString();
        String instructions = getIntent().getExtras().get("instructions").toString();
        int imageResource = (int) getIntent().getExtras().get("image");

        titleView.setText(title);
        instructionsView.setText(instructions);
        imageView.setImageResource(imageResource);
    }
}
