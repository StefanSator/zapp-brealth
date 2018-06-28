package com.example.stefansator.brealth.health.naehrstoffzentrale.nahrungsmittel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.health.naehrstoffzentrale.statistik.StatistikFragment;
import com.example.stefansator.brealth.health.naehrstoffzentrale.tagebuch.TagebuchFragment;

public class Zentrale extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zentrale);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new NahrungsMittelFragment());
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_nahrung:
                fragment = new NahrungsMittelFragment();
                break;

            case R.id.navigation_tagebuch:
                fragment = new TagebuchFragment();
                break;

            case R.id.navigation_statistik:
                fragment = new StatistikFragment();
                break;
        }

        return loadFragment(fragment);
    }
}
