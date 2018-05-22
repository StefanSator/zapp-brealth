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
        Intent rechnen20Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
        rechnen20Intent.putExtra("limit", 20);
        RechnenTaskMenu.this.startActivity(rechnen20Intent);
    }

    public void gotoRechnen50(View view) {
        Intent rechnen50Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
        rechnen50Intent.putExtra("limit", 50);
        RechnenTaskMenu.this.startActivity(rechnen50Intent);
    }

    public void gotoRechnen75(View view) {
        Intent rechnen75Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
        rechnen75Intent.putExtra("limit", 75);
        RechnenTaskMenu.this.startActivity(rechnen75Intent);
    }

    public void gotoRechnen100(View view) {
        Intent rechnen100Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
        rechnen100Intent.putExtra("limit", 100);
        RechnenTaskMenu.this.startActivity(rechnen100Intent);
    }

    public void gotoRechnen200(View view) {
        Intent rechnen200Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
        rechnen200Intent.putExtra("limit", 200);
        RechnenTaskMenu.this.startActivity(rechnen200Intent);
    }
}
