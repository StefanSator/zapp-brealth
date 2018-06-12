package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by StefanSator on 31.05.18.
 */

public class EffortCalculatingMenu extends AppCompatActivity {
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effortcalculatingmenu);
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
            EffortCalculatingMenu.this.startActivity(effort20Intent);
        } else if (findViewById(R.id.efforttask_button2) == view) {
            Intent effort50Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort50Intent.putExtra("limit", 50);
            EffortCalculatingMenu.this.startActivity(effort50Intent);
        } else if (findViewById(R.id.efforttask_button3) == view) {
            Intent effort75Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort75Intent.putExtra("limit", 75);
            EffortCalculatingMenu.this.startActivity(effort75Intent);
        } else if (findViewById(R.id.efforttask_button4) == view) {
            Intent effort100Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort100Intent.putExtra("limit", 100);
            EffortCalculatingMenu.this.startActivity(effort100Intent);
        } else {
            Intent effort200Intent = new Intent(EffortCalculatingMenu.this, EffortCalculatingTask.class);
            effort200Intent.putExtra("limit", 200);
            EffortCalculatingMenu.this.startActivity(effort200Intent);
        }
    }
}
