package com.example.slothlord.musicstreamingapp.AlarmJava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.AlarmJava.Alarm;
import com.example.slothlord.musicstreamingapp.AlarmJava.AlarmListActivity;
import com.example.slothlord.musicstreamingapp.R;

import java.util.ArrayList;

/**
 * Created by slothlord on 11/6/17.
 */

public class AlarmListController extends BaseAdapter {

    private AlarmListActivity alarmListActivity;
    private ArrayList<Alarm> alarms;

    public AlarmListController(AlarmListActivity alarmListActivity, ArrayList<Alarm>alarms){
        this.alarmListActivity = alarmListActivity;
        this.alarms = alarms;
    }

    @Override
    public int getCount() {
        return alarms.size();
    }

    @Override
    public Object getItem(int i) {
        return alarms.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(alarmListActivity).
                    inflate(R.layout.alarm_list_view_row_items, null, false);
        }

        // get current item to be displayed
        Alarm alarm = (Alarm) getItem(i);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                view.findViewById(R.id.text_view_item_name);
        //TextView textViewItemDescription = (TextView)
          //      view.findViewById(R.id.text_view_item_description);

        //sets the text for item name and item description from the current item object
        textViewItemName.setText(alarm.getAlarmTime());
        //textViewItemDescription.setText(currentItem.getItemDescription());

        // returns the view for the current row
        return view;
    }
}
