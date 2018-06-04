package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class FarbenTaskMenu extends AppCompatActivity {
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farbentaskmenu);
    }

    public void createInformationDialog(final View view) {
        dlgBuilder = new AlertDialog.Builder(FarbenTaskMenu.this);
        dlgBuilder.setTitle("Regeln: ");
        setRulesInDialog(view);
        dlgBuilder.setCancelable(false);
        dlgBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast rightToast = Toast.makeText(getApplicationContext(), "Viel Spaß!", Toast.LENGTH_SHORT);
                rightToast.show();
                startFarbenTask(view);
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
       switch (view.getId()) {
           case R.id.farben_easymode_button:
               dlgBuilder.setMessage(R.string.farbentaskEM_rules);
               break;
           case R.id.farben_hardmode_button:
               dlgBuilder.setMessage(R.string.farbentaskHM_rules);
               break;
           default:
               return;
        }
    }

    private void startFarbenTask (View view) {
       Intent farbenModeIntent;
       switch (view.getId()) {
           case R.id.farben_easymode_button:
               farbenModeIntent = new Intent(FarbenTaskMenu.this, FarbenEasyMode.class);
               FarbenTaskMenu.this.startActivity(farbenModeIntent);
               break;
           case R.id.farben_hardmode_button:
               farbenModeIntent = new Intent(FarbenTaskMenu.this, FarbenHardMode.class);
               FarbenTaskMenu.this.startActivity(farbenModeIntent);
               break;
           default:
               return;
       }
    }
}
