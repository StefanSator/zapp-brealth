package com.example.stefansator.brealth.rezepte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stefansator.brealth.R;
import com.example.stefansator.brealth.naehrstoffzentrale.FoodListAdapter;
import com.example.stefansator.brealth.rezepte.Rezept;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RezepteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezepte);

        ListView listView = (ListView) findViewById(R.id.rezepteList);
        final ArrayList<Rezept> rezeptList = new ArrayList<Rezept>();
        ArrayList<String> rezeptNameList = new ArrayList<String>();

        setRezepteList(rezeptList);
//        Rezept testRezept = new Rezept("Kartoffelpizza", readTextFromFile(R.raw.kartoffelpizza), R.drawable.kartoffelpizza);
//        Rezept testRezept2 = new Rezept("Müsli", "Geilo Müsli !", R.drawable.brain);
//        rezeptList.add(testRezept);
//        rezeptList.add(testRezept2);
        
        for(int i = 0; i < rezeptList.size(); i++) {
//            rezeptNameList.set(i, rezeptList.get(i).getName());
            Log.d("REZEPTSTUFF: ", rezeptList.get(i).getName());
        }
        
        RezepteAdapter rezepteAdapter;

        // set adapter
        rezepteAdapter = new RezepteAdapter(this, rezeptNameList);
        for(int i = 0; i < rezeptList.size(); i++) {
            rezepteAdapter.add(rezeptList.get(i));
        }
        listView.setAdapter(rezepteAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent rezeptDetailsIntent = new Intent(RezepteActivity.this, RezeptDetailsActivity.class);
                rezeptDetailsIntent.putExtra("instructions", rezeptList.get(position).getInstructions());
                rezeptDetailsIntent.putExtra("title", rezeptList.get(position).getName());
                rezeptDetailsIntent.putExtra("image", rezeptList.get(position).getImageResource());
                startActivity(rezeptDetailsIntent);
            }
        });
    }

    private void setRezepteList(ArrayList<Rezept> rezeptList) {
        Rezept kartoffelpizza = new Rezept("Kartoffelpizza", readTextFromFile(R.raw.kartoffelpizza), R.drawable.kartoffelpizza);
        Rezept spinatsalat = new Rezept("Spinatsalat", readTextFromFile(R.raw.spinatsalat), R.drawable.spinatsalat);
        Rezept broccoliLinsenPasta = new Rezept("Broccoli-Linsen-Pasta", readTextFromFile(R.raw.broccoli_linsen_pasta), R.drawable.broccoli_linsen_pasta);
        Rezept bohnenLauchTortilla = new Rezept("Bohnen-Lauch-Tortilla", readTextFromFile(R.raw.bohnen_lauch_tortilla), R.drawable.bohnen_lauch_tortilla);
        Rezept weizenRisotto = new Rezept("Weizenrisotto", readTextFromFile(R.raw.weizenrisotto), R.drawable.weizenrisotto);

        rezeptList.add(kartoffelpizza);
        rezeptList.add(spinatsalat);
        rezeptList.add(broccoliLinsenPasta);
        rezeptList.add(bohnenLauchTortilla);
        rezeptList.add(weizenRisotto);
    }

    private String readTextFromFile(int file) {
        TextView instructionsView = (TextView) findViewById(R.id.instructionsView);
        InputStream inputStream = getResources().openRawResource(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer buffer = new StringBuffer();
        String str = "";

        if (inputStream != null) {
            try {
                while ((str = bufferedReader.readLine()) != null) {
                    buffer.append(str + "\n");
                }
            } catch (IOException e) {
                Toast.makeText(this, "Unerwarteter Fehler", Toast.LENGTH_LONG).show();
            }
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

}
