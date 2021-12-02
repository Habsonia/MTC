package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Level4 extends AppCompatActivity implements View.OnClickListener{
    private EditText reponse;
    private TextView resutlat;
    private Button btnVal;
    private ImageView img;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        reponse = findViewById(R.id.reponse);
        resutlat = findViewById(R.id.resultat);
        btnVal =findViewById(R.id.btnVal);
        img = findViewById(R.id.img);
        resutlat.setText("Combien de cheval y'a t-il sur cette photo?");
        btnVal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nmbr = reponse.getText().toString();
        if (nmbr.equals("")) {
            Toast.makeText(Level4.this,"Vous devez saisir une reponse pour pouvoir valider  ! ", Toast.LENGTH_SHORT).show();

        }
        else{
            if( v == btnVal){
                if (nmbr.equals("5")){

                AlertDialog nextLevel = new AlertDialog.Builder(this).create();
                nextLevel.setTitle("Bravo ! Vous avez passé  de temps pour reussir ce jeu !");
                nextLevel.setMessage("OUi : Recommencer une partie\nNON : Quitter le jeu ");
                nextLevel.setButton(AlertDialog.BUTTON_POSITIVE, "OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent level1 = new Intent(Level4.this, MainActivity.class);
                        startActivity(level1);
                    }
                });

                nextLevel.setButton(AlertDialog.BUTTON_NEGATIVE, "NON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                nextLevel.show();


        }}
            resutlat.setText("Regardez bien !");

    }
}}