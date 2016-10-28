package com.example.kathir.armcqevaluator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoSchemeActivity extends AppCompatActivity {

    TextView noAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_scheme);

        noAnswer = (TextView) findViewById(R.id.textView4);
    }
}
