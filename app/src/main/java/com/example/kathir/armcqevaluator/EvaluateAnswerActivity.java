package com.example.kathir.armcqevaluator;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class EvaluateAnswerActivity extends AppCompatActivity {

    TextView q1, q2, q3,noAnswer,q5;
    LinearLayout linearLayout;
    DBhelper helper;
    String answers[] = { "A", "B", "C", "D","E" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate_answer);

        String year= getIntent().getStringExtra("year");
        String sem= getIntent().getStringExtra("sem");
        String mod= getIntent().getStringExtra("mod");

        q1 = (TextView) findViewById(R.id.textView);
        q2 = (TextView) findViewById(R.id.textView2);
        q3 = (TextView) findViewById(R.id.textView3);
        linearLayout = (LinearLayout) findViewById(R.id.linear2);

//        q4 = (TextView) findViewById(R.id.textView4);
//        q5 = (TextView) findViewById(R.id.textView5);

        helper = new DBhelper(this);

        q1.setText(year);
        q2.setText(sem);
        q3.setText(mod);
//        q4.setText(getScheme().get(3));
//        q5.setText(getScheme().get(4));


        ArrayList<String> answerScheme = getScheme(Integer.parseInt(year.substring(5,6)),Integer.parseInt(sem.substring(9,10)),mod);

        if(!answerScheme.isEmpty()){
            LinearLayout mLinearLayout = (LinearLayout) findViewById(R.id.linear1);
            for(int k = 1; k <= 20; k++) {
                //create text button
                TextView title = new TextView(this);
                title.setText("Q: " + k);
                mLinearLayout.addView(title);
                // create radio button
                final RadioButton[] rb = new RadioButton[5];
                RadioGroup rg = new RadioGroup(this);
                rg.setOrientation(RadioGroup.HORIZONTAL);
                for (int i = 0; i < 5; i++) {
                    rb[i] = new RadioButton(this);
                    rb[i].setText("            ");
                    rg.addView(rb[i]);
                    rb[i].setText("          ");
//                rb[i].setText("  " + answers[i] + "     ");
                    rb[i].setEnabled(false);
                }

                int p = k-1;
                if(answerScheme.get(p).equalsIgnoreCase("A")){
                    rb[0].setChecked(true);
                }
                if(answerScheme.get(p).equalsIgnoreCase("B")){
                    rb[1].setChecked(true);
                }
                if(answerScheme.get(p).equalsIgnoreCase("C")){
                    rb[2].setChecked(true);
                }
                if(answerScheme.get(p).equalsIgnoreCase("D")){
                    rb[3].setChecked(true);
                }
                if(answerScheme.get(p).equalsIgnoreCase("E")){
                    rb[4].setChecked(true);
                }
                mLinearLayout.addView(rg);
        }



        } else {
            Intent st = new Intent(EvaluateAnswerActivity.this, NoSchemeActivity.class); //redirecting to another activity
            startActivity(st);




        }
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

    public ArrayList<String> getScheme(int year, int sem, String sub){
        Cursor cursor = helper.getActualScheme(year,sem,sub);
        ArrayList<String> scheme = new ArrayList<>(10);
        int col = 2;

        while (cursor.moveToNext()){
            scheme.add(cursor.getString(col));
        }

        return scheme;
    }

}
