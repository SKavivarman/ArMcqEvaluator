package com.example.kathir.armcqevaluator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioGroup;

/**
 * Created by Sharu Vive on 11/18/2016.
 */

public class SubjectDetailActivity extends AppCompatActivity {

    RadioGroup radioSemesterGroup;
    RadioGroup radioYearGroup;

    Button subDetailsOK;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);

        radioSemesterGroup =(RadioGroup)findViewById(R.id.radGroupSeme);
        radioYearGroup = (RadioGroup)findViewById(R.id.radGroupYear);

        subDetailsOK = (Button)findViewById(R.id.btnsubDetailsOK);



    }
}
