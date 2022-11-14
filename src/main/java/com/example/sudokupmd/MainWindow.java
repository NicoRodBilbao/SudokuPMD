package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainWindow extends AppCompatActivity {
    private Button startButton = null;
    private ImageButton exitButton = null;
    private Spinner menu = null;
    private ImageButton menuButton = null;
    public static final int DifficultyWindow = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        exitButton = (ImageButton) findViewById(R.id.exitButton);
        menuButton = (ImageButton) findViewById(R.id.menuButton);

        menu.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, LaguageEnum.values()));

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, DifficultyWindow.class);
                startActivityForResult(intent, DifficultyWindow);
            }
        }) ;

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.showContextMenu();
                if(menu.getSelectedItem().toString().equalsIgnoreCase(LaguageEnum.ENUM1.toString())){
                    startButton.setText(R.string.start);
                }if(menu.getSelectedItem().toString().equalsIgnoreCase(LaguageEnum.ENUM2.toString())){
                    startButton.setText(R.string.empezar);
                }
            }
        });
    }
}