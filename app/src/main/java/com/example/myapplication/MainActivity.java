package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnStart, leve1, level2, level3, level4;
    private EditText pseudo;
    Chronometer chrono;
    long timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStart);
        leve1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);

        pseudo = findViewById(R.id.pseudo);
       // chrono = findViewById(R.id.chrono);
        chrono.setBase(SystemClock.elapsedRealtime());
        leve1.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        level2.setOnClickListener(this);
        level3.setOnClickListener(this);
        level4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String ps = pseudo.getText().toString();
        if (ps.equals(""))
                Toast.makeText(MainActivity.this,"Veuillez renter un pseudo pour commencer le jeu !", Toast.LENGTH_SHORT).show();
        else{
            if(v == btnStart){
               Intent game = new Intent(MainActivity.this, guessingGame_level1.class);

                game.putExtra("PSEUDO", ps);
               startActivity(game);
           }

          /* if (v == leve1){
               chrono.start();
            }*/
           /*
           else if (v == level2){
                Intent l2 = new Intent(MainActivity.this, Level2.class);
                startActivity(l2);
            }
           else if (v == level3){
                Intent l3 = new Intent(MainActivity.this, Level3.class);
                startActivity(l3);
            }
            else if (v == level4){
                Intent l4 = new Intent(MainActivity.this, Level4.class);
                startActivity(l4);
                



                 <Chronometer
                android:layout_width="216dp"
                android:layout_height="wrap_content"
                android:layout_below="@+id/chrono"
                android:layout_centerHorizontal="true"
                android:layout_marginTop="20dp"
                android:background="#D3BBBB"
                android:gravity="center"
                android:padding="10dp"
                android:textColor="#f00"
                android:textStyle="bold"
                />

            }*/

    }

}}



