package com.example.r0316137.mobieleapp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 15/01/2016.
 */
public class QuestionScoreDB {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public QuestionScoreDB(Context context)
    {
        dbHelper = new DBHelper(context, DB_NAME, null , DB_VERSION);
    }

    private void openReadableDB(){
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB(){
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB()
    {
        if (db != null)
            db.close();
    }

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

    public static final String QUESTIONS_FINISHED = "Questions_Finished";
    public static final int QUESTIONS_FINISHED_COL = 4;

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

    // Create & drop table statements

    public static final String CREATE_QUESTIONS_TABLE =
            "CREATE TABLE " + QUESTIONS_TABLE + " ( " +
                    QUESTIONS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    QUESTIONS_NAME + " TEXT NOT NULL, " +
                    QUESTIONS_QUESTION + " TEXT NOT NULL, " +
                    QUESTIONS_ANSWERS + " TEXT NOT NULL, " +
                    QUESTIONS_FINISHED + " TEXT);";


    public static final String CREATE_SCOREBOARD_TABLE =
            "CREATE TABLE " + SCOREBOARD_TABLE + " ( " +
                    SCOREBOARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    SCOREBOARD_GROUPNAME + " TEXT NOT NULL, " +
                    SCOREBOARD_CLASSNAME + " TEXT NOT NULL, " +
                    SCOREBOARD_SCORE + " INTEGER NOT NULL, " +
                    SCOREBOARD_TIME + " TEXT NOT NULL);";

    public static final String DROP_QUESTIONS_TABLE =
            "DROP TABLE IF EXISTS " + QUESTIONS_TABLE;

    public  static final String DROP_SCOREBOARD_TABLE =
            "DROP TABLE IF EXISTS " + SCOREBOARD_TABLE;


    private static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
        {
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_QUESTIONS_TABLE);

            db.execSQL("INSERT INTO questions VALUES (1, 'vraag 1' , ' Op welke straat bevind je je nu?' , 'schepersweg;donderweg;banaanstraat;rareweg' , '0')");
            db.execSQL("INSERT INTO questions VALUES (2, 'vraag 2' , ' Op welke waterloop sta je nu?' , 'albertkanaal;De maas;De schelde;ijzer' , '0')");
            db.execSQL("INSERT INTO questions VALUES (3, 'vraag 3' , ' Op welke gesteente staan we nu?' , 'klei;leem;alleen zand;zandleem' , '0')");


            db.execSQL(CREATE_SCOREBOARD_TABLE);



        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.d("Question Score","Upgrading db from version" + oldVersion + " to " + newVersion);

            db.execSQL(QuestionScoreDB.DROP_QUESTIONS_TABLE);
            db.execSQL(QuestionScoreDB.DROP_SCOREBOARD_TABLE);
            onCreate(db);
        }
    }

    public List<ScoreBoard> getScoreBoard() {
        List<ScoreBoard> scoreBoardList = new ArrayList<ScoreBoard>();
        String selectQuery = "SELECT * FROM " + SCOREBOARD_TABLE;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ScoreBoard scoreBoard = new ScoreBoard();
                scoreBoard.setId(Integer.parseInt(cursor.getString(0)));
                scoreBoard.setGroupName(cursor.getString(1));
                scoreBoard.setClassName(cursor.getString(2));
                scoreBoard.setScore((Integer.parseInt(cursor.getString(3))));
                scoreBoard.setTime((Integer.parseInt(cursor.getString(4))));
                scoreBoardList.add(scoreBoard);
            } while (cursor.moveToNext());

        }
        return scoreBoardList;
    }


    public Questions getQuestion(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(QUESTIONS_TABLE, new String[] { QUESTIONS_ID, QUESTIONS_NAME , QUESTIONS_QUESTION,  QUESTIONS_ANSWERS , QUESTIONS_FINISHED}, QUESTIONS_ID + "=?",
                new String[] {String.valueOf(id)}, null,null,null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Questions question = new Questions(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

        return question;
    }


    public long insertScoreBoard(ScoreBoard scoreBoard)
    {
        ContentValues cv = new ContentValues();
        cv.put(SCOREBOARD_GROUPNAME,scoreBoard.getGroupName());
        cv.put(SCOREBOARD_CLASSNAME,scoreBoard.getClassName());
        cv.put(SCOREBOARD_SCORE,scoreBoard.getScore());
        cv.put(SCOREBOARD_TIME,scoreBoard.getTime());

        this.openWriteableDB();
        long rowID = db.insert(SCOREBOARD_TABLE,null,cv);
        this.closeDB();

        return rowID;
    }

    public int updateScoreBoard(ScoreBoard scoreBoard) {
        ContentValues cv = new ContentValues();
        cv.put(SCOREBOARD_GROUPNAME,scoreBoard.getGroupName());
        cv.put(SCOREBOARD_CLASSNAME,scoreBoard.getClassName());
        cv.put(SCOREBOARD_SCORE,scoreBoard.getScore());
        cv.put(SCOREBOARD_TIME,scoreBoard.getTime());

        String where = SCOREBOARD_ID + "= ?";
        String[] whereArgs = {String.valueOf(scoreBoard.getId())};
        this.openWriteableDB();
        int rowCount = db.update(SCOREBOARD_TABLE, cv, where, whereArgs);
        this.closeDB();
        return rowCount;
    }

    public int updateQuestions(Questions questions)
    {
        ContentValues cv = new ContentValues();
        cv.put(QUESTIONS_NAME,questions.getName());
        cv.put(QUESTIONS_QUESTION,questions.getQuestion());
        cv.put(QUESTIONS_ANSWERS,questions.getAnswers());
        cv.put(QUESTIONS_FINISHED, questions.getFinished());

        String where = QUESTIONS_ID + "= ?";
        String[] whereArgs = {String.valueOf(questions.getId())};
        this.openWriteableDB();
        int rowCount = db.update(QUESTIONS_TABLE, cv , where , whereArgs);
        this.closeDB();
        return rowCount;
    }



}
