package com.example.kathir.armcqevaluator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class SelectSchemeActivity extends AppCompatActivity {

    Spinner spYear, spSemester, spModule;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_scheme);

        spYear = (Spinner) findViewById(R.id.spinner);
        spSemester = (Spinner) findViewById(R.id.spinner2);
        spModule = (Spinner) findViewById(R.id.spinner3);
        btnOk = (Button) findViewById(R.id.button);

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent st = new Intent(SelectSchemeActivity.this, EvaluateAnswerActivity.class); //redirecting to another activity
                startActivity(st);
            }
        });
    }
}
