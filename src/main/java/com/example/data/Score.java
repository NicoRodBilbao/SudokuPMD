package com.example.data;

import java.sql.Time;

public class Score {
    private String name;
    private String difficulty;
    private boolean result;
    private Time completion_time;

    public Score(String name, String difficulty, boolean result, Time completion_time) {
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean getResult() { return result; }

    public void setResult(boolean result) { this.result = result; }

    public Time getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Time completion_time) {
        this.completion_time = completion_time;
    }

}