package com.example.data;

import java.sql.Time;

public class Score {
    private int id;
    private String name;
    private String difficulty;
    private Time completion_time;

    public Score(int id, String name, String difficulty, Time completion_time) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.completion_time = completion_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Time getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(Time completion_time) {
        this.completion_time = completion_time;
    }

}