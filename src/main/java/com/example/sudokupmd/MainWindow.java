package com.example.sudokupmd.sudokupmd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.sudokupmd.R;
import com.example.sudokupmd.sudokupmd.LaguageEnum;

public class MainWindow extends AppCompatActivity {

    private Button startButton = null;
    private ImageButton exitButton = null;
    private Spinner menu = null;
    public static final int GameWindow = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        exitButton = findViewById(R.id.exitButton);
        menu = (Spinner) findViewById(R.id.spinnerMenu);

        menu.setAdapter(new ArrayAdapter<LaguageEnum>(this, android.R.layout.simple_spinner_item, LaguageEnum.values()));

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, GameWindow.class);
                startActivityForResult(intent, GameWindow);
            }
        }) ;

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
