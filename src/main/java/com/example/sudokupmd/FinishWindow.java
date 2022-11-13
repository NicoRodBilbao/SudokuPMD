package com.example.sudokupmd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;

import com.example.data.DbHelper;
import com.example.data.Score;

public class FinishWindow extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String currentDifficulty;
    private String currentUsername;
    private Time currentTime;

    private DbHelper dbHelper;
    private SQLiteDatabase db;

    private ArrayList<Score> scores;

    TableLayout tbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_window);

        tbl = (TableLayout) findViewById(R.id.tblClasificacion);

        currentDifficulty = "Facil";
        Spinner difficultySpinner = (Spinner) findViewById(R.id.difficulty_selector);
        difficultySpinner.setOnItemSelectedListener(this);

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
    @SuppressLint("DefaultLocale")
    private void populateTable() {
        // Filter the results according to difficulty
        ArrayList<Score> tableScores = new ArrayList<>();
        for (Score s : scores) {
            if(tableScores.size() >= 10)
                break;
            if (s.getDifficulty().equals(currentDifficulty))
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

    /**
     * Change the difficulty of the scores to be shown
     */
    private void changeDifficulty(String difficulty) {
        this.currentDifficulty = difficulty;
        this.populateTable();
    }

    /**
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.changeDifficulty(parent.getItemAtPosition(position).toString());
    }

    /**
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Default difficulty
        this.changeDifficulty("Facil");
    }
}