package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by StefanSator on 17.06.18.
 */

public class VocableEvaluationScreen extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocableevaluation);
    }

    public void endVocableRun(View view) {
        int falseCounter;
        EditText falseField = findViewById(R.id.evaluation_answer);
        if (falseField.getText().toString().isEmpty()) {
            return;
        } else {
            falseCounter = Integer.parseInt(falseField.getText().toString());
        }

        if (falseCounter < 0 || falseCounter > 25) {
            Toast invalidToast = Toast.makeText(getApplicationContext(), "Ungültige Eingabe", Toast.LENGTH_SHORT);
            invalidToast.show();
            return;
        }

        int rating = RateThePlayer(falseCounter);
        Intent finishScreenIntent = new Intent(VocableEvaluationScreen.this, TaskEndscreen.class);
        finishScreenIntent.putExtra("falsch", falseCounter);
        finishScreenIntent.putExtra("rating", rating);
        VocableEvaluationScreen.this.startActivity(finishScreenIntent);
        VocableEvaluationScreen.this.finish();
    }

    private int RateThePlayer(int falseCounter) {
        GameRater gameRater = new VocableRunRater(falseCounter);
        return gameRater.getRating();
    }
}
