package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class GameWindow extends AppCompatActivity implements View.OnClickListener {
    Difficulty dif;
    int[][] sudokuSol;
    int[][] sudokuTab;
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



        Bundle extra = getIntent().getExtras();
        dif = Difficulty.valueOf(extra.getString("Difficulty"));

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

        System.out.println(dif);
        setContentView(R.layout.activity_game_window);
        gLayoutTab = (GridLayout) findViewById(R.id.gLayoutTab);
        gLayoutBtn = (GridLayout) findViewById(R.id.gLayoutBtn);
        textViewTiempo = (TextView) findViewById(R.id.textViewTiempo);
        ImageButton myButton = null;
        for (int i = 0; i < 81; i++) { // Buttons on the board
            myButton = new ImageButton(this);

            System.out.println((((i) % 9)) + "," + (((i) / 9)) + "," + i);
            //if (Integer.valueOf(sudokuTab[(((i) / 9))][(((i) % 9))]) == 0)
                setNum(Integer.valueOf(sudokuTab[(((i) / 9))][(((i) % 9))]),myButton);
            //else
                //myButton.setText(Integer.valueOf(sudokuTab[(((i) / 9))][(((i) % 9))]) + "");

            myButton.setId(View.generateViewId());
            myButton.setOnClickListener(this);

            myButton.setBackgroundResource(R.drawable.border);
            gLayoutTab.addView(myButton);
        }

        for (int i = 0; i < 9; i++) {
            myButton = new ImageButton(this);
            setNum((i+1),myButton);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myButton.setBackgroundColor(getColor(R.color.background));
            }
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
        ImageButton button = (ImageButton) view;
        int selectedId = view.getId();
        if (selectedId <= 81) { // Button is on the board
            selectedCol = (selectedId-1) / 9;
            selectedRow = ((selectedId-1) % 9);
            System.out.println(selectedId);
            System.out.println(selectedCol+","+selectedRow);
            if (sudokuTab[selectedCol][selectedRow] == 0) { // Check if the number is not already occupied
                if (selectedNumber != 0) { // Make sure a number is selected
                    sudokuTab[selectedCol][selectedRow] = selectedNumber;
                    setNum(selectedNumber, button);
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
                selectedNumber = selectedId-81;
            }
        }

        if (sudokuTab == sudokuSol) { // Condición de victoria
            stopTimer();
            Intent intentGame = new Intent(GameWindow.this, FinishWindow.class);
            intentGame.putExtra("Difficulty", dif);
            intentGame.putExtra("Time", time);// TODO Time game
            intentGame.putExtra("Result", Result.WIN);
            //TODO Add language
            startActivity(intentGame);
        } else { // Condición de derrota movimiento erróneo
            //System.out.println(sudokuTab[selectedCol][selectedRow] + "," + sudokuSol[selectedCol][selectedRow]);
            if (sudokuTab[selectedCol][selectedRow] != sudokuSol[selectedCol][selectedRow] && isDone) { // Condición de derrota
                stopTimer();
                Intent intentGame = new Intent(GameWindow.this, FinishWindow.class);
                intentGame.putExtra("Difficulty", dif);
                intentGame.putExtra("Time", time);// TODO Time game
                intentGame.putExtra("Result", Result.DEFEAT);
                //TODO Add language
                startActivity(intentGame);
            }
        }
    }

    private void setNum(int num, ImageButton ib) {
        switch (num){
            case 1:
                ib.setImageResource(R.drawable.num1);
                break;
            case 2:
                ib.setImageResource(R.drawable.num2);
                break;
            case 3:
                ib.setImageResource(R.drawable.num3);
                break;
            case 4:
                ib.setImageResource(R.drawable.num4);
                break;
            case 5:
                ib.setImageResource(R.drawable.num5);
                break;
            case 6:
                ib.setImageResource(R.drawable.num6);
                break;
            case 7:
                ib.setImageResource(R.drawable.num7);
                break;
            case 8:
                ib.setImageResource(R.drawable.num8);
                break;
            case 9:
                ib.setImageResource(R.drawable.num9);
                break;
            case 0:
                ib.setImageResource(R.drawable.numno);
                break;
        }
    }

    private void showAlert(String alert) {
        Toast.makeText(this, alert, Toast.LENGTH_SHORT).show();
    }
}