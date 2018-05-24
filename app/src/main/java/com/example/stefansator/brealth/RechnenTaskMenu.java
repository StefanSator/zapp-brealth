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

public class RechnenTaskMenu extends AppCompatActivity {
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechnentaskmenu);
    }

    public void gotoRechnen(View view) {
        createInformationDialog(view);
    }

    private void createInformationDialog(final View view) {
        dlgBuilder = new AlertDialog.Builder(RechnenTaskMenu.this);
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
        if (findViewById(R.id.rechnentask_button1) == view) {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 20 Kopfrechenaufgaben gestellt.");
        } else if (findViewById(R.id.rechnentask_button2) == view) {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 50 Kopfrechenaufgaben gestellt.");
        } else if (findViewById(R.id.rechnentask_button3) == view) {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 75 Kopfrechenaufgaben gestellt.");
        } else if (findViewById(R.id.rechnentask_button4) == view) {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 100 Kopfrechenaufgaben gestellt.");
        } else {
            dlgBuilder.setMessage("In dieser Übung bekommen Sie 200 Kopfrechenaufgaben gestellt.");
        }
    }

    private void startBrainTask(View view) {
        if (findViewById(R.id.rechnentask_button1) == view) {
            Intent rechnen20Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
            rechnen20Intent.putExtra("limit", 20);
            RechnenTaskMenu.this.startActivity(rechnen20Intent);
        } else if (findViewById(R.id.rechnentask_button2) == view) {
            Intent rechnen50Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
            rechnen50Intent.putExtra("limit", 50);
            RechnenTaskMenu.this.startActivity(rechnen50Intent);
        } else if (findViewById(R.id.rechnentask_button3) == view) {
            Intent rechnen75Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
            rechnen75Intent.putExtra("limit", 75);
            RechnenTaskMenu.this.startActivity(rechnen75Intent);
        } else if (findViewById(R.id.rechnentask_button4) == view) {
            Intent rechnen100Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
            rechnen100Intent.putExtra("limit", 100);
            RechnenTaskMenu.this.startActivity(rechnen100Intent);
        } else {
            Intent rechnen200Intent = new Intent(RechnenTaskMenu.this, RechnenTask.class);
            rechnen200Intent.putExtra("limit", 200);
            RechnenTaskMenu.this.startActivity(rechnen200Intent);
        }
    }
}
