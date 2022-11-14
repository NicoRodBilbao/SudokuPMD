package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DifficultyWindow extends AppCompatActivity implements View.OnClickListener {
    private ImageButton imgBtnEasy;
    private ImageButton imgBtnMedium;
    private ImageButton imgBtnDifficult;
    private ImageButton imgBtnBack;
    private TextView txtEasy;
    private TextView txtMedium;
    private TextView txtHard;
    private Language language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getIntent().getExtras();
        language = Language.valueOf(extra.getString("Language").toUpperCase());
        setContentView(R.layout.activity_difficulty_window);
        imgBtnEasy = findViewById(R.id.imgBtnFacil);
        imgBtnMedium = findViewById(R.id.imgBtnMedio);
        imgBtnDifficult = findViewById(R.id.imgBtnDificil);
        imgBtnBack = findViewById(R.id.imgBtnVolver);
        txtEasy = findViewById(R.id.txtFacil);
        txtMedium = findViewById(R.id.txtMedio);
        txtHard = findViewById(R.id.txtDificil);


        if(language.equals("ENGLISH")){
            txtEasy.setText(getText(R.string.easy));
            txtMedium.setText(getText(R.string.medium));
            txtHard.setText(getText(R.string.dificil));
        }

        imgBtnEasy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {easyOnclick();}
        } );

        imgBtnMedium.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediumOnclick();
            }
        } );

        imgBtnDifficult.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hardOnclick();
            }
        } );

        imgBtnBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackOnClick();
            }
        } );

    }

    /**
     * This method open the GameWindow in difficult difficulty
     */
    private void easyOnclick() {
        Intent intentEasy = new Intent(DifficultyWindow.this, GameWindow.class);
        intentEasy.putExtra("Difficulty", Difficulty.EASY.toString());
        startActivity(intentEasy);
        finish();
    }

    /**
     * This method open the GameWindow in medium difficulty
     */
    private void mediumOnclick() {
        Intent intentMedium = new Intent(DifficultyWindow.this, GameWindow.class);
        intentMedium.putExtra("Difficulty", Difficulty.MEDIUM.toString());
        startActivity(intentMedium);
        finish();
    }

    /**
     * This method open the GameWindow in difficult difficulty
     */

    private void hardOnclick() {
        Intent intentHard = new Intent(DifficultyWindow.this, GameWindow.class);
        intentHard.putExtra("Difficulty", Difficulty.HARD.toString());
        startActivity(intentHard);
        finish();
    }

    /**
     * This method goes back to the MainWindow
     */
    private void goBackOnClick() {
        Intent intentGoBack = new Intent(DifficultyWindow.this, MainWindow.class);
        startActivity(intentGoBack);
        finish();
    }


    @Override
    public void onClick(View view) {

    }
}