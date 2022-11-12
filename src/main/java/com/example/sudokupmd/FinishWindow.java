package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.data.DbHelper;
import com.example.data.Score;

public class FinishWindow extends AppCompatActivity {

    private String currentDifficulty;
    private String currentUsername;
    private Time currentTime;

    private DbHelper dbHelper;
    private SQLiteDatabase db;

    private ArrayList<Score> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_window);

        currentDifficulty = "Easy";

        scores = new ArrayList<Score>();

        dbHelper = new DbHelper(FinishWindow.this);
        db = dbHelper.getWritableDatabase();

        if(db == null)
            Toast.makeText(FinishWindow.this, "ERROR: Could not write save or access the data", Toast.LENGTH_LONG);
        else {
            this.fetchData();
            if(!scores.isEmpty())
                this.populateTable();
        }
    }

    /**
     * Fetch the scores from the database
     */
    private void fetchData() {
        Cursor cursor = db
                .rawQuery("SELECT * FROM " + DbHelper.TABLE_SCORES, null);
        while(cursor.moveToNext()) {
            Score score = new Score(
                    cursor.getInt(0)
                    , cursor.getString(1)
                    , cursor.getString(2)
                    , Time.valueOf(cursor.getString(3))
            );
            scores.add(score);
        }
        cursor.close();
    }

    private void uploadData() {

    }

    /**
     * Fill out the table
     */
    private void populateTable() {
        ArrayList<Score> tableScores = new ArrayList<>();
        for (Score s : scores) {
            if(tableScores.size() >= 10)
                break;
            if (s.getDifficulty().equals(currentDifficulty))
                tableScores.add(s);
        }
    }

    private void changeDifficulty() {
        this.populateTable();
    }

}