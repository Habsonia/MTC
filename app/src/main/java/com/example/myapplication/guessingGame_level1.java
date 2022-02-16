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
import android.widget.TextView;

import java.text.DecimalFormat;


public class guessingGame_level1 extends AppCompatActivity implements View.OnClickListener {
    private Button btnOk, btnCancel;
    private TextView Result, setPs;
    private EditText enterNumber;
    private int secreteValue;
    private int cmp;
    private String name;
    String time;
    Chronometer chronometre;
    private static final String MY_BACKUP_FILE = "MY_BACKUP_FILE ";
    private static final String MY_BACKUP_FILE_TIME = "MY_BACKUP_FILE_TIME ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game_level1);
        chronometre = findViewById(R.id.chronometre);
        btnOk = findViewById(R.id.btnOk);
        Result = findViewById(R.id.Result);
        setPs = findViewById(R.id.setPs);
        enterNumber = findViewById(R.id.enterNumber);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
        btnOk.setOnClickListener(this);
        setPs.setText("Saisissez une valeur !");
        this.initialisation();

    }
    // initialisation
    public void initialisation(){
        cmp = 0;
        secreteValue = 1 + (int) (Math.random() * 100);
        Log.i("DEBUG", "valeur secrete: "+ secreteValue);

        Result.setText("");
        enterNumber.setText("");
        enterNumber.requestFocus();

    }

    @Override
    public void onClick(View v) {
        Intent main = getIntent();
        String ps = main.getStringExtra("PSEUDO");
        String res = enterNumber.getText().toString();
        int resInteger = Integer.parseInt(res);
        cmp++;

        if (v == btnOk) {
            chronometre.start();
            if (res.equals("")) {
                return;
            }

            if (resInteger == secreteValue) {
                chronometre.stop();
                double elapsedMillis = SystemClock.elapsedRealtime() - chronometre.getBase();
                DecimalFormat df = new DecimalFormat("0.0");
                float elapsedMinut = (float) Double.parseDouble(df.format(elapsedMillis / 60000));
                getSharedPreferences(MY_BACKUP_FILE, MODE_PRIVATE).edit().putFloat(MY_BACKUP_FILE_TIME, elapsedMinut).apply();
                AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                nextLevel.setTitle("EXERCICE2: ATTENTION");
                nextLevel.setMessage("L'exercice 2 vous fera travailler votre capacité de percevoir de nouvelles informations" +
                        "\nCet exercice consiste à retrouver le mots d'origine à partir de lettes mélanges, pour vous aider, la catégorie du mot à trouver est entre parenthèses.");
                nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "GO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent level2 = new Intent(guessingGame_level1.this, Level2.class);
                        level2.putExtra("time1", elapsedMinut);
                        level2.putExtra("PSEUDO", ps);
                        startActivity(level2);
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


            } else if (resInteger > secreteValue) {
                Result.setText(("plus petite !!"));
            } else {
                Result.setText(("plus grande !!"));
            }

        }
        enterNumber.setText("");
        enterNumber.requestFocus();
        if (v == btnCancel) {

            moveTaskToBack(true);
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }}














