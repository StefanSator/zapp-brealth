package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by stefansator on 05.05.18.
 */

public class RechnenTaskMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnentaskmenu);
    }

    public void gotoRechnen20(View view) {
        Intent addieren20Intent = new Intent(RechnenTaskMenu.this, Rechnen20Task.class);
        RechnenTaskMenu.this.startActivity(addieren20Intent);
    }
}
