package com.example.r0316137.mobieleapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity
implements TextView.OnEditorActionListener,View.OnClickListener{


    private EditText groupName;
    private EditText className;
    private Button startGame;
    private Button scoreTabel;

    private QuestionScoreDB db;
    private int Score = 0;
    private String Time  = DateFormat.getDateTimeInstance().format(new Date());
    private String groupNameString;
    private String classNameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //get references to the widgets
        groupName = (EditText) findViewById(R.id.GroupName);
        className = (EditText) findViewById(R.id.Klasgroup);
        startGame = (Button) findViewById(R.id.Button02);
        scoreTabel = (Button) findViewById(R.id.Button03);

        // set the listeners
        groupName.setOnEditorActionListener(this);
        className.setOnEditorActionListener(this);
        startGame.setOnClickListener(this);
        scoreTabel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        groupNameString = groupName.getText().toString();
        classNameString = className.getText().toString();
        db = new QuestionScoreDB(this);


        switch (v.getId())
        {
            case R.id.Button02:
                Boolean CheckInput = CheckInput();

                if(CheckInput == true) {
                    ScoreBoard SB = new ScoreBoard(groupNameString,classNameString,Score,Time);
                    db.insertScoreBoard(SB);
                    ScoreBoard YourEntry = db.getPersonalScoreBoard(groupNameString);

                    Intent intent = new Intent(this, MapsActivity.class);
                   // intent.putExtra("GroupsID",YourEntry.getGroupName());
                    startActivity(intent);
                }
                break;
            case R.id.Button03:
                break;
        }
    }

    public Boolean CheckInput()
    {
        int LengteClassName = className.getText().length();
        int LengteGroupName = groupName.getText().length();

        if(LengteClassName < 3)
        {
            Toast.makeText(this,"Je klasnaam is te kort",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (className.getText().toString().contains(" "))
        {
            Toast.makeText(this,"Je klasnaam mag geen spaties bevatten",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (LengteGroupName < 2)
        {
            Toast.makeText(this,"Jouw gekozen groepsnaam moet langer zijn dan 2 letters",Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (groupName.getText().toString().contains(" "))
        {
            Toast.makeText(this,"Je gekozen groepsnaam mag geen spaties bevatten",Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}
