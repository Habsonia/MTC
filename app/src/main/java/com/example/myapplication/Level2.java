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
    private Button btnValide, btnValid2, btnValid3, btnValid4, btnFinish;
    private String[] enigmes  = new String[4];
    private String[] ansewers = new String[4];
    private boolean bool = true;
    private  int cmp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        enigmes[0]  = "rtetou (animal)";
        enigmes[1]  = "brcoita (fruit)";
        enigmes[2]  = "trahacuti (legumes)";
        enigmes[3]  = "mmope (fruit)";

        ansewers[0] = "tortue";
        ansewers[1] = "abricot";
        ansewers[2] = "artichaut";
       // ansewers[3] = "pomme";

        //btnLunch =findViewById(R.id.btnLunch);
        enigme = findViewById(R.id.enigme);
        quiSuis = findViewById(R.id.quiSuis);
        ansewerEnigm = findViewById(R.id.ansewerEnigm);
        btnValide = findViewById(R.id.btnValide);
        res = findViewById(R.id.res);
        enigme.setText(enigmes[0]);
        ansewerEnigm.setText("");
        quiSuis.setText("Qui suis-je ? ");
        btnValide.setOnClickListener(this);


    }
    public void initialisation(String s){
        s = ansewerEnigm.getText().toString();

    }
    public void valide(View v){
        int i = 0;
        String s = ansewerEnigm.getText().toString();
        if (v == btnValide) {
            for (i=0;i < enigmes.length - 1; i++) {

                if (s.equals(ansewers[i])) {
                    enigme.setText(enigmes[i +1]);
                    ansewerEnigm.setText("");
                    res.setText(s);
                    cmp += 1;
                    i++;
                    Log.i("DEBUG", "i: " + i);
                } else {
                    res.setText("Reflichissez bien");
                }
                Log.i("DEBUG", "i2: " + i);

            if (cmp == 3) {
                AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                nextLevel.setTitle("Bravo vous allez passer au niveau suivant ! ");
                nextLevel.setMessage("Vous avez un score de " + cmp + " sur " + enigmes.length);
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
        }

        Log.i("DEBUG", "cmp: "+cmp);

            }}

    public void onClick(View v){
        valide(v);
                }

                }



