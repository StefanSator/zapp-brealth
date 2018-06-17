package com.example.stefansator.brealth;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by StefanSator on 13.06.18.
 */

public class VocableRunTask extends AppCompatActivity {
    private AlertDialog.Builder dlgBuilder;
    private AlertDialog alert;
    private VocableExercise exercises[];
    private TextView taskTitle;
    private TextView taskVocable;
    private int exerciseNr = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocablerun);

        createTutorialDialog();
    }

    private String[] ReadVocablesFromFile(int fileid, int numberOfVocables) throws IOException {
        String str = "";
        String vocables[] = new String[numberOfVocables];
        InputStream is = VocableRunTask.this.getResources().openRawResource(fileid);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        int i = 0;
        if (is != null) {
            while ((str = reader.readLine()) != null) {
                vocables[i] = str;
                i++;
            }
        }
        is.close();

        return vocables;
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
        String vocableCatalog[] = new String[50];
        try {
            vocableCatalog = ReadVocablesFromFile(R.raw.fuenfzigvokabeln, 50);
        } catch (IOException ex) {
            Toast.makeText(getApplicationContext(), "Problems: " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }

        exercises = new VocableExercise[25];
        for (int i = 0 ; i < exercises.length ; i++) {
            exercises[i] = new VocableExercise(vocableCatalog);
        }

        taskTitle = findViewById(R.id.vocable_task_title);
        taskVocable = findViewById(R.id.vocable_task);

        int secs = 25;
        new CountDownTimer((secs +1) * 5000, 5000)
        {
            @Override
            public final void onTick(final long millisUntilFinished)
            {
                if (exerciseNr >= 25) return;

                taskTitle.setText(exercises[exerciseNr].getTask());
                if (taskTitle.getText().toString().equals("Kopfüber"))
                    taskVocable.setRotation(180);
                else
                    taskVocable.setRotation(0);
                if (taskTitle.getText().toString().equals("Rückwärts"))
                    taskVocable.setScaleX(-1);
                else
                    taskVocable.setScaleX(1);
                taskVocable.setText(exercises[exerciseNr].getChosenVocable());
                exerciseNr++;
            }

            @Override
            public void onFinish() {
                endVocableRunTask();
            }
        }.start();
    }

    private void endVocableRunTask() {
        Intent evaluationScreenIntent = new Intent(VocableRunTask.this, VocableEvaluationScreen.class);
        VocableRunTask.this.startActivity(evaluationScreenIntent);
        VocableRunTask.this.finish();
    }
}
