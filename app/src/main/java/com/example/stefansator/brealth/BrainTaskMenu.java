package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by stefansator on 05.05.18.
 */

public class BrainTaskMenu extends AppCompatActivity {

    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;
    private boolean wipeHighscore = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braintaskmenu);
    }

    public void gotoTaskRechnen(View view) {
        Intent rechnenMenuIntent = new Intent(BrainTaskMenu.this, RechnenTaskMenu.class);
        rechnenMenuIntent.putExtra("WIPE",wipeHighscore);
        BrainTaskMenu.this.startActivity(rechnenMenuIntent);
    }

    public void gotoTaskMemory(View view) {
        createInformationDialog(view);
    }

    public void gotoTaskFarben(View view) {
        Intent farbenMenuIntent = new Intent(BrainTaskMenu.this, FarbenTaskMenu.class);
        farbenMenuIntent.putExtra("WIPE", wipeHighscore);
        BrainTaskMenu.this.startActivity(farbenMenuIntent);
    }

    public void gotoTaskLogik (View view) { createInformationDialog(view); }

    public void gotoTaskLesen(View view) {
        createInformationDialog(view);
    }

    private void createInformationDialog(final View view) {
        dlgBuilder = new AlertDialog.Builder(BrainTaskMenu.this);
        dlgBuilder.setTitle("Regeln: ");
        setRulesInDialog(view);
        dlgBuilder.setCancelable(false);
        dlgBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast rightToast = Toast.makeText(getApplicationContext(), "Viel Spaß!", Toast.LENGTH_SHORT);
                rightToast.show();
                startBrainTask(view);
            }
        });

        dlgBuilder.setNegativeButton("Zurück", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast falseToast = Toast.makeText(getApplicationContext(), "OK!", Toast.LENGTH_SHORT);
                falseToast.show();
            }
        });

        alert = dlgBuilder.create();
        alert.show();
    }

    private void setRulesInDialog(View view) {
        if (findViewById(R.id.braintask_button2) == view) {
            dlgBuilder.setMessage(R.string.lesentask_rules);
        } else if (findViewById(R.id.braintask_button3) == view) {
            dlgBuilder.setMessage(R.string.memorytask_rules);
        } else if (findViewById(R.id.braintask_button4)== view) {
            dlgBuilder.setMessage(R.string.logiktask_rules);
        }
    }

    private void startBrainTask(View view) {
        if (findViewById(R.id.braintask_button3) == view) {
            Intent memoryIntent = new Intent(BrainTaskMenu.this, MemoryTask.class);
            memoryIntent.putExtra("WIPE",wipeHighscore);
            BrainTaskMenu.this.startActivity(memoryIntent);
        } else if (findViewById(R.id.braintask_button2) == view) {
            Intent lesenIntent = new Intent(BrainTaskMenu.this, LesenTask.class);
            lesenIntent.putExtra("WIPE", wipeHighscore);
            BrainTaskMenu.this.startActivity(lesenIntent);
        } else if (findViewById(R.id.braintask_button4) == view) {
            Intent logikIntent = new Intent(BrainTaskMenu.this,Logik.class);
            logikIntent.putExtra("WIPE", wipeHighscore);
            BrainTaskMenu.this.startActivity(logikIntent);
        }
    }
}
