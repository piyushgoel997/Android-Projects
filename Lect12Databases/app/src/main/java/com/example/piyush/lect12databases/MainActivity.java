package com.example.piyush.lect12databases;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.piyush.lect12databases.db.StudentTable;
import com.example.piyush.lect12databases.models.Student;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyDbOpener dbOpener = new MyDbOpener(this);
//
//        SQLiteDatabase myDb = dbOpener.getReadableDatabase();

        //------------//
        SQLiteDatabase myDb = MyDbOpener.openWritableDatabase(this);
        //------------//
//        myDb.execSQL("INSERT INTO student");

        Student stu = new Student(1,"John Doe",5,11);

        ContentValues value = new ContentValues();  // Basically a HashMap of Key Value Pairs
//        value.put(StudentTable.Columns.ID,stu.getId());
//        value.put(StudentTable.Columns.NAME,stu.getName());
//        value.put(StudentTable.Columns.AGE,stu.getAge());
//        value.put(StudentTable.Columns.CLASS, String.valueOf(stu.getClass()));
//
//        myDb.insert(StudentTable.TABLE_NAME, null, value);

        String[] projection = {
                StudentTable.Columns.ID,
                StudentTable.Columns.NAME
        };

        Cursor c = myDb.query(
                StudentTable.TABLE_NAME,
                projection,
                null, null, null, null, null
        );
        Log.d(TAG, "onCreate: cursor count " + c.getCount());
        while (c.moveToNext()) {
            int stuID = c.getInt(c.getColumnIndex(StudentTable.Columns.ID));  // gives -1 if the column doesn't exist
            // if we are not sure if the column of that name exists then we should use getColumnIndexOrThrow => throws an exception
            String stuName = c.getString(c.getColumnIndex(StudentTable.Columns.NAME));
            Log.d(TAG, "onCreate: student " + stuID + stuName);
        }
    }
}
