package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by StefanSator on 13.06.18.
 */

public class VocableRunTask extends AppCompatActivity {
    private AlertDialog.Builder dlgBuilder;
    private AlertDialog alert;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocablerun);

        createTutorialDialog();
    }

    private void createTutorialDialog() {
        dlgBuilder = new AlertDialog.Builder(VocableRunTask.this);
        dlgBuilder.setTitle("Regeln");
        dlgBuilder.setMessage("Führen Sie diese Aufgabe aus, während Sie sich auf einem Laufband oder beim Joggen befinden.\n\n" +
                "Arten von Aufgaben:\n\n" +
                "1) Rückwärts\n     Rückwärts laut vorlesen\n\n" +
                "2) 5 Wörter, 1 Buchstabe\n     Satz aus 5 Wörtern mit gleichem\n     Anfangsbuchstaben bilden\n\n" +
                "3) Kopfüber\n      Kopfübergestellten Text lesen");
        dlgBuilder.setCancelable(false);
        dlgBuilder.setPositiveButton("Start Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startVocableRunGame();
            }
        });

        alert = dlgBuilder.create();
        alert.show();
    }

    private void startVocableRunGame() {

    }
}
