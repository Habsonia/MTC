package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Level4 extends AppCompatActivity implements View.OnClickListener{
    private EditText reponse;
    private TextView resutlat;
    private Button btnVal, btnQt;
    private ImageView img;
    private int cmp = 0;
    Chronometer chronometer;
    private static final String MY_BACKUP_FILE = "MY_BACKUP_FILE ";
    private static final String MY_BACKUP_FILE_TIME4 = "MY_BACKUP_FILE_TIME4 ";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);
        reponse = findViewById(R.id.reponse);
        resutlat = findViewById(R.id.resultat);
        btnVal =findViewById(R.id.btnVal);
        chronometer = findViewById(R.id.chronometre);
        img = findViewById(R.id.img);
        resutlat.setText("Combien de cheval y'a t-il sur cette photo?");
        btnQt = findViewById(R.id.btnQt);
        img.setImageResource(R.drawable.cheval5);

        btnVal.setOnClickListener(this);
        btnQt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent level1 = getIntent();
        float time2 = level1.getFloatExtra("time2", 0.0F);
        float time = level1.getFloatExtra("time1", 0.0F);
        float time3 = level1.getFloatExtra("time3", 0.0F);
        String name = level1.getStringExtra("PSEUDO");

        String nmbr = reponse.getText().toString();
        if (nmbr.equals("")) {
            Toast.makeText(Level4.this,"Vous devez saisir une reponse pour pouvoir valider  ! ", Toast.LENGTH_SHORT).show();

        }
        else{
            if( v == btnVal){
                chronometer.start();
                // si la reponse de l'utilisation est un 5 on passe à l'image suivante
                if (nmbr.equals("5")) {
                    cmp++;
                    img.setImageResource(R.drawable.verre);
                    resutlat.setText("Quel verre a le plus d'eau ?");
                   resutlat.setTextSize(20);

                    reponse.setText("");

                }
                else{
                    reponse.setText("");

                }

                if (cmp == 1){
                 if (nmbr.equals("B")) {

                     cmp++;
                     reponse.setText("");
                 }


               }


                Log.i("DEBUG", "cmp: "+cmp);
                if (cmp == 2){
                chronometer.stop();
                double elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
                DecimalFormat df = new DecimalFormat("0.0");
                float elapsedMinut = (float) Double.parseDouble(df.format(elapsedMillis / 60000));
                getSharedPreferences(MY_BACKUP_FILE, MODE_PRIVATE).edit().putFloat(MY_BACKUP_FILE_TIME4, elapsedMinut).apply();

                AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                nextLevel.setTitle("Bravo "+name+" Vous etes arrivé à la fin des exercices !!");
                nextLevel.setMessage("Vous allez procèder à votre bilan ");
                nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "BILAN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent level4 = new Intent(Level4.this, Bilan.class);
                        level4.putExtra("time1", time);
                        level4.putExtra("time2", time2);
                        level4.putExtra("time3", time3);
                        level4.putExtra("time4", elapsedMinut);
                        level4.putExtra("PSEUDO", name);

                        startActivity(level4);
                    }
                });


                nextLevel.show();

            }}}

            if (v == btnQt){

                moveTaskToBack(true);
                Process.killProcess(Process.myPid());
                System.exit(1);

            }
    }}
