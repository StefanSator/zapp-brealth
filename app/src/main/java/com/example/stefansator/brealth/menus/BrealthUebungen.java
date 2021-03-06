package com.example.stefansator.brealth.menus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.uebungen.brealth.powerlogic.Powerlogic;
import com.example.stefansator.brealth.uebungen.brealth.stretchingcolors.StretchingColors;
import com.example.stefansator.brealth.uebungen.brealth.vocablerun.VocableRunTask;
import com.example.stefansator.brealth.uebungen.brealth.yogamemory.YogaMemoryTask;

public class BrealthUebungen extends AppCompatActivity {
    private AlertDialog alert;
    private AlertDialog.Builder dlgBuilder;
    private boolean wipeHighscore = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthuebungen);
    }

    public void gotoEffortCalculatingMenu(View view) {
        Intent effortIntent = new Intent(BrealthUebungen.this, EffortCalculatingMenu.class);
        effortIntent.putExtra("WIPE",wipeHighscore);
        BrealthUebungen.this.startActivity(effortIntent);
    }

    public void gotoYogaMemory(View view) {
        createInformationDialog(view);
    }
  
    public void gotoVocableRun(View view) {
        Intent vocableIntent = new Intent(BrealthUebungen.this, VocableRunTask.class);
        vocableIntent.putExtra("WIPE",wipeHighscore);
        BrealthUebungen.this.startActivity(vocableIntent);
    }
  
    public void gotoSretchingColors(View view) {
        createInformationDialog(view);
    }

    public void gotoPowerLogic(View view) {
        createInformationDialog(view);
    }

    private void createInformationDialog(final View view) {
        dlgBuilder = new AlertDialog.Builder(BrealthUebungen.this);
        dlgBuilder.setTitle("Regeln: ");
        setRulesInDialog(view);
        dlgBuilder.setCancelable(false);
        dlgBuilder.setPositiveButton("Starte Spiel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast rightToast = Toast.makeText(getApplicationContext(), "Viel Spaß!", Toast.LENGTH_SHORT);
                rightToast.show();
                startBrealthTask(view);
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
        if (findViewById(R.id.brealth_powerlogic) == view) {
            dlgBuilder.setMessage("Halten Sie für diese Aufgaben Hanteln parat.\n\n"+
                    "Sie werden eine Reihe von gleichen Bildern erhalten die aufaddiert eine Zahl ergibt.\n"+
                    "Dies gilt ebenfalls für die zweite Reihe.\n" +
                    "In der letzten müssen Sie die jeweiligen Bilder addieren und das Ergebnis angeben.\n\n" +
                    "Danach müssen Sie eines der gezeigten Bilder ausführen.\n" +
                    "Sie bekommen 10 Sekunden um die Übung anzuschauen und müssen Sie solange ausführen wie das Ergebis der Rechnung war.");
        } else if (findViewById(R.id.brealth_stretching_colors) == view) {
            dlgBuilder.setMessage("In dieser Aufgabe müssen sie 60 Sekunden lang Dehnübungen ausführen.\n\n"+
                    "Bevor es losgeht bekommen Sie ein wenig Zeit um sich vorzubereiten.\n" +
                    "Zu den Übungen wird Ihnen ein Wort gezeigt,welches Unterschiedliche Farben haben kann.\n" +
                    "Sagen Sie die Farbe laut in der das Wort geschrieben wurde.\n\n" +
                    "Am Ende müssen sie die Anzahl der Fehler eingeben.\n" +
                    "Seien Sie ehrlich!");
        } else if (findViewById(R.id.brealth_uebungen3) == view) {
            dlgBuilder.setMessage(R.string.yogamemorytask_rules);
        }
    }

    //Limit for testing purposes
    private void startBrealthTask(View view) {
        if (findViewById(R.id.brealth_powerlogic) == view) {
            Intent powerLogicIntent= new Intent(BrealthUebungen.this, Powerlogic.class);
            powerLogicIntent.putExtra("LIMIT", 10);
            powerLogicIntent.putExtra("WIPE", wipeHighscore);
            BrealthUebungen.this.startActivity(powerLogicIntent);
        } else if (findViewById(R.id.brealth_stretching_colors) == view){
            Intent stretchingColorsIntent= new Intent(BrealthUebungen.this, StretchingColors.class);
            stretchingColorsIntent.putExtra("WIPE",wipeHighscore);
            BrealthUebungen.this.startActivity(stretchingColorsIntent);
        } else if (findViewById(R.id.brealth_uebungen3) == view) {
            Intent yogaIntent = new Intent(BrealthUebungen.this, YogaMemoryTask.class);
            yogaIntent.putExtra("WIPE",wipeHighscore);
            BrealthUebungen.this.startActivity(yogaIntent);
        }
    }


}
