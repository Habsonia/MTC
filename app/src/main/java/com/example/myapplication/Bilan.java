package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Bilan extends AppCompatActivity implements View.OnClickListener{
    private TextView rapidité, attention, memoire, observation, name;
    private Button btnQuit, btnRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilan);
        rapidité = findViewById(R.id.rapidité);
        attention = findViewById(R.id.attention);
        memoire = findViewById(R.id.memoire);
        observation = findViewById(R.id.observation);
        name = findViewById(R.id.name);
        btnRec = findViewById(R.id.btnRec);
        btnQuit = findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(this);
        btnRec.setOnClickListener(this);
        Intent times = getIntent();
        float time = times.getFloatExtra("time1", 0.0F);
        float time2 = times.getFloatExtra("time2", 0.0F);
        float time3 = times.getFloatExtra("time3", 0.0F);
        float time4 = times.getFloatExtra("time4", 0.0F);
        String nm = times.getStringExtra("PSEUDO");
        name.setText(("bilan : "+nm).toUpperCase ());

        if (time <= 1.0){
            rapidité.setText("Vous avez passé "+time+ " minutes pour reussir cet exercice" +
                    "\nVous avez une bonne capacité de traiter l'information rapidement");
        }
        else {
            rapidité.setText("Vous avez passé "+time+ " minutes pour reussir cet exercice" +
                    "\nVotre capacité de traiter l'information rapidement est lente, entrainez-vous plus!");

        }
        if(time2 <= 1.0 ) {
            attention.setText("Vous avez passé " + time2 + " minutes pour reussir cet exercice" +
                    "\nVous avez une bonne capacité de percevoir de nouvelles informations ");

        }
        else {
            attention.setText("Vous avez passé "+time2+ " minutes pour reussir cet exercice" +
                    "\nVotre capacité de percevoir de nouvelles informations est lente, entrainez-vous plus!");

        }
        if(time3 <= 1.0) {
            memoire.setText("Vous avez passé "+time3+ " minutes pour reussir cet exercice" +
                    "\nVous avez une bonne capacité de stocker, de mettre à jour et de recupérer des informations");
        }
        else {
            memoire.setText("Vous avez passé "+time3+ " minutes pour reussir cet exercice" +
                    "\nVotre capacité de stocker, de mettre à jour et de recupérer des informations est lente, entrainez-vous plus!");

        }
           if(time4 <= 1.0) {
               observation.setText("Vous avez passé "+time4+ " minutes pour reussir cet exercice" +
                       "\nVous avez une bonne capacité d'observation");
           }
        else {
               observation.setText("Vous avez passé "+time4+ " minutes pour reussir cet exercice" +
                       "\nVotre capacité d'observation est mauvaise, entrainez-vous plus! ");
           }



    }



    @Override
    public void onClick(View v) {
    if(v == btnQuit){
        moveTaskToBack(true);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
    if (v == btnRec){
        Intent main = new Intent(Bilan.this, MainActivity.class);
        startActivity(main);

    }
    }

}