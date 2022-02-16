
package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Chronometer;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class Level3 extends AppCompatActivity implements View.OnClickListener {
    private TextView c0, c1, c2, c3, c4, c5, c6, c7, c8, response;
    private EditText ed0, ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8;
    private Button valid, afficheGrille, btnCn;
    private String[] tab = {"A", "7", "B", "K", "9", "1", "P", "5", "D", "L", "M", "4", "2", "3", "C", "E", "G", "F", "X", "0", "N", "Q", "W"};
    private String eds0, eds1, eds2, eds3, eds4, eds5, eds6, eds7, eds8;
    private String c00, c11, c22, c33, c44, c55, c66, c77, c88;
    private int score = 0;
    Chronometer chronometre;
    private static final String MY_BACKUP_FILE = "MY_BACKUP_FILE ";
    private static final String MY_BACKUP_FILE_TIME3 = "MY_BACKUP_FILE_TIME3 ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        chronometre = findViewById(R.id.chronometre);
        c0 = findViewById(R.id.c0);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);

        ed0 = findViewById(R.id.ed0);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);
        ed4 = findViewById(R.id.ed4);
        ed5 = findViewById(R.id.ed5);
        ed6 = findViewById(R.id.ed6);
        ed7 = findViewById(R.id.ed7);
        ed8 = findViewById(R.id.ed8);

        c0.setText(tab[valAlea(0, 17)]);
        c1.setText(tab[valAlea(0, 17)]);
        c2.setText(tab[valAlea(0, 17)]);
        c3.setText(tab[valAlea(0, 17)]);
        c4.setText(tab[valAlea(0, 17)]);
        c5.setText(tab[valAlea(0, 17)]);
        c6.setText(tab[valAlea(0, 17)]);
        c7.setText(tab[valAlea(0, 17)]);
        c8.setText(tab[valAlea(0, 17)]);

        c00 = c0.getText().toString();
        c11 = c1.getText().toString();
        c22 = c2.getText().toString();
        c33 = c3.getText().toString();
        c44 = c4.getText().toString();
        c55 = c5.getText().toString();
        c66 = c6.getText().toString();
        c77 = c7.getText().toString();
        c88 = c8.getText().toString();
        chrono();
        // reste a effacer les textes de la grille au bout de 30 sec
        response = findViewById(R.id.response);
        valid = findViewById(R.id.valid);
        afficheGrille = findViewById(R.id.afficheGrille);
        btnCn = findViewById(R.id.btnCn);
        btnCn.setOnClickListener(this);
        valid.setOnClickListener(this);
        afficheGrille.setOnClickListener(this);

    }

    public void chrono() {
        Timer chrono = new Timer();
        chrono.schedule(new TimerTask() {
            @Override
            public void run() {
                c0.setText("");
                c1.setText("");
                c2.setText("");
                c3.setText("");
                c4.setText("");
                c5.setText("");
                c6.setText("");
                c7.setText("");
                c8.setText("");

            }
        }, 10000);
    }

    public int valAlea(int min, int max) {
        int nombreAleatoire = min + (int) (Math.random() * ((max - min) + 1));
        return nombreAleatoire;
    }

    @Override
    public void onClick(View v) {
        Intent level1 = getIntent();
        float time = level1.getFloatExtra("time1", 0.0F);
        float time2 = level1.getFloatExtra("time2", 0.0F);
        String name = level1.getStringExtra("PSEUDO");

        eds0 = ed0.getText().toString();
        eds1 = ed1.getText().toString();
        eds2 = ed2.getText().toString();
        eds3 = ed3.getText().toString();
        eds4 = ed4.getText().toString();
        eds5 = ed5.getText().toString();
        eds6 = ed6.getText().toString();
        eds7 = ed7.getText().toString();
        eds8 = ed8.getText().toString();
        chronometre.start();


        if (v == afficheGrille) {

            c0.setText(c00);
            c1.setText(c11);
            c2.setText(c22);
            c3.setText(c33);
            c4.setText(c44);
            c5.setText(c55);
            c6.setText(c66);
            c7.setText(c77);
            c8.setText(c88);
            chrono();
        }
            if (eds0.equals("") || eds1.equals("") || eds2.equals("") || eds3.equals("")
                    || eds4.equals("") || eds5.equals("") || eds6.equals("") || eds7.equals("") || eds8.equals("")) {
                Toast.makeText(Level3.this, "Vous devez remplir toutes les cases pour pouvoir valider ! ", Toast.LENGTH_SHORT).show();

            } else {

                if (v == valid) {

                    if ((eds0.equals(c00)) && (eds1.equals(c11)) && (eds2.equals(c22)) && (eds3.equals(c33))
                            && (eds4.equals(c44)) && (eds5.equals(c55)) && (eds6.equals(c66)) && (eds7.equals(c77)) && (eds8.equals(c88))) {

                        chronometre.stop();
                        float elapsedMillis = SystemClock.elapsedRealtime() - chronometre.getBase();
                        // garder que un chiffre apres la virgule
                        DecimalFormat df = new DecimalFormat("0.0");
                        float elapsedMinut = (float) Double.parseDouble(df.format(elapsedMillis / 60000));
                        getSharedPreferences(MY_BACKUP_FILE, MODE_PRIVATE).edit().putFloat(MY_BACKUP_FILE_TIME3, elapsedMinut).apply();

                        AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                        nextLevel.setTitle("EXERCICE 4: OBSERVATION");
                        nextLevel.setMessage("L'exercice vous fera travailler votre capacité d'observation" +
                                "\nCet exercice consiste à observer une image");

                        nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "GO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent level3 = new Intent(Level3.this, Level4.class);
                                level3.putExtra("time1", time);
                                level3.putExtra("time2", time2);
                                level3.putExtra("time3", elapsedMinut);
                                level3.putExtra("PSEUDO", name);
                                startActivity(level3);
                            }
                        });

                        nextLevel.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                moveTaskToBack(true);
                                Process.killProcess(Process.myPid());
                                System.exit(1);
                            }
                        });
                        nextLevel.show();
                    }
                    else {
                        response.setText("Souvenez vous bien !");

                    }
                }

            }
            if (v == btnCn){
                moveTaskToBack(true);
                Process.killProcess(Process.myPid());
                System.exit(1);
            }
            }



    }

