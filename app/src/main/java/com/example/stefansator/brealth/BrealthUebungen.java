package com.example.stefansator.brealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BrealthUebungen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brealthuebungen);
    }

    public void gotoEffortCalculatingMenu(View view) {
        Intent effortIntent = new Intent(BrealthUebungen.this, EffortCalculatingMenu.class);
        BrealthUebungen.this.startActivity(effortIntent);
    }

    public void gotoYogaMemoryMenu(View view) {
        Intent yogaIntent = new Intent(BrealthUebungen.this, YogaMemoryMenu.class);
        BrealthUebungen.this.startActivity(yogaIntent);
    }
  
    public void gotoVocableRun(View view) {
        Intent vocableIntent = new Intent(BrealthUebungen.this, VocableRunTask.class);
        BrealthUebungen.this.startActivity(vocableIntent);
    }
  
    public void gotoMindColors(View view) {
        Intent mindColorIntent= new Intent(BrealthUebungen.this, MindColors.class);
        BrealthUebungen.this.startActivity(mindColorIntent);
    }

    public void gotoPowerLogic(View view) {
        Intent powerLogicIntent= new Intent(BrealthUebungen.this, Powerlogic.class);
        BrealthUebungen.this.startActivity(powerLogicIntent);
    }
}
