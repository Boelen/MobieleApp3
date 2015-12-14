package com.example.r0316137.mobieleapp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity
implements TextView.OnEditorActionListener,View.OnClickListener{


    private EditText groupName;
    private EditText className;
    private Button startGame;
    private Button scoreTabel;


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
        switch (v.getId())
        {
            case R.id.Button02:
                Intent intent = new Intent(this,MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.Button03:
                break;
        }

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}
