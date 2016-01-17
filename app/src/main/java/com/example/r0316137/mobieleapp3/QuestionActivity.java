package com.example.r0316137.mobieleapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity
implements  TextView.OnEditorActionListener, View.OnClickListener{


    private TextView question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    QuestionScoreDB db = new QuestionScoreDB(this);

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
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


       Questions thisQuestion = db.getQuestion(1);

        question.setText(thisQuestion.getQuestion());
        String[] AllAnswers = thisQuestion.getAnswers().split(";");
        answer1.setText(AllAnswers[0]);
        answer2.setText(AllAnswers[1]);
        answer3.setText(AllAnswers[2]);
        answer4.setText(AllAnswers[3]);




        question.setOnEditorActionListener(this);
        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);
        answer4.setOnClickListener(this);



    }
}
