package com.example.r0316137.mobieleapp3;

/**
 * Created by Tom on 15/01/2016.
 */
public class ScoreBoard {

    private int id;
    private String GroupName;
    private String ClassName;
    private int Score;
    private int Time;

    public ScoreBoard(){}

    public String getGroupName() {
        return GroupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }
}
