package com.example.r0316137.mobieleapp3;

/**
 * Created by Tom on 15/01/2016.
 */
public class QuestionScoreDB {

    public static final String DB_NAME = "QuestionScoreDB.db";
    public static final int DB_VERSION = 1;

    //table1

    public static final String QUESTIONS_TABLE = "Questions";

    public static final String QUESTIONS_ID = "_id";
    public static final int QUESTIONS_ID_COL = 0;

    public static final String QUESTIONS_NAME = "Questions_name";
    public static final int QUESTIONS_NAME_COL = 1;

    public static final String QUESTIONS_QUESTION = "Questions_Question";
    public static final int QUESTIONS_QUESTION_COL = 2;

    public static final String QUESTIONS_ANSWERS = "Questions_Answers";
    public static final int QUESTIONS_ANSWERS_COL = 3;

    /////////////////////////////////////////////////////////:

    public static final String SCOREBOARD_TABLE = "ScoreBoard";

    public static final String SCOREBOARD_ID = "_id";
    public static final int SCOREBOARD_ID_COL = 0;

    public static final String SCOREBOARD_GROUPNAME = "GroupName";
    public static final int SCOREBOARD_GROUPNAME_COL = 1;

    public static final String SCOREBOARD_CLASSNAME = "ClassName";
    public static final int SCOREBOARD_CLASSNAME_COL = 2;

    public static final String SCOREBOARD_SCORE = "Score";
    public static final int SCOREBOARD_SCORE_COL = 3;

    public static final String SCOREBOARD_TIME = "Time";
    public static final int SCOREBOARD_TIME_COL = 4;

}
