package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by StefanSator on 05.06.18.
 */

public class YogaMemoryMenu extends AppCompatActivity {
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogamemorymenu);
    }

    public void gotoYogaMemoryTask(View view) {
        createInformationDialog(view);
    }

    private void createInformationDialog(final View view) {
        dlgBuilder = new AlertDialog.Builder(YogaMemoryMenu.this);
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
        dlgBuilder.setMessage(R.string.yogamemorytask_rules);
    }

    private void startBrainTask(View view) {
        if (findViewById(R.id.yoga_exercise_button1) == view) {
            Intent yogaTaskIntent = new Intent(YogaMemoryMenu.this, YogaMemoryTask.class);
            YogaMemoryMenu.this.startActivity(yogaTaskIntent);
        } else {
            Intent yogaTaskIntent = new Intent(YogaMemoryMenu.this, YogaMemoryTask.class);
            YogaMemoryMenu.this.startActivity(yogaTaskIntent);
        }
    }
}
