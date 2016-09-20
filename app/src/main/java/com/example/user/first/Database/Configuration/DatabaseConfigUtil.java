package com.example.user.first.Database.Configuration;

import com.example.user.first.Database.Entity.Group;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class DatabaseConfigUtil extends OrmLiteConfigUtil { // todo use after final db implementation

    private static final Class<?>[] classes = new Class[]{
            Group.class
    };

    public static void main(String[] args) throws SQLException, IOException {
        writeConfigFile(new File("app/src/main/res/raw/pexeso_db_config.txt"), classes);
    }
}