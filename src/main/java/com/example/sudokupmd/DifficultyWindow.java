package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DifficultyWindow extends AppCompatActivity implements View.OnClickListener {
    private ImageButton imgBtnSol;
    private ImageButton imgBtnCastillo;
    private ImageButton imgBtnCalavera;
    private ImageButton imgBtnFlecha;
    private TextView txtFacil;
    private TextView txtMedio;
    private TextView txtDificil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_window);
        imgBtnSol = findViewById(R.id.imgBtnFacil);
        imgBtnCastillo = findViewById(R.id.imgBtnMedio);
        imgBtnCalavera = findViewById(R.id.imgBtnDificil);
        imgBtnFlecha = findViewById(R.id.imgBtnFlecha);
        txtFacil = findViewById(R.id.txtFacil);
        txtMedio = findViewById(R.id.txtMedio);
        txtDificil = findViewById(R.id.txtDificil);

    }

    @Override
    public void onClick(View view) {

    }
}