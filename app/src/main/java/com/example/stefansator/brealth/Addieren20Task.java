package com.example.stefansator.brealth;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by stefansator on 06.05.18.
 */

public class Addieren20Task extends AppCompatActivity {
    private ImageSwitcher switcher;
    private TextView aufgabe;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnen);

        aufgabe = findViewById(R.id.rechenaufgabe);
        switcher = findViewById(R.id.ImageSwitcher1);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(Addieren20Task.this, android.R.anim.fade_in);
        in.setDuration(3000);
        switcher.setInAnimation(in);
        Animation out = AnimationUtils.loadAnimation(Addieren20Task.this, android.R.anim.fade_out);
        out.setDuration(3000);
        switcher.setOutAnimation(out);
    }

    public void showIfRight(View view) throws InterruptedException {
        switcher.setImageResource(R.drawable.check);
        aufgabe.setText("1 + 1 =");
    }
}
