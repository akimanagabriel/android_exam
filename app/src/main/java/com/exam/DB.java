package com.exam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {

    public static final String DBNAME = "litedb";
    public static final String COL_NAMES = "names";
    public static final String COL_REGNO = "registration";
    public static final String COL_ID = "id";
    public static final String COL_FA1MARKS = "fa1marks";
    public static final String COL_FA2MARKS = "fa2marks";
    public static final String COL_DECISION = "decision";
    public static final String TABLE = "marks_group_three_tbl";

    public DB(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE+" (\n" +COL_ID+
                "     INTEGER PRIMARY KEY AUTOINCREMENT,\n" +COL_NAMES+
                "     TEXT,\n" +COL_REGNO+
                "     TEXT,\n" +COL_FA1MARKS+
                "     INTEGER,\n" +COL_FA2MARKS+
                "     INTEGER,\n" +COL_DECISION+
                " TEXT"+
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABLE;
        db.execSQL(sql);
        onCreate(db);
    }

    public void createStudent(Student student) throws Exception{
        String query = "INSERT INTO marks_group_three_tbl (names, registration, fa1marks, fa2marks, decision)\n" +
                "VALUES ('"+student.getNames()+"', '"+student.getRegNumber()+"', '"+student.getFa1marks()+"', '"+student.getFa2marks()+"', '"+student.getDecision()+"')";
        this.getWritableDatabase().execSQL(query);
    }

    public List<Student> getAllStudents() throws Exception{
        List<Student> allStudents = new ArrayList<>();

        String query = "SELECT id, names, registration, fa1marks, fa2marks,decision FROM "+TABLE;
        Cursor cursor = this.getReadableDatabase().rawQuery(query,null);

        while (cursor.moveToNext()){
            Student student = new Student();
            student.setId(cursor.getInt(0));
            student.setNames(cursor.getString(1));
            student.setRegNumber(cursor.getString(2));
            student.setFa1marks(cursor.getFloat(3));
            student.setFa2marks(cursor.getFloat(4));
            allStudents.add(student);
        }

        return allStudents;
    }

}
