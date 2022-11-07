package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.sudokupmd.Sudokus;

public class GameWindow extends AppCompatActivity implements View.OnClickListener {
    private int[][] sudokuEasySol = Sudokus.sudokuEasySol;
    private int[][] sudokuMedSol = Sudokus.sudokuMedSol;
    private int[][] sudokuHardSol = Sudokus.sudokuHardSol;
    private int[][] sudokuEasy = Sudokus.sudokuEasy;
    private int[][] sudokuMed = Sudokus.sudokuMed;
    private int[][] sudokuHard = Sudokus.sudokuHard;

    private Button btn1_1;
    private Button btn1_2;
    private Button btn1_3;
    private Button btn1_4;
    private Button btn1_5;
    private Button btn1_6;
    private Button btn1_7;
    private Button btn1_8;
    private Button btn1_9;
    private Button btn2_1;
    private Button btn2_2;
    private Button btn2_3;
    private Button btn2_4;
    private Button btn2_5;
    private Button btn2_6;
    private Button btn2_7;
    private Button btn2_8;
    private Button btn2_9;
    private Button btn3_1;
    private Button btn3_2;
    private Button btn3_3;
    private Button btn3_4;
    private Button btn3_5;
    private Button btn3_6;
    private Button btn3_7;
    private Button btn3_8;
    private Button btn3_9;
    private Button btn4_1;
    private Button btn4_2;
    private Button btn4_3;
    private Button btn4_4;
    private Button btn4_5;
    private Button btn4_6;
    private Button btn4_7;
    private Button btn4_8;
    private Button btn4_9;
    private Button btn5_1;
    private Button btn5_2;
    private Button btn5_3;
    private Button btn5_4;
    private Button btn5_5;
    private Button btn5_6;
    private Button btn5_7;
    private Button btn5_8;
    private Button btn5_9;
    private Button btn6_1;
    private Button btn6_2;
    private Button btn6_3;
    private Button btn6_4;
    private Button btn6_5;
    private Button btn6_6;
    private Button btn6_7;
    private Button btn6_8;
    private Button btn6_9;
    private Button btn7_1;
    private Button btn7_2;
    private Button btn7_3;
    private Button btn7_4;
    private Button btn7_5;
    private Button btn7_6;
    private Button btn7_7;
    private Button btn7_8;
    private Button btn7_9;
    private Button btn8_1;
    private Button btn8_2;
    private Button btn8_3;
    private Button btn8_4;
    private Button btn8_5;
    private Button btn8_6;
    private Button btn8_7;
    private Button btn8_8;
    private Button btn8_9;
    private Button btn9_1;
    private Button btn9_2;
    private Button btn9_3;
    private Button btn9_4;
    private Button btn9_5;
    private Button btn9_6;
    private Button btn9_7;
    private Button btn9_8;
    private Button btn9_9;

    private GridLayout gLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);
        gLayout = (GridLayout) findViewById(R.id.gLayout);

        //Row 1
        // Button 1_1
        btn1_1 = new Button(this);
        btn1_1.setText(getText(R.string.empty));
        btn1_1.setId(View.generateViewId());
        // Button 1_2
        btn1_2 = new Button(this);
        btn1_2.setText(getText(R.string.empty));
        btn1_2.setId(View.generateViewId());
        // Button 1_3
        btn1_3 = new Button(this);
        btn1_3.setText(getText(R.string.empty));
        btn1_3.setId(View.generateViewId());
        // Button 1_4
        btn1_4 = new Button(this);
        btn1_4.setText(getText(R.string.empty));
        btn1_4.setId(View.generateViewId());
        // Button 1_5
        btn1_5 = new Button(this);
        btn1_5.setText(getText(R.string.empty));
        btn1_5.setId(View.generateViewId());
        // Button 1_6
        btn1_6 = new Button(this);
        btn1_6.setText(getText(R.string.empty));
        btn1_6.setId(View.generateViewId());
        // Button 1_7
        btn1_7 = new Button(this);
        btn1_7.setText(getText(R.string.empty));
        btn1_7.setId(View.generateViewId());
        // Button 1_8
        btn1_8 = new Button(this);
        btn1_8.setText(getText(R.string.empty));
        btn1_8.setId(View.generateViewId());
        // Button 1_9
        btn1_9 = new Button(this);
        btn1_9.setText(getText(R.string.empty));
        btn1_9.setId(View.generateViewId());

        //Row 2
        // Button 2_1
        btn2_1 = new Button(this);
        btn2_1.setText(getText(R.string.empty));
        btn2_1.setId(View.generateViewId());
        // Button 2_2
        btn2_2 = new Button(this);
        btn2_2.setText(getText(R.string.empty));
        btn2_2.setId(View.generateViewId());
        // Button 2_3
        btn2_3 = new Button(this);
        btn2_3.setText(getText(R.string.empty));
        btn2_3.setId(View.generateViewId());
        // Button 2_4
        btn2_4 = new Button(this);
        btn2_4.setText(getText(R.string.empty));
        btn2_4.setId(View.generateViewId());
        // Button 2_5
        btn2_5 = new Button(this);
        btn2_5.setText(getText(R.string.empty));
        btn2_5.setId(View.generateViewId());
        // Button 2_6
        btn2_6 = new Button(this);
        btn2_6.setText(getText(R.string.empty));
        btn2_6.setId(View.generateViewId());
        // Button 2_7
        btn2_7 = new Button(this);
        btn2_7.setText(getText(R.string.empty));
        btn2_7.setId(View.generateViewId());
        // Button 2_8
        btn2_8 = new Button(this);
        btn2_8.setText(getText(R.string.empty));
        btn2_8.setId(View.generateViewId());
        // Button 2_9
        btn2_9 = new Button(this);
        btn2_9.setText(getText(R.string.empty));
        btn2_9.setId(View.generateViewId());

        //Row 3
        // Button 3_1
        btn3_1 = new Button(this);
        btn3_1.setText(getText(R.string.empty));
        btn3_1.setId(View.generateViewId());
        // Button 3_2
        btn3_2 = new Button(this);
        btn3_2.setText(getText(R.string.empty));
        btn3_2.setId(View.generateViewId());
        // Button 3_3
        btn3_3 = new Button(this);
        btn3_3.setText(getText(R.string.empty));
        btn3_3.setId(View.generateViewId());
        // Button 3_4
        btn3_4 = new Button(this);
        btn3_4.setText(getText(R.string.empty));
        btn3_4.setId(View.generateViewId());
        // Button 3_5
        btn3_5 = new Button(this);
        btn3_5.setText(getText(R.string.empty));
        btn3_5.setId(View.generateViewId());
        // Button 3_6
        btn3_6 = new Button(this);
        btn3_6.setText(getText(R.string.empty));
        btn3_6.setId(View.generateViewId());
        // Button 3_7
        btn3_7 = new Button(this);
        btn3_7.setText(getText(R.string.empty));
        btn3_7.setId(View.generateViewId());
        // Button 3_8
        btn3_8 = new Button(this);
        btn3_8.setText(getText(R.string.empty));
        btn3_8.setId(View.generateViewId());
        // Button 3_9
        btn3_9 = new Button(this);
        btn3_9.setText(getText(R.string.empty));
        btn3_9.setId(View.generateViewId());

        //Row 4
        // Button 4_1
        btn4_1 = new Button(this);
        btn4_1.setText(getText(R.string.empty));
        btn4_1.setId(View.generateViewId());
        // Button 4_2
        btn4_2 = new Button(this);
        btn4_2.setText(getText(R.string.empty));
        btn4_2.setId(View.generateViewId());
        // Button 4_3
        btn4_3 = new Button(this);
        btn4_3.setText(getText(R.string.empty));
        btn4_3.setId(View.generateViewId());
        // Button 4_4
        btn4_4 = new Button(this);
        btn4_4.setText(getText(R.string.empty));
        btn4_4.setId(View.generateViewId());
        // Button 4_5
        btn4_5 = new Button(this);
        btn4_5.setText(getText(R.string.empty));
        btn4_5.setId(View.generateViewId());
        // Button 4_6
        btn4_6 = new Button(this);
        btn4_6.setText(getText(R.string.empty));
        btn4_6.setId(View.generateViewId());
        // Button 4_7
        btn4_7 = new Button(this);
        btn4_7.setText(getText(R.string.empty));
        btn4_7.setId(View.generateViewId());
        // Button 4_8
        btn4_8 = new Button(this);
        btn4_8.setText(getText(R.string.empty));
        btn4_8.setId(View.generateViewId());
        // Button 4_9
        btn4_9 = new Button(this);
        btn4_9.setText(getText(R.string.empty));
        btn4_9.setId(View.generateViewId());

        // Row 5
        // Button 5_1
        btn5_1 = new Button(this);
        btn5_1.setText(getText(R.string.empty));
        btn5_1.setId(View.generateViewId());
        // Button 5_2
        btn5_2 = new Button(this);
        btn5_2.setText(getText(R.string.empty));
        btn5_2.setId(View.generateViewId());
        // Button 5_3
        btn5_3 = new Button(this);
        btn5_3.setText(getText(R.string.empty));
        btn5_3.setId(View.generateViewId());
        // Button 5_4
        btn5_4 = new Button(this);
        btn5_4.setText(getText(R.string.empty));
        btn5_4.setId(View.generateViewId());
        // Button 5_5
        btn5_5 = new Button(this);
        btn5_5.setText(getText(R.string.empty));
        btn5_5.setId(View.generateViewId());
        // Button 5_6
        btn5_6 = new Button(this);
        btn5_6.setText(getText(R.string.empty));
        btn5_6.setId(View.generateViewId());
        // Button 5_7
        btn5_7 = new Button(this);
        btn5_7.setText(getText(R.string.empty));
        btn5_7.setId(View.generateViewId());
        // Button 5_8
        btn5_8 = new Button(this);
        btn5_8.setText(getText(R.string.empty));
        btn5_8.setId(View.generateViewId());
        // Button 5_9
        btn5_9 = new Button(this);
        btn5_9.setText(getText(R.string.empty));
        btn5_9.setId(View.generateViewId());

        // Row 6
        // Button 6_1
        btn6_1 = new Button(this);
        btn6_1.setText(getText(R.string.empty));
        btn6_1.setId(View.generateViewId());
        // Button 6_2
        btn6_2 = new Button(this);
        btn6_2.setText(getText(R.string.empty));
        btn6_2.setId(View.generateViewId());
        // Button 6_3
        btn6_3 = new Button(this);
        btn6_3.setText(getText(R.string.empty));
        btn6_3.setId(View.generateViewId());
        // Button 6_4
        btn6_4 = new Button(this);
        btn6_4.setText(getText(R.string.empty));
        btn6_4.setId(View.generateViewId());
        // Button 6_5
        btn6_5 = new Button(this);
        btn6_5.setText(getText(R.string.empty));
        btn6_5.setId(View.generateViewId());
        // Button 6_6
        btn6_6 = new Button(this);
        btn6_6.setText(getText(R.string.empty));
        btn6_6.setId(View.generateViewId());
        // Button 6_7
        btn6_7 = new Button(this);
        btn6_7.setText(getText(R.string.empty));
        btn6_7.setId(View.generateViewId());
        // Button 6_8
        btn6_8 = new Button(this);
        btn6_8.setText(getText(R.string.empty));
        btn6_8.setId(View.generateViewId());
        // Button 6_9
        btn6_9 = new Button(this);
        btn6_9.setText(getText(R.string.empty));
        btn6_9.setId(View.generateViewId());

        // Row 7
        // Button 7_1
        btn7_1 = new Button(this);
        btn7_1.setText(getText(R.string.empty));
        btn7_1.setId(View.generateViewId());
        // Button 7_2
        btn7_2 = new Button(this);
        btn7_2.setText(getText(R.string.empty));
        btn7_2.setId(View.generateViewId());
        // Button 7_3
        btn7_3 = new Button(this);
        btn7_3.setText(getText(R.string.empty));
        btn7_3.setId(View.generateViewId());
        // Button 7_4
        btn7_4 = new Button(this);
        btn7_4.setText(getText(R.string.empty));
        btn7_4.setId(View.generateViewId());
        // Button 7_5
        btn7_5 = new Button(this);
        btn7_5.setText(getText(R.string.empty));
        btn7_5.setId(View.generateViewId());
        // Button 7_6
        btn7_6 = new Button(this);
        btn7_6.setText(getText(R.string.empty));
        btn7_6.setId(View.generateViewId());
        // Button 7_7
        btn7_7 = new Button(this);
        btn7_7.setText(getText(R.string.empty));
        btn7_7.setId(View.generateViewId());
        // Button 7_8
        btn7_8 = new Button(this);
        btn7_8.setText(getText(R.string.empty));
        btn7_8.setId(View.generateViewId());
        // Button 7_9
        btn7_9 = new Button(this);
        btn7_9.setText(getText(R.string.empty));
        btn7_9.setId(View.generateViewId());

        // Rows 8
        // Button 8_1
        btn8_1 = new Button(this);
        btn8_1.setText(getText(R.string.empty));
        btn8_1.setId(View.generateViewId());
        // Button 8_2
        btn8_2 = new Button(this);
        btn8_2.setText(getText(R.string.empty));
        btn8_2.setId(View.generateViewId());
        // Button 8_3
        btn8_3 = new Button(this);
        btn8_3.setText(getText(R.string.empty));
        btn8_3.setId(View.generateViewId());
        // Button 8_4
        btn8_4 = new Button(this);
        btn8_4.setText(getText(R.string.empty));
        btn8_4.setId(View.generateViewId());
        // Button 8_5
        btn8_5 = new Button(this);
        btn8_5.setText(getText(R.string.empty));
        btn8_5.setId(View.generateViewId());
        // Button 8_6
        btn8_6 = new Button(this);
        btn8_6.setText(getText(R.string.empty));
        btn8_6.setId(View.generateViewId());
        // Button 8_7
        btn8_7 = new Button(this);
        btn8_7.setText(getText(R.string.empty));
        btn8_7.setId(View.generateViewId());
        // Button 8_8
        btn8_8 = new Button(this);
        btn8_8.setText(getText(R.string.empty));
        btn8_8.setId(View.generateViewId());
        // Button 8_9
        btn8_9 = new Button(this);
        btn8_9.setText(getText(R.string.empty));
        btn8_9.setId(View.generateViewId());

        // Row 9
        // Button 9_9
        btn9_1 = new Button(this);
        btn9_1.setText(getText(R.string.empty));
        btn9_1.setId(View.generateViewId());
        // Button 9_9
        btn9_2 = new Button(this);
        btn9_2.setText(getText(R.string.empty));
        btn9_2.setId(View.generateViewId());
        // Button 9_9
        btn9_3 = new Button(this);
        btn9_3.setText(getText(R.string.empty));
        btn9_3.setId(View.generateViewId());
        // Button 9_9
        btn9_4 = new Button(this);
        btn9_4.setText(getText(R.string.empty));
        btn9_4.setId(View.generateViewId());
        // Button 9_9
        btn9_5 = new Button(this);
        btn9_5.setText(getText(R.string.empty));
        btn9_5.setId(View.generateViewId());
        // Button 9_9
        btn9_6 = new Button(this);
        btn9_6.setText(getText(R.string.empty));
        btn9_6.setId(View.generateViewId());
        // Button 9_9
        btn9_7 = new Button(this);
        btn9_7.setText(getText(R.string.empty));
        btn9_7.setId(View.generateViewId());
        // Button 9_9
        btn9_8 = new Button(this);
        btn9_8.setText(getText(R.string.empty));
        btn9_8.setId(View.generateViewId());
        // Button 9_9
        btn9_9 = new Button(this);
        btn9_9.setText(getText(R.string.empty));
        btn9_9.setId(View.generateViewId());
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
            case 21:
                break;
            case 22:
                break;
            case 23:
                break;
            case 24:
                break;
            case 25:
                break;
            case 26:
                break;
            case 27:
                break;
            case 28:
                break;
            case 29:
                break;
            case 30:
                break;
            case 31:
                break;
            case 32:
                break;
            case 33:
                break;
            case 34:
                break;
            case 35:
                break;
            case 36:
                break;
            case 37:
                break;
            case 38:
                break;
            case 39:
                break;
            case 40:
                break;
            case 41:
                break;
            case 42:
                break;
            case 43:
                break;
            case 44:
                break;
            case 45:
                break;
            case 46:
                break;
            case 47:
                break;
            case 48:
                break;
            case 49:
                break;
            case 50:
                break;
            case 51:
                break;
            case 52:
                break;
            case 53:
                break;
            case 54:
                break;
            case 55:
                break;
            case 56:
                break;
            case 57:
                break;
            case 58:
                break;
            case 59:
                break;
            case 60:
                break;
            case 61:
                break;
            case 62:
                break;
            case 63:
                break;
            case 64:
                break;
            case 65:
                break;
            case 66:
                break;
            case 67:
                break;
            case 68:
                break;
            case 69:
                break;
            case 70:
                break;
            case 71:
                break;
            case 72:
                break;
            case 73:
                break;
            case 74:
                break;
            case 75:
                break;
            case 76:
                break;
            case 77:
                break;
            case 78:
                break;
            case 79:
                break;
            case 80:
                break;
            case 81:
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

}