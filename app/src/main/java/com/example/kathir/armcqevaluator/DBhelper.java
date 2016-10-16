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

    static final String DATABASE = "mcq.db";
    static final int VERSION = 2;
    static final String TABLE1 = "Answers";


    static final String A_ID = "ans_id";
    static final String QUESTION = "question";
    static final String ANS = "answer";



    public DBhelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE " + TABLE1 + " ( "
                + A_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUESTION + " text, "
                + ANS + " text);");

        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(1,'1','A')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(2,'2','A')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(3,'3','B')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(4,'4','D')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(5,'5','C')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(6,'6','A')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(7,'7','A')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(8,'8','B')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(9,'9','D')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(10,'10','C')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(11,'11','A')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(12,'12','A')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(13,'13','B')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(14,'14','D')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(15,'15','C')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(16,'16','A')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(17,'17','A')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(18,'18','B')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(19,'19','D')");
        db.execSQL("INSERT INTO " + TABLE1 + " VALUES(20,'20','C')");


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





}
