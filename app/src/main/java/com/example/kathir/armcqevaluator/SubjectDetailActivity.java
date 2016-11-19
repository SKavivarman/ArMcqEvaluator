package com.example.kathir.armcqevaluator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Sharu Vive on 11/18/2016.
 */

public class SubjectDetailActivity extends AppCompatActivity {

    RadioGroup radioSemesterGroup;
    RadioGroup radioYearGroup;

    RadioButton radioSemButton;
    RadioButton radioYrButton;

    EditText etxtStudentId;
    String studentid;

    Button btnsubDetailsOK;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);

        radioSemesterGroup =(RadioGroup)findViewById(R.id.radGroupSeme);
        radioYearGroup = (RadioGroup)findViewById(R.id.radGroupYear);

        etxtStudentId = (EditText)findViewById(R.id.txtStudentID);
        studentid = etxtStudentId.getText().toString();

        btnsubDetailsOK = (Button)findViewById(R.id.btnsubDetailsOK);

        btnsubDetailsOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedsemId=radioSemesterGroup.getCheckedRadioButtonId();
                radioSemButton=(RadioButton)findViewById(selectedsemId);
                Toast.makeText(SubjectDetailActivity.this,radioSemButton.getText(), Toast.LENGTH_SHORT).show();

                int selectedyrId=radioYearGroup.getCheckedRadioButtonId();
                radioYrButton=(RadioButton)findViewById(selectedyrId);
                Toast.makeText(SubjectDetailActivity.this,radioYrButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
