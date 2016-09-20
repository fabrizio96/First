package com.example.user.first.Database.Configuration;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.first.App;
import com.example.user.first.Database.Entity.Group;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Collection;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    public static final String DATABASE_NAME = "awis.db";
    public static final int DATABASE_VERSION =1;

    private Dao<Group, Integer> mGroupDao;





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION /*,R.raw.ormlite_config_kasa*/); // todo use config file after app is tested to speed up creating DAO objects
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Group.class);






        } catch (Exception e) {
          App.logE(DatabaseHelper.class.getName() + " Unable to create databases", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {

            onCreate(sqliteDatabase,connectionSource);

            if(oldVer < 1) {

//                try {
//                    getGroupDao().executeRaw("ALTER TABLE `Inventura` ADD COLUMN idGroups STRING;");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }


                try {
                    onCreate(sqliteDatabase,connectionSource);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


        } catch (Exception e) {
            App.log(e.toString() + " Unable to upgrade database from version " + oldVer + " to new " + newVer);
        }
    }

    public Dao<Group, Integer> getGroupDao() throws SQLException {
        if (mGroupDao == null) {
            mGroupDao = getDao(Group.class);
        }
        return mGroupDao;
    }


}
