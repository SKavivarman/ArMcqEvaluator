package com.example.kathir.armcqevaluator;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class EvaluateAnswerActivity extends AppCompatActivity {

    TextView q1, q2, q3,q4,q5;
    DBhelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate_answer);

        q1 = (TextView) findViewById(R.id.textView1);
        q2 = (TextView) findViewById(R.id.textView2);
        q3 = (TextView) findViewById(R.id.textView3);
        q4 = (TextView) findViewById(R.id.textView4);
        q5 = (TextView) findViewById(R.id.textView5);

        helper = new DBhelper(this);

        q1.setText(getScheme().get(0));
        q2.setText(getScheme().get(1));
        q3.setText(getScheme().get(2));
        q4.setText(getScheme().get(3));
        q5.setText(getScheme().get(4));
    }

    public ArrayList<String> getScheme(){
        Cursor cursor = helper.getMarkingScheme();
        ArrayList<String> scheme = new ArrayList<>(10);
        int col = 2;

        while (cursor.moveToNext()){
            scheme.add(cursor.getString(col));
        }

        return scheme;
    }


}
