package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainWindow extends AppCompatActivity implements View.OnClickListener {

    private Button button;
private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        mediaPlayer  = MediaPlayer.create(this,R.raw.music);
        mediaPlayer.start();
    }

    @Override
    public void onClick(View view) {
        Intent intentDificcult = new Intent(MainWindow.this, GameWindow.class);
        intentDificcult.putExtra("Difficulty", Difficulty.HARD);
        startActivity(intentDificcult);
    }
}