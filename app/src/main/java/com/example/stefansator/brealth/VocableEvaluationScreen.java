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
    private TestScore testScore;
    private boolean wipeHighscore = false;
    private Highscore highscore;
    private String taskName = "vocablerun";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocableevaluation);

        wipeHighscore = getIntent().getBooleanExtra("WIPE",false);
        highscore = new Highscore(this,taskName,wipeHighscore);
        testScore = new TestScore();
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

        /* Save Score for later use in Test Task in Brealth Category */
        writeTestScore(falseCounter, 0);

        highscore.setRating(rating);
        highscore.setFalseAnswer(falseCounter);
        boolean isNewHighscore = highscore.isNewHighscoreVocablerun();

        Intent finishScreenIntent = new Intent(VocableEvaluationScreen.this, TaskEndscreen.class);
        finishScreenIntent.putExtra("falsch", falseCounter);
        finishScreenIntent.putExtra("rating", rating);
        finishScreenIntent.putExtra("highscore", isNewHighscore);
        VocableEvaluationScreen.this.startActivity(finishScreenIntent);
        VocableEvaluationScreen.this.finish();
    }

    private int RateThePlayer(int falseCounter) {
        GameRater gameRater = new VocableRunRater(falseCounter);
        return gameRater.getRating();
    }

    private void writeTestScore(int attempts, long duration) {
        testScore.writeTestAttempts(this, "VocableRunTest", "TEST_ATTEMPT_VOCABLE", attempts);
        testScore.writeTestDuration(this, "VocableRunTest", "TEST_DURATION_VOCABLE", duration);
    }
}
