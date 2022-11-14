package com.example.data;

import com.example.sudokupmd.Difficulty;
import com.example.sudokupmd.Result;

import java.sql.Time;

public class Score {
    private String name;
    private Difficulty difficulty;
    private Result result;
    private Time completion_time;

    public Score(String name, Difficulty difficulty, Result result, Time completion_time) {
        this.name = name;
        this.difficulty = difficulty;
        this.result = result;
        this.completion_time = completion_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Result getResult() { return result; }

    public void setResult(Result result) { this.result = result; }

    public Time getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Time completion_time) {
        this.completion_time = completion_time;
    }

}