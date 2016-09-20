package com.example.user.first.Database;

import com.example.user.first.App;
import com.example.user.first.Database.Configuration.DatabaseHelper;
import com.example.user.first.Database.Entity.Group;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by User on 20/09/2016.
 */
public class AppStorage {






    private static DatabaseHelper sHelper;
    private static ReentrantLock sLock = new ReentrantLock();


    public static DatabaseHelper get() {
        if (sHelper == null) {
            sLock.lock();
            try {
                if (sHelper == null) {
                    sHelper = new DatabaseHelper(App.getContext());
                }
            } finally {
                sLock.unlock();
            }
        }
        return sHelper;
    }

    public static List<Group> getGroups()  {
        try {
            return  get().getGroupDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void add(Group group) throws SQLException {

        get().getGroupDao().create(group);
    }
}