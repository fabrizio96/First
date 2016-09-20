package com.example.user.first;

import android.content.ClipData;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.user.first.Database.AppStorage;
import com.example.user.first.Database.Entity.Group;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 06/09/2016.
 */
public class HistoryFragment extends Fragment{
    public static final String TAG = HistoryFragment.class.getName();

    ListView listview1;
    ArrayAdapter<Group> history;

View view;

    public HistoryFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {


        view=  inflater.inflate(R.layout.history, container, false);



        listview1 = (ListView) view.findViewById(R.id.listView1);

        listview1.setAdapter(history);



                return view;

    }




}


