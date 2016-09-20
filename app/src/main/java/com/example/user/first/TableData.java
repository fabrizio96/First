package com.example.user.first;

import android.provider.BaseColumns;

/**
 * Created by User on 12/09/2016.
 */
public class TableData {

    public TableData()
    {


    }

    public static abstract class TableInfo implements BaseColumns
    {

        public static final String First_Number ="First";
        public static final String Second_Number ="Second";
        public static final String Operation_Code ="Operation";
        public static final String Database_Name ="HistoryDB";
        public static final String Table_Name = "AllOperation";
    }


}
