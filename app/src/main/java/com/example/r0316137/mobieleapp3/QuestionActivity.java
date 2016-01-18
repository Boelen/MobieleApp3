package com.example.r0316137.mobieleapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.games.quest.Quest;

public class QuestionActivity extends AppCompatActivity
implements  TextView.OnEditorActionListener, View.OnClickListener {


    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    String Value;
    String Value2;
    String Name = "UCLL";
    Questions thisQuestion;

    QuestionScoreDB db = new QuestionScoreDB(this);



    public void onClick(View v) {
        int NummerKnop;
        int JuistAntwoord;

        switch (v.getId()) {
            case R.id.Answer1:
               NummerKnop = 1;
                JuistAntwoord = Integer.parseInt(thisQuestion.getRightAnswer());

                if( NummerKnop == JuistAntwoord )
                {
                    MyApplication appState = ((MyApplication)getApplicationContext());
                    int id = appState.getGroupId();
                    ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                    int TijdelijkeScore = scoreBoard.getScore() + 200;
                    scoreBoard.setScore(TijdelijkeScore);

                    thisQuestion.setFinished("1");
                    db.updateQuestions(thisQuestion);

                    Log.i("test",String.valueOf(scoreBoard.getScore()));
                    finish();
                }
                else
                {
                    MyApplication appState = ((MyApplication)getApplicationContext());
                    int id = appState.getGroupId();
                    ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                    int TijdelijkeScore = scoreBoard.getScore() - 100;
                    scoreBoard.setScore(TijdelijkeScore);
                    db.updateScoreBoard(scoreBoard);
                }

                break;
            case R.id.Answer2:
                NummerKnop = 2;
                JuistAntwoord = Integer.parseInt(thisQuestion.getRightAnswer());

                if( NummerKnop == JuistAntwoord )
                {
                    MyApplication appState = ((MyApplication)getApplicationContext());
                    int id = appState.getGroupId();
                    ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                    int TijdelijkeScore = scoreBoard.getScore() + 200;
                    scoreBoard.setScore(TijdelijkeScore);

                    thisQuestion.setFinished("1");
                    db.updateQuestions(thisQuestion);

                    Log.i("test",String.valueOf(scoreBoard.getScore()));
                    finish();
                }
                else
                {
                    MyApplication appState = ((MyApplication)getApplicationContext());
                    int id = appState.getGroupId();
                    ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                    int TijdelijkeScore = scoreBoard.getScore() - 100;
                    scoreBoard.setScore(TijdelijkeScore);
                    db.updateScoreBoard(scoreBoard);
                }

                break;
            case R.id.Answer3:
                NummerKnop = 3;
                JuistAntwoord = Integer.parseInt(thisQuestion.getRightAnswer());

                if( NummerKnop == JuistAntwoord )
                {
                    MyApplication appState = ((MyApplication)getApplicationContext());
                    int id = appState.getGroupId();
                    ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                    int TijdelijkeScore = scoreBoard.getScore() + 200;
                    scoreBoard.setScore(TijdelijkeScore);

                    thisQuestion.setFinished("1");
                    db.updateQuestions(thisQuestion);

                    Log.i("test",String.valueOf(scoreBoard.getScore()));
                    finish();
                }
                else
                {
                    MyApplication appState = ((MyApplication)getApplicationContext());
                    int id = appState.getGroupId();
                    ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                    int TijdelijkeScore = scoreBoard.getScore() - 100;
                    scoreBoard.setScore(TijdelijkeScore);
                    db.updateScoreBoard(scoreBoard);

                }

                break;
            case R.id.Answer4:
                NummerKnop = 4;
                JuistAntwoord = Integer.parseInt(thisQuestion.getRightAnswer());

                if( NummerKnop == JuistAntwoord )
                {
                    MyApplication appState = ((MyApplication)getApplicationContext());
                    int id = appState.getGroupId();

                    //score
                    ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                    int TijdelijkeScore = scoreBoard.getScore() + 200;
                    scoreBoard.setScore(TijdelijkeScore);
                    db.updateScoreBoard(scoreBoard);

                    //Question op gedaan zetten.
                    thisQuestion.setFinished("1");
                    db.updateQuestions(thisQuestion);

                    Log.i("test",String.valueOf(scoreBoard.getScore()));
                    finish();
                }
                else
                {
                    MyApplication appState = ((MyApplication)getApplicationContext());
                    int id = appState.getGroupId();
                    ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                    int TijdelijkeScore = scoreBoard.getScore() - 100;
                    scoreBoard.setScore(TijdelijkeScore);
                    db.updateScoreBoard(scoreBoard);
                }
                break;
            default:
                MyApplication appState = ((MyApplication)getApplicationContext());
                int id = appState.getGroupId();
                ScoreBoard scoreBoard = db.getPersonalScoreBoard(id);
                int TijdelijkeScore = scoreBoard.getScore() - 100;
                scoreBoard.setScore(TijdelijkeScore);
                db.updateScoreBoard(scoreBoard);

                Log.i("test", String.valueOf(scoreBoard.getScore()));

        }
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }

    @Override
    public void onBackPressed() {
        //Do nothing
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        question = (TextView) findViewById(R.id.LblQuestion);
        answer1 = (Button) findViewById(R.id.Answer1);
        answer2 = (Button) findViewById(R.id.Answer2);
        answer3 = (Button) findViewById(R.id.Answer3);
        answer4 = (Button) findViewById(R.id.Answer4);


        question.setOnEditorActionListener(this);
        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);


        Bundle b = getIntent().getExtras();

        if (b != null) {
            Value = b.getString("PlaceName").toString();
           // Value2 = b.getString("GroupsID").toString();



        }

        if (Value.equals("UCLL")) {
            thisQuestion = db.getQuestion(1);

            if(thisQuestion.getFinished().equals("1"))
            {
                Toast toast = Toast.makeText(getApplicationContext(),"Je hebt de vraag in deze zone al opgelost",Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }

            question.setText(thisQuestion.getQuestion());
            String[] AllAnswers = thisQuestion.getAnswers().split(";");
            answer1.setText(AllAnswers[0]);
            answer2.setText(AllAnswers[1]);
            answer3.setText(AllAnswers[2]);
            answer4.setText(AllAnswers[3]);
        }

        if (Value.equals("Home")) {
            thisQuestion = db.getQuestion(2);

            if(thisQuestion.getFinished().equals("1"))
            {
                Toast toast = Toast.makeText(getApplicationContext(),"Je hebt de vraag in deze zone al opgelost",Toast.LENGTH_LONG);
                toast.show();
                finish();
            }

            question.setText(thisQuestion.getQuestion());
            String[] AllAnswers = thisQuestion.getAnswers().split(";");
            answer1.setText(AllAnswers[0]);
            answer2.setText(AllAnswers[1]);
            answer3.setText(AllAnswers[2]);
            answer4.setText(AllAnswers[3]);
        }

        if (Value.equals("Plopsa")) {
            thisQuestion = db.getQuestion(3);

            if(thisQuestion.getFinished().equals("1"))
            {
                Toast toast = Toast.makeText(getApplicationContext(),"Je hebt de vraag in deze zone al opgelost",Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }

            question.setText(thisQuestion.getQuestion());
            String[] AllAnswers = thisQuestion.getAnswers().split(";");
            answer1.setText(AllAnswers[0]);
            answer2.setText(AllAnswers[1]);
            answer3.setText(AllAnswers[2]);
            answer4.setText(AllAnswers[3]);
        }




    }
}

