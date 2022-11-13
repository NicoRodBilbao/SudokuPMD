package com.example.sudokupmd;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sudokupmd.Sudokus;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;

public class GameWindow extends AppCompatActivity implements View.OnClickListener {
    Difficulty dif;
    int[][] sudokuSol;
    int[][] sudokuTab;
    int selectedNumber=1;
    int selectedRow=1;
    int selectedCol=1;

    private TextView textViewTiempo;

    private Button btnRendirse;

    private GridLayout gLayoutTab;
    private GridLayout gLayoutBtn;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);
        gLayoutTab = (GridLayout) findViewById(R.id.gLayoutTab);
        textViewTiempo = (TextView)findViewById(R.id.textViewTiempo);

        Button myButton = null;
        for (int i=0;i<81;i++) { // Buttons on the board
            myButton = new Button(this);
            myButton.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            myButton.setText(Integer.valueOf(sudokuTab[(i+1)%9][(i+1)/9]));
            myButton.setBackgroundColor(getColor(R.color.white));
            myButton.setId(View.generateViewId());
            myButton.setOnClickListener(this);
            gLayoutTab.addView(myButton);
        }

        for (int i=0;i<9;i++) {
            myButton = new Button(this);
            myButton.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            myButton.setText(i+1);
            myButton.setBackgroundColor(getColor(R.color.white));
            myButton.setId(View.generateViewId());
            myButton.setOnClickListener(this);
            gLayoutBtn.addView(myButton);
        }
        btnRendirse = new Button(this);
        btnRendirse.setText(getText(R.string.rendirse));
        btnRendirse.setId(View.generateViewId());
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        int selectedId = view.getId();
        if (selectedId<=81) { // Button is on the board
            selectedRow = selectedId/9;
            selectedCol = selectedId%9;
            if (sudokuTab[selectedCol][selectedRow] == 0) { // Check if the number is not already occupied
                if (selectedNumber != 0) { // Make sure a number is selected
                    sudokuTab[selectedCol][selectedRow] = selectedNumber;
                    button.setText(selectedNumber);
                } else // No number selected
                    showAlert(getString(R.string.alertaPrev));
            } else { // Cell occupied
                showAlert(getString(R.string.alertaOcup));
            }
        } else {
            if (selectedId == 91) {
                //case 91: // Rendición
                Intent intentGame = new Intent(GameWindow.this, FinishWindow.class);
                intentGame.putExtra("Difficulty", dif);
                intentGame.putExtra("Time", 60);// TODO Time game
                intentGame.putExtra("Result", "DEFEAT");
                //TODO Add language
                startActivity(intentGame);
                //break;
            } else { // Selected number change (bottom buttons)
                selectedNumber = Integer.parseInt(String.valueOf(button.getText()));
            }
        }

        if (sudokuTab == sudokuSol) { // Condición de victoria
            Intent intentGame = new Intent(GameWindow.this, FinishWindow.class);
            intentGame.putExtra("Difficulty", dif);
            intentGame.putExtra("Time", 60);// TODO Time game
            intentGame.putExtra("Result","WIN");
            //TODO Add language
            startActivity(intentGame);
        } else {
            if (sudokuTab[selectedCol][selectedRow] != sudokuSol[selectedCol][selectedRow]) { // Condición de derrota
                Intent intentGame = new Intent(GameWindow.this, FinishWindow.class);
                intentGame.putExtra("Difficulty", dif);
                intentGame.putExtra("Time", 60);// TODO Time game
                intentGame.putExtra("Result","DEFEAT");
                //TODO Add language
                startActivity(intentGame);
            }
        }
    }

    private void showAlert(String alert) {
        Toast.makeText(this,alert,Toast.LENGTH_SHORT).show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dif = Difficulty.valueOf(data.getStringExtra("Difficulty"));
        if (dif.equals(Difficulty.EASY)) {
            sudokuTab = Sudokus.sudokuEasy;
            sudokuSol = Sudokus.sudokuEasySol;
        }
        if (dif.equals(Difficulty.MEDIUM)) {
            sudokuTab = Sudokus.sudokuMed;
            sudokuSol = Sudokus.sudokuMedSol;
        }
        if (dif.equals(Difficulty.HARD)) {
            sudokuTab = Sudokus.sudokuHard;
            sudokuSol = Sudokus.sudokuHardSol;
        }
    }
}