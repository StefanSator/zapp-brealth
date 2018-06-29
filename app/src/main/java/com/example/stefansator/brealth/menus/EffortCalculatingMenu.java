package com.example.stefansator.brealth.menus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.uebungen.brealth.effortcalculating.EffortCalculatingTask;

/**
 * Created by StefanSator on 31.05.18.
 */

public class EffortCalculatingMenu extends AppCompatActivity {
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;
    private boolean wipeHighscore = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effortcalculatingmenu);

        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);
    }

    public void gotoEffortCalculating(View view) {
        createInformationDialog(view);
    }

    private void createInformationDialog(final View view) {
        dlgBuilder = new AlertDialog.Builder(EffortCalculatingMenu.this);
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
        if (findViewById(R.id.efforttask_button1) == view) {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 20 Aufgaben gestellt." +
                    " Diese setzen sich aus Kopfrechen- und Leistungsaufgaben zusammen.");
        } else if (findViewById(R.id.efforttask_button2) == view) {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 50 Aufgaben gestellt." +
                    " Diese setzen sich aus Kopfrechen- und Leistungsaufgaben zusammen.");
        } else if (findViewById(R.id.efforttask_button3) == view) {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 75 Aufgaben gestellt." +
                    " Diese setzen sich aus Kopfrechen- und Leistungsaufgaben zusammen.");
        } else if (findViewById(R.id.efforttask_button4) == view) {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 100 Aufgaben gestellt." +
                    " Diese setzen sich aus Kopfrechen- und Leistungsaufgaben zusammen.");
        } else {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 200 Aufgaben gestellt." +
                    " Diese setzen sich aus Kopfrechen- und Leistungsaufgaben zusammen.");
        }
    }

    private void startBrainTask(View view) {
        if (findViewById(R.id.efforttask_button1) == view) {
            Intent effort20Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort20Intent.putExtra("limit", 20);
            effort20Intent.putExtra("numberOfSportTasks", 10);
            effort20Intent.putExtra("WIPE", wipeHighscore);
            EffortCalculatingMenu.this.startActivity(effort20Intent);
        } else if (findViewById(R.id.efforttask_button2) == view) {
            Intent effort50Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort50Intent.putExtra("limit", 50);
            effort50Intent.putExtra("numberOfSportTasks", 10);
            effort50Intent.putExtra("WIPE", wipeHighscore);
            EffortCalculatingMenu.this.startActivity(effort50Intent);
        } else if (findViewById(R.id.efforttask_button3) == view) {
            Intent effort75Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort75Intent.putExtra("limit", 75);
            effort75Intent.putExtra("numberOfSportTasks", 5);
            effort75Intent.putExtra("WIPE", wipeHighscore);
            EffortCalculatingMenu.this.startActivity(effort75Intent);
        } else if (findViewById(R.id.efforttask_button4) == view) {
            Intent effort100Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort100Intent.putExtra("limit", 100);
            effort100Intent.putExtra("numberOfSportTasks", 2);
            effort100Intent.putExtra("WIPE", wipeHighscore);
            EffortCalculatingMenu.this.startActivity(effort100Intent);
        } else {
            Intent effort200Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort200Intent.putExtra("limit", 200);
            effort200Intent.putExtra("numberOfSportTasks", 2);
            effort200Intent.putExtra("WIPE", wipeHighscore);
            EffortCalculatingMenu.this.startActivity(effort200Intent);
        }
    }
}
