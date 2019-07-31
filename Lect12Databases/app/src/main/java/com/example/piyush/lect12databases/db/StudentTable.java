package com.example.piyush.lect12databases.db;

import android.provider.BaseColumns;

/**
 * Created by Piyush on 12-07-2016.
 */
public class StudentTable extends DbTable {

    public static final String TABLE_NAME = "students";

    public interface Columns extends BaseColumns {
        String ID = "id";
        String NAME = "name";
        String AGE = "age";
        String CLASS = "class";
    }

    public static final String TABLE_CREATE_CMD =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
            + LBR
            + Columns.ID + TYPE_INT + COMMA
            + Columns.NAME + TYPE_REAL +COMMA
            + Columns.AGE + TYPE_INT + COMMA
            + Columns.CLASS + TYPE_INT
            + RBR + ";" ;

}
