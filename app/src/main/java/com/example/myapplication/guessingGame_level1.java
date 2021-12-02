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
import android.widget.TextView;


public class guessingGame_level1 extends AppCompatActivity implements View.OnClickListener {
    private Button btnLevel2, btnOk, btnCancel, btnRec;
    private TextView Result, setPs, consigne;
    private EditText enterNumber;
    private int secreteValue;
    private int cmp;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game_level1);
        btnLevel2 = findViewById(R.id.btnRec);
        btnOk = findViewById(R.id.btnOk);
        Result = findViewById(R.id.Result);
        setPs = findViewById(R.id.setPs);
        consigne = findViewById(R.id.consigne);
        enterNumber = findViewById(R.id.enterNumber);

        btnLevel2.setOnClickListener(this);
        btnOk.setOnClickListener(this);
        this.setPseudo(setPs);
        this.initialisation();
    }
    public void setPseudo(TextView name){
        Intent main = getIntent();
        String ps = main.getStringExtra("PSEUDO");
        name.setText("Bienvenue " + ps+ " ce jeu consiste à vous faire travailler votre rapidité !");
    }
    public void initialisation(){
        cmp = 0;
        secreteValue = 1 + (int) (Math.random() * 100);
        Log.i("DEBUG", "valeur secrete: "+ secreteValue);
        consigne.setText("Ce jeu consiste à touver la valeur secrete entre 0 et 100 et le programme vous indique si vous devez saisir une valeur" +
                "plus grande ou plus petit, à vous de jouer !" +
                "\nSaisissez une valeur");
        Result.setText("");
        enterNumber.setText("");
        enterNumber.requestFocus();

    }

    @Override
    public void onClick(View v) {
        String res = enterNumber.getText().toString();
        int resInteger = Integer.valueOf(res);
        cmp++;

        if (v == btnOk) {
            if (res.equals("")) {
                return;
            }
            
            if(resInteger == secreteValue) {
                Result.setText(("Bravo !!" +"\n"+"vous l'avez trouver au bout de " + cmp+ " tentatives"));
                    AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                    nextLevel.setTitle("Bravo vous allez passer au jeu suivant! ");
                    nextLevel.setMessage("Ce jeu à pour but de vos faire travailler votre reflixion\nOUi : Recommencer une partie\nNON : Quitter le jeu ");
                    nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "OUI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent level2 = new Intent(guessingGame_level1.this, Level2.class);
                            startActivity(level2);
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

            else if(resInteger > secreteValue) {
                Result.setText(("plus petite !!"));
            }
            else{
                Result.setText(("plus grande !!"));
            }
        }
        enterNumber.setText("");
        enterNumber.requestFocus();
        if (v == btnCancel) {
            finish();
        }
        if(v == btnRec){
            initialisation();
        } }}














