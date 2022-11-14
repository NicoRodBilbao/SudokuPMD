package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationBarView;

public class MainWindow extends AppCompatActivity{
    private Button startButton = null;
    private ImageButton exitButton = null;
    private Spinner menu = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);
        exitButton = (ImageButton) findViewById(R.id.exitButton);
        menu = (Spinner) findViewById(R.id.spinner);

        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(menu.getSelectedItem().toString().equalsIgnoreCase("English")){
                    startButton.setText(R.string.start);
                }else{
                    startButton.setText(R.string.empezar);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                startButton.setText(R.string.empezar);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainWindow.this, DifficultyWindow.class);
                intent.putExtra("language", menu.getSelectedItem().toString());
                //TODO Add language
                startActivity(intent);
              finish();
            }
        }) ;

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.os.Process.killProcess(android.os.Process.myPid());
              finish();
            }
        });
    }
}
