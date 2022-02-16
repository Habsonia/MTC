/*package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Level2 extends AppCompatActivity  implements View.OnClickListener{
    private TextView enigme, quiSuis, res;
    private EditText ansewerEnigm;
    private Button btnValide, btnLunch;
    private String[] enigmes  = new String[4];
    private String[] ansewers = new String[4];
    private boolean bool = true;
    private  int cmp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        enigmes[0]  = "Lorsqu'on me utilise je deviens petit";
        enigmes[1]  = "On me prend sans me toucher";
        enigmes[2]  = "Sans air je meurs, portant je n'ai pas de poumons";
        enigmes[3]  = "Je suis devant vous mais vous ne me voyez pas ";

        ansewers[0] = "un savon";
        ansewers[1] = "une photo";
        ansewers[2] = "le feu";
        ansewers[3] = "l'avenir";


        enigme = findViewById(R.id.enigme);
        quiSuis = findViewById(R.id.quiSuis);
        ansewerEnigm = findViewById(R.id.ansewerEnigm);
        btnValide = findViewById(R.id.btnValide);
        res = findViewById(R.id.res);
        btnLunch = findViewById(R.id.btnLunch);
        enigme.setText(enigmes[0]);
        ansewerEnigm.setText("");
        ansewerEnigm.findFocus();
        btnValide.setOnClickListener(this);
        btnLunch.setOnClickListener(this);


    }
    public void initialisation(String s){
        s = ansewerEnigm.getText().toString();
        quiSuis.setText("Qui suis je ?");
    }

    public void valide(View v){
        int i = 0,k, j = 0;
        int c= 0;
        String s = ansewerEnigm.getText().toString();

        for(k = 0 ; k< enigmes.length; k++) {
            if (v == btnValide) {
                enigme.setText(enigmes[i]);
                ansewerEnigm.setText("");

                if (s.equals(ansewers[j])) {
                    cmp += 1;
                    res.setText(s);
                    j++;
                }
                else {
                    res.setText("fausse reponse");
                }

                i++;
            }
            Log.i("DEBUG", "i: " + i);
            initialisation(s);
            c++;

        }
            Log.i("DEBUG", "cmp: " + cmp);

            if (c == enigmes.length ) {
                    AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                    nextLevel.setTitle("Bravo vous allez passer au niveau suivant ! ");
                   // nextLevel.setMessage("Vous avez un score de "+cmp+ " sur "+enigmes.length );
                    nextLevel.setMessage("Ce jeu à pour but de vos faire travailler votre memoire\nOUi : Recommencer une partie\nNON : Quitter");
                    nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent level3 = new Intent(Level2.this, Level3.class);
                            startActivity(level3);
                        }
                    });

                    nextLevel.setButton(AlertDialog.BUTTON_NEGATIVE, "NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    nextLevel.show();
                }
                Log.i("DEBUG", "cmp: "+cmp);

            }
    public void onClick(View v){
            valide(v);


    }}

*/



/*

    package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Level2 extends AppCompatActivity  implements View.OnClickListener{
    private TextView enigme, quiSuis, res;
    private EditText ansewerEnigm;
    private Button btnValide, nextEnigme;
    private String[] enigmes  = new String[5];
    private String[] ansewers = new String[5];
    private boolean bool = true;
    private  int cmp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        enigmes[0]  = "Lorsqu'on me utilise je deviens petit";
        enigmes[1]  = "On me prend sans me toucher";
        enigmes[2]  = "Sans air je meurs, portant je n'ai pas de poumons";
        enigmes[3]  = "Je suis devant vous mais vous ne me voyez pas ";

        ansewers[0] = "un savon";
        ansewers[1] = "une photo";
        ansewers[2] = "le feu";
        ansewers[3] = "l'avenir";


        enigme = findViewById(R.id.enigme);
        quiSuis = findViewById(R.id.quiSuis);
        ansewerEnigm = findViewById(R.id.ansewerEnigm);
        btnValide = findViewById(R.id.btnValide);
        res = findViewById(R.id.res);
        enigme.setText(enigmes[0]);
        ansewerEnigm.setText("");
        btnValide.setOnClickListener(this);


    }
    public void initialisation(String s){
        s = ansewerEnigm.getText().toString();
        quiSuis.setText("Qui suis je ?");
    }

    public void valide(View v){
        int i;
        String s = ansewerEnigm.getText().toString();
        if (v == btnValide) {
            for(i = 0; i < enigmes.length - 1; i++) {

                if (s.equals(ansewers[i])) {
                    quiSuis.setText("Bravo vous m'avez trouver je suis " + ansewers[i]);
                    enigme.setText(enigmes[i + 1]);
                    ansewerEnigm.setText("");
                    res.setText(s);
                    cmp += 1;
                    i++;
                }
                else{
                    res.setText("c'est faux");
                    ansewerEnigm.setText("");
                }

                initialisation(s);
                if (cmp == enigmes.length - 1) {
                    AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                    nextLevel.setTitle("Bravo vous allez passer au niveau suivant ! ");
                    nextLevel.setMessage("Vous avez un score de "+cmp+ " sur "+enigmes.length);
                    nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent level3 = new Intent(Level2.this, Level3.class);
                            startActivity(level3);
                        }
                    });

                    nextLevel.setButton(AlertDialog.BUTTON_NEGATIVE, "NON", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    nextLevel.show();
                }
                Log.i("DEBUG", "cmp: "+cmp);

            }}}
    public void onClick(View v){
        valide(v);

    }}

*/








package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Level2 extends AppCompatActivity  implements View.OnClickListener{
    private TextView enigme, quiSuis, res;
    private EditText ansewerEnigm;
    private Button btnValide, btnFinish;
    private String[] enigmes  = new String[5];
    private String[] ansewers = new String[5];
    private  int cmp = 0;
    Chronometer chronometre;
    private static final String MY_BACKUP_FILE = "MY_BACKUP_FILE ";
    private static final String MY_BACKUP_FILE_TIME2 = "MY_BACKUP_FILE_TIME2 ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        enigmes[0]  = "rtetou (animal)";
        enigmes[1]  = "brcoita (fruit)";
        enigmes[2]  = "trahacuti (legume)";
        enigmes[3]  = "ongare (fruit)";

        ansewers[0] = "tortue";
        ansewers[1] = "abricot";
        ansewers[2] = "artichaut";
        ansewers[3] = "orange";

        //btnLunch =findViewById(R.id.btnLunch);
        enigme = findViewById(R.id.enigme);
        quiSuis = findViewById(R.id.quiSuis);
        ansewerEnigm = findViewById(R.id.ansewerEnigm);
        btnValide = findViewById(R.id.btnValide);
        btnFinish = findViewById(R.id.btnfinish);
        chronometre = findViewById(R.id.chronometre);
        res = findViewById(R.id.res);
        enigme.setText(enigmes[0]);
        ansewerEnigm.setText("");
        quiSuis.setText("Qui suis-je ? ");
        btnValide.setOnClickListener(this);
        btnFinish.setOnClickListener(this);



    }
    public void initialisation(String s){
        s = ansewerEnigm.getText().toString();

    }
    public void valide(View v){
        int i = 0, j = 0;
        String s = ansewerEnigm.getText().toString();
        Intent level1 = getIntent();
        float time = level1.getFloatExtra("time1", 0.0F);
        String name = level1.getStringExtra("PSEUDO");
        Log.i("DEBUG", "name2 "+name);


        if (v == btnValide) {
            // un chronometre est demaré lors d'un clique que sur btnValide
            chronometre.start();

                for (i = 0; i < enigmes.length - 1; ++i) {
                        if (s.equals(ansewers[i])) {
                            enigme.setText(enigmes[i + 1]);
                            ansewerEnigm.setText("");
                            res.setText(s);
                            cmp += 1;
                            i++;
                            res.setText(" ");
                            Log.i("DEBUG", "i: " + j);
                        } else {

                            ansewerEnigm.setText("");
                        }}
                        Log.i("DEBUG", "i2: " + i);
                        Log.i("DEBUG", "taille: " + enigmes.length);

                        if (cmp == 4) {
                            // le chrono est arreté si l'utilisation à saisi les 4 bonnes reponses
                            chronometre.stop();

                            //
                            double elapsedMillis = SystemClock.elapsedRealtime() - chronometre.getBase();
                            DecimalFormat df = new DecimalFormat("0.0");
                            float elapsedMinut = (float) Double.parseDouble(df.format(elapsedMillis / 60000));
                            getSharedPreferences(MY_BACKUP_FILE, MODE_PRIVATE).edit().putFloat(MY_BACKUP_FILE_TIME2, elapsedMinut).apply();
                            // garder que un chiffre apres la virgule
                            AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                            nextLevel.setTitle("EXERCICE 3: MEMOIRE");
                            nextLevel.setMessage("Cet exercice vous fera travailler votre capacité de stocker, de mettre à jour de et de recuperer des information au fil du temps " +
                                    "\nL'exercice 3 consiste à memoriser une grille alpha-numérique qui est visible qu'au bout de 10s");
                            nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "GO", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent level3 = new Intent(Level2.this, Level3.class);
                                    level3.putExtra("time2", elapsedMinut);
                                    level3.putExtra("time1", time);
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

            }

        Log.i("DEBUG", "cmp: "+cmp);

            }

    public void onClick(View v){

        valide(v);
        if (v == btnFinish){
            moveTaskToBack(true);
            Process.killProcess(Process.myPid());
            System.exit(1);
        }        }
                }





