package com.example.r0316137.mobieleapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ScoreBoardActivity extends AppCompatActivity {

    private TextView tw1;
    private TextView tw2;
    private TextView tw3;
    private TextView h1;
    private TextView h2;
    private TextView h3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        tw1 = (TextView) findViewById(R.id.Lbl1);
        tw2 = (TextView) findViewById(R.id.Lbl2);
        tw3 = (TextView) findViewById(R.id.Lbl3);
        h1 = (TextView) findViewById(R.id.h1);
        h2 = (TextView) findViewById(R.id.h2);
        h3 = (TextView) findViewById(R.id.h3);

        QuestionScoreDB db = new QuestionScoreDB(this);
        List<ScoreBoard> sb = db.getScoreBoard();

        h1.append("Groupname");
        h2.append("Class");
        h3.append("Score");

        for (ScoreBoard OneSb:sb) {

            tw1.append(OneSb.getGroupName() + "\n");
            tw2.append(OneSb.getClassName() + "\n");
            tw3.append(OneSb.getScore() + "\n");

        }




    }

}
