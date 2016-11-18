package com.example.kathir.armcqevaluator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button evaluateAns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        evaluateAns = (Button) findViewById(R.id.btnEvaluateAns);

        evaluateAns.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent st = new Intent(MainActivity.this, SubjectDetailActivity.class); //redirecting to another activity
                startActivity(st);
            }
        });
    }
}
