package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class GameWindow extends AppCompatActivity implements View.OnClickListener {
    Difficulty dif;
    int[][] sudokuSol = Sudokus.sudokuEasySol;
    int[][] sudokuTab = Sudokus.sudokuEasy;
    int selectedNumber = 1;
    int selectedRow = 1;
    int selectedCol = 1;
    int time = 0;
    boolean isDone = false;

    private MediaPlayer mediaPlayer;

    private TextView textViewTiempo;

    private TimerTask timerTask;
    private Timer timer;

    private Button btnRendirse;

    private GridLayout gLayoutTab;
    private GridLayout gLayoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(dif);
        setContentView(R.layout.activity_game_window);
        gLayoutTab = (GridLayout) findViewById(R.id.gLayoutTab);
        gLayoutBtn = (GridLayout) findViewById(R.id.gLayoutBtn);
        textViewTiempo = (TextView) findViewById(R.id.textViewTiempo);

        Button myButton = null;
        for (int i = 0; i < 81; i++) { // Buttons on the board
            myButton = new Button(this);

            System.out.println((((i) % 9)) + "," + (((i) / 9)) + "," + i);
            if (Integer.valueOf(sudokuTab[(((i) / 9))][(((i) % 9))]) == 0)
                myButton.setText("");
            else
                myButton.setText(Integer.valueOf(sudokuTab[(((i) / 9))][(((i) % 9))]) + "");
            myButton.setBackgroundColor(Color.WHITE);
            myButton.setId(View.generateViewId());
            myButton.setOnClickListener(this);
            myButton.setMaxHeight(0);
            myButton.setMinWidth(0);
            myButton.setWidth(0);
            myButton.setHeight(0);
            myButton.setBackgroundResource(R.drawable.border);
            gLayoutTab.addView(myButton);
        }

        for (int i = 0; i < 9; i++) {
            myButton = new Button(this);
            myButton.setMaxHeight(0);
            myButton.setMinWidth(0);
            myButton.setWidth(0);
            myButton.setHeight(0);
            myButton.setText(i + 1 + "");
            myButton.setBackgroundColor(Color.WHITE);
            myButton.setId(View.generateViewId());
            myButton.setOnClickListener(this);
            gLayoutBtn.addView(myButton);
        }
        btnRendirse = (Button) findViewById(R.id.btnRendirse);
        btnRendirse.setText(getText(R.string.rendirse));
        btnRendirse.setId(View.generateViewId());
        btnRendirse.setOnClickListener(this);


        timer = new Timer();
        startTimer();
    }

    private void startTimer() {
        timerTask = new TimerTask() {
                @Override
                public void run () {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            time++;
                            textViewTiempo.setText(time + "");
                        }
                    });
                }

        };
        timer.scheduleAtFixedRate(timerTask,0,1000);
    }
    private void stopTimer() {
        timerTask.cancel();
    }

    @Override
    public void onClick(View view) {
        mediaPlayer  = MediaPlayer.create(this,R.raw.click);
        mediaPlayer.start();
        isDone = false;
        Button button = (Button) view;
        int selectedId = view.getId();
        if (selectedId <= 81) { // Button is on the board
            selectedRow = selectedId % 9;
            selectedCol = selectedId / 9;
            if (sudokuTab[selectedCol][selectedRow] == 0) { // Check if the number is not already occupied
                if (selectedNumber != 0) { // Make sure a number is selected
                    sudokuTab[selectedCol][selectedRow] = selectedNumber;
                    button.setText(selectedNumber + "");
                    isDone = true;
                } else // No number selected
                    showAlert(getString(R.string.alertaPrev));
            } else { // Cell occupied
                showAlert(getString(R.string.alertaOcup));
            }
        } else {
            if (selectedId == 91) {
                stopTimer();
                //case 91: // Rendición
                Intent intentGame = new Intent(GameWindow.this, FinishWindow.class);
                intentGame.putExtra("Difficulty", dif);
                intentGame.putExtra("Time", time);
                intentGame.putExtra("Result", Result.DEFEAT);
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
            intentGame.putExtra("Result", Result.WIN);
            //TODO Add language
            startActivity(intentGame);
        } else {
            System.out.println(sudokuTab[selectedCol][selectedRow] + "," + sudokuSol[selectedCol][selectedRow]);
            if (sudokuTab[selectedCol][selectedRow] != sudokuSol[selectedCol][selectedRow] && isDone) { // Condición de derrota
                Intent intentGame = new Intent(GameWindow.this, FinishWindow.class);
                intentGame.putExtra("Difficulty", dif);
                intentGame.putExtra("Time", 60);// TODO Time game
                intentGame.putExtra("Result", Result.DEFEAT);
                //TODO Add language
                startActivity(intentGame);
            }
        }
    }

    private void showAlert(String alert) {
        Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("A");
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