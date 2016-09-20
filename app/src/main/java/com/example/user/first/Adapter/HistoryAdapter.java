package com.example.user.first.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.first.Database.AppStorage;
import com.example.user.first.Database.Entity.Group;
import com.example.user.first.R;

import java.util.List;

/**
 * Created by User on 20/09/2016.
 */
public class HistoryAdapter extends ArrayAdapter<Group> {
List<Group> groups;
    Context context;

    public HistoryAdapter(Context context, List<Group> group) {
        super(context, -1,group);
this.context = context;
        groups =group;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView item   = (TextView) rowView.findViewById(R.id.);

item.setText(groups.get(position).getFirst()+groups.get(position).setOperation()+groups.get(position).getSecond());

        return v;

    }
}
