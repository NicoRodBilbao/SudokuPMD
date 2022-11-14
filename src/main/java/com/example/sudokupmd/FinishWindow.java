package com.example.sudokupmd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;

import com.example.data.DbHelper;
import com.example.data.Score;

public class FinishWindow extends AppCompatActivity {

    private String currentUsername;
    private Difficulty currentDifficulty;
    private Result currentResult;
    private Time currentTime;

    private DbHelper dbHelper;
    private SQLiteDatabase db;

    private ArrayList<Score> scores;

    private TableLayout tbl;

    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_window);

        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener((a) -> {
            Intent i = new Intent(this, MainWindow.class);
            startActivity(i);
        });

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(FinishWindow.this);
        EditText input = new EditText(this);
        dialogBuilder.setTitle(getString(R.string.dialog_title));
        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(input);
        dialogBuilder.setPositiveButton(R.string.confirm, (DialogInterface.OnClickListener) (dialog, which) -> {
            this.currentUsername = input.getText().toString();
            this.run();
        });

        dialogBuilder.show();

    }

    private void run() {
        tbl = (TableLayout) findViewById(R.id.tblClasificacion);

        scores = new ArrayList<Score>();

        dbHelper = new DbHelper(FinishWindow.this);
        db = dbHelper.getWritableDatabase();

        if(db == null)
            Toast
                    .makeText(FinishWindow.this, "ERROR: Could not write to or access the database!", Toast.LENGTH_LONG)
                    .show();
        else {
            System.out.println("DB is working");
            // upload the current data to the DB
            this.uploadData();
            // fetch the latest data from the DB
            this.fetchData();
            // populate the scores table
            this.populateTable();
        }
    }

    /**
     * Save new data onto the database
     */
    private void uploadData() {
        ContentValues values = new ContentValues();
        values.put("name", this.currentUsername == null ? "USER" : this.currentUsername);
        values.put("difficulty", this.currentDifficulty == null ? "EASY" : this.currentDifficulty.toString());
        values.put("result", this.currentResult == null ? Result.DEFEAT.toString() : this.currentResult.toString());
        values.put("completion_time", this.currentTime == null ? "0" : this.currentTime.toString());
    }

    /**
     * Fetch the scores from the database
     */
    private void fetchData() {
        // Fetch the scores ordered by completion time
        Cursor cursor = db
                .rawQuery("SELECT * FROM " + DbHelper.TABLE_SCORES
                        + " ORDER BY completion_time ASC", null);
        // Store the scores to an arraylist
        while(cursor.moveToNext()) {
            Score score = new Score(
                    cursor.getString(1)
                    , Difficulty.valueOf(cursor.getString(2))
                    , Result.valueOf(cursor.getString(3))
                    , Time.valueOf(cursor.getString(4))
            );
            scores.add(score);
        }
        cursor.close();
    }

    /**
     * Fill out the table
     */
    @SuppressLint("DefaultLocale")
    private void populateTable() {
        // Filter the results according to difficulty
        ArrayList<Score> tableScores = new ArrayList<>();
        for (Score s : scores) {
            if(tableScores.size() >= 10)
                break;
            if (s.getDifficulty().equals(currentDifficulty)
                    && s.getResult().equals(Result.WIN))
                tableScores.add(s);
        }
        // Fill out the table with the results
        for (int i = 0; i < tableScores.size(); i++) {
            TableRow tr = new TableRow(this);
            TextView tx = new TextView(this);
            tx.setText(
                    String.format("%d. %s - %s",
                            i + 1,
                            tableScores.get(i).getName(),
                            tableScores.get(i).getCompletion_time()));
            tr.addView(tx);
            tbl.addView(tr);
        }
        // If there are no scores to display show a message
        if(tableScores.size() == 0) {
            TableRow tr = new TableRow(this);
            TextView tx = new TextView(this);
            tx.setText(R.string.there_are_no_saved_scores_for_this_difficulty);
            tr.addView(tx);
            tbl.addView(tr);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK) {
            this.currentDifficulty = Difficulty.valueOf(data.getStringExtra("Difficulty"));
            this.currentTime = new Time(data.getIntExtra("Time", 0) * 1000L);
            this.currentResult = Result.valueOf(data.getStringExtra("Result"));
        }
    }
}
