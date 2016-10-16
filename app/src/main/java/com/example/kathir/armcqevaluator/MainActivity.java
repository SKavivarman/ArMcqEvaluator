package com.example.kathir.armcqevaluator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button evaluate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        evaluate = (Button) findViewById(R.id.btnEvaluate);

        evaluate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent st = new Intent(MainActivity.this, SelectSchemeActivity.class); //redirecting to another activity
                startActivity(st);
            }
        });


    }
}
