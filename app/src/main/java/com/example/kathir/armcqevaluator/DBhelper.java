package com.example.kathir.armcqevaluator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Priya.
 */
public class DBhelper extends SQLiteOpenHelper {

    static final String DATABASE = "mcq1.db";
    static final int VERSION = 3;
    static final String TABLE1 = "Answers";


    static final String A_ID = "ans_id";
    static final String QUESTION = "question";
    static final String ANS = "answer";
    static final String YEAR = "year";
    static final String SEMESTER = "semester";
    static final String SUBJECT = "subject";



    public DBhelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE " + TABLE1 + " ( "
                + A_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUESTION + " text, "
                + ANS + " text, "
                + YEAR + " INTEGER, "
                +SEMESTER + " INTEGER, "
                +SUBJECT + " text);");

        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(1,'1','A',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(2,'2','A',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(3,'3','B',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(4,'4','D',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(5,'5','C',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(6,'6','A',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(7,'7','A',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(8,'8','B',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(9,'9','D',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(10,'10','C',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(11,'11','A',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(12,'12','A',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(13,'13','B',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(14,'14','D',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(15,'15','C',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(16,'16','A',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(17,'17','A',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(18,'18','B',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(19,'19','D',3,2,'SA')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(20,'20','C',3,2,'SA')");


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table " + TABLE1);
        onCreate(db);
    }

    public Cursor getMarkingScheme(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE1, null);

        return  res;
    }

    public Cursor getActualScheme(int year, int sem, String sub){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE1 + " where " + YEAR + " = '" + year + "' and " + SEMESTER + " = '" + sem + "' and " + SUBJECT + " = '" + sub + "'", null);

        return  res;
    }





}
