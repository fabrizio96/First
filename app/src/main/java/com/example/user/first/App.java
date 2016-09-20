package com.example.user.first;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by User on 06/09/2016.
 */
public class App extends Application {
    static Context context;

    @Override
    public void onCreate() {

        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        App.context = context;
    }

    public static void logE(String s, Exception e) {
        if(BuildConfig.DEBUG) {
            Log.e(s,e.toString());
        }
    }

    public static void log(String s) {
        if(BuildConfig.DEBUG) {
            Log.e("",s.toString());
        }
    }
}
