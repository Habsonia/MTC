package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Process;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnStart, btnC;
    private EditText pseudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        btnC = findViewById(R.id.btnC);


        pseudo = findViewById(R.id.pseudo);
        btnC.setOnClickListener(this);
        btnStart.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String ps = pseudo.getText().toString();
        // un clic sur ce bouton permet de quitter l'application
        if (v == btnC){
            moveTaskToBack(true);
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
        if (ps.equals(""))
                Toast.makeText(MainActivity.this,"Veuillez renter un pseudo pour commencer le jeu !", Toast.LENGTH_SHORT).show();
        else{
            // un clic sur le bouton provoque un alertDialog qui va permettre de passer à l'activité suivante
            if(v == btnStart){

                AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                nextLevel.setTitle("EXERCICE1 : RAPIDITE");
                nextLevel.setMessage("L'exercice1 vous fera travailler votre capacité de traiter l'information rapidement." +
                                     "\nCet exercice consiste à touver la valeur secrete entre 0 et 100 et le programme vous indique si vous devez saisir une valeur" +
                                    " plus grande ou plus petit, à vous de jouer !");
                nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "GO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent game = new Intent(MainActivity.this, guessingGame_level1.class);
                        game.putExtra("PSEUDO", ps);
                        startActivity(game);
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

    }

}



