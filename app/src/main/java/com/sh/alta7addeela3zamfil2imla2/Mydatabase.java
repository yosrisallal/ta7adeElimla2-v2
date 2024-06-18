package com.sh.alta7addeela3zamfil2imla2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Mydatabase  extends SQLiteOpenHelper {

    public static final String DB_NAME="Questions";
    public static final int DB_VERSION=1;
    public static final String TABLE_NAME="questionsform";

    public static final String question="question";
    public static final String right ="rights";
    public static final String leson="leson";
    public static final String false1="false1";
    public static final String false2="false2";
    public static final String false3="false3";
    public static final String agerequired="agerequired";
    public static final String lamp="lamp";
    public static final String number="number";
    ArrayList<questionform>Questions;
    ArrayList<Integer> ids;
    public Mydatabase( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE questionsform (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "question TEXT , rights  TEXT ,leson TEXT,false1 TEXT,false2 TEXT,false3 TEXT,agerequired INTEGER,lamp TEXT,number INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS questionsform");
        onCreate(sqLiteDatabase);
    }
    public boolean insertquestionform(questionform questionform){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(question,questionform.getQuestion());
        contentValues.put(right,questionform.getRight());
        contentValues.put(leson,questionform.getLeson());
        contentValues.put(false1,questionform.getFalse1());
        contentValues.put(false2,questionform.getFalse2());
        contentValues.put(false3,questionform.getFalse3());
        contentValues.put(agerequired,questionform.getAgerequired());
        contentValues.put(lamp,questionform.getLamp());
        contentValues.put(number,questionform.getNumber());
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return result!=-1;
    }


    public long getquestionscount(){

        SQLiteDatabase sqLiteDatabase=getReadableDatabase();

        return DatabaseUtils.queryNumEntries(sqLiteDatabase,TABLE_NAME);
    }

    public boolean deleteallquestions(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        int result=sqLiteDatabase.delete(TABLE_NAME,null,null);
        return result>0;
    }


    public ArrayList<questionform> getquestionwhereageequalto(int agerequiredquiz){


        Questions=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        ids=new ArrayList<>();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM questionsform WHERE agerequired= "+ agerequiredquiz,null);
        if (cursor.moveToFirst()) {
            do {
                String QUESTION = cursor.getString((cursor.getColumnIndex(question)));
                String  RIGHT= cursor.getString((cursor.getColumnIndex(right)));
                String LESON=cursor.getString((cursor.getColumnIndex(leson)));
                String FALSE1=cursor.getString((cursor.getColumnIndex(false1)));
                String FALSE2=cursor.getString((cursor.getColumnIndex(false2)));
                String FALSE3=cursor.getString((cursor.getColumnIndex(false3)));
                int AGEREQUIRED=cursor.getInt((cursor.getColumnIndex(agerequired)));
                int NUMBER= cursor.getInt((cursor.getColumnIndex(number)));
                String LAMP = cursor.getString((cursor.getColumnIndex(lamp)));
                int id= cursor.getInt((cursor.getColumnIndex("id")));
              Questions.add(new questionform(FALSE1,FALSE2,FALSE3,LAMP,LESON,QUESTION,RIGHT,AGEREQUIRED,NUMBER));
                ids.add(id);
            }while (cursor.moveToNext());
        }
        return Questions;
    }
    public void delete(){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        for(int i=0;i<= ((ids.size())-1);i++)
        {

            int result = sqLiteDatabase.delete(TABLE_NAME, " question=" + ids.get(i), null);
        }

    }

}
