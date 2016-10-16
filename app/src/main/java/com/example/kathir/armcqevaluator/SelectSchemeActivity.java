package com.example.kathir.armcqevaluator;

import android.content.Intent;
import android.database.Cursor;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SelectSchemeActivity extends AppCompatActivity {

    Spinner spYear, spSemester, spModule;
    Button btnOk, btnExport;
    DBhelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_scheme);

        spYear = (Spinner) findViewById(R.id.spinner);
        spSemester = (Spinner) findViewById(R.id.spinner2);
        spModule = (Spinner) findViewById(R.id.spinner3);
        btnOk = (Button) findViewById(R.id.button);
        btnExport = (Button) findViewById(R.id.button2);
        helper = new DBhelper(this);

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent st = new Intent(SelectSchemeActivity.this, EvaluateAnswerActivity.class); //redirecting to another activity
                st.putExtra("year", spYear.getSelectedItem().toString());
                st.putExtra("sem", spSemester.getSelectedItem().toString());
                st.putExtra("mod", spModule.getSelectedItem().toString());
                startActivity(st);
            }
        });


        btnExport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Cursor cursor = helper.getMarkingScheme();
                    int rowcount = 0;
                    int colcount = 0;

                    File sdCardDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                    String filename = "MarkingScheme.csv"; // the name of the file to export with
                    File saveFile = new File(sdCardDir, filename);
                    FileWriter fw = new FileWriter(saveFile);

                    BufferedWriter bw = new BufferedWriter(fw);
                    rowcount = cursor.getCount();
                    colcount = cursor.getColumnCount();
                    if (rowcount > 0) {
                        cursor.moveToFirst();
                        for (int i = 0; i < colcount; i++) {
                            if (i != colcount - 1) {
                                bw.write(cursor.getColumnName(i) + ",");
                            } else {
                                bw.write(cursor.getColumnName(i));
                            }
                        }
                        bw.newLine();

                        for (int i = 0; i < rowcount; i++) {
                            cursor.moveToPosition(i);

                            for (int j = 0; j < colcount; j++) {
                                if (j != colcount - 1)
                                bw.write(cursor.getString(j) + ",");
                                else
                                bw.write(cursor.getString(j));
                            }
                            bw.newLine();
                        }
                        bw.flush();
                        Toast.makeText(SelectSchemeActivity.this, "Exported Successfully.",Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(SelectSchemeActivity.this, "Cannot export file",Toast.LENGTH_LONG).show();
                } finally {

                }

            }
        });
    }
}
