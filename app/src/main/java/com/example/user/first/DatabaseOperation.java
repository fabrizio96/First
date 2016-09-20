
package com.example.user.first;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.math.BigDecimal;
import android.renderscript.Int2;

public class DatabaseOperation extends SQLiteOpenHelper {

    public static final int database_version =1;

    public String Create_Query = "Create Table" + TableData.TableInfo.Table_Name+"("+ TableData.TableInfo.First_Number+"BigDecimal"
            + TableData.TableInfo.Second_Number+"BigDecimal"+TableData.TableInfo.Operation_Code+"int );";

    public DatabaseOperation(Context context)
    {
    super (context, TableData.TableInfo.Database_Name,null,database_version);


    }


    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
    sdb.execSQL(Create_Query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {




    }
   // public void InsertInformation(DatabaseOperation dop,BigDecimal First,BigDecimal Second,int operation)
   // {
   //     SQLiteDatabase SQ= dop.getWritableDatabase();
   //     ContentValues cv = new ContentValues();
    //    cv.put(TableData.TableInfo.First_Number,First);
    //    cv.put(TableData.TableInfo.Second_Number,Second);
    //    cv.put(TableData.TableInfo.Operation_Code,operation);
   //     long k= SQ.insert(TableData.TableInfo.Table_Name,null,cv);
   // }



}
