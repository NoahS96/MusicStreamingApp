package com.example.slothlord.musicstreamingapp.AlarmJava;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.AlarmJava.Alarm;
import com.example.slothlord.musicstreamingapp.AlarmJava.AlarmListActivity;
import com.example.slothlord.musicstreamingapp.R;

import java.util.ArrayList;

/**
 * Created by slothlord on 11/6/17.
 */

public class AlarmListController extends BaseAdapter {
    customButtonListener customListener;

    public interface customButtonListener {
         void onButtonClickListener(int position, String value);
    }

    public void setCustomButtonListner(customButtonListener listener){
        this.customListener = listener;
    }


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
    public Alarm getItem(int i) {
        return alarms.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(alarmListActivity).
                    inflate(R.layout.alarm_list_view_row_items, null, false);
            viewHolder = new ViewHolder();
            viewHolder.text = (TextView) view.findViewById(R.id.alarmRow);
            viewHolder.button = (ImageButton) view.findViewById(R.id.deleteAlarmButton);
            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        // get current item to be displayed
        //final Alarm alarm = (Alarm) getItem(i);

        // get the TextView for item name and item description
        //TextView textViewItemName = (TextView)
                //view.findViewById(R.id.alarmRow);

        //sets the text for item name and item description from the current item object
        //textViewItemName.setText(alarm.getAlarmTime());

        final String temp = getItem(i).getAlarmTime();
        viewHolder.text.setText(temp);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customListener != null){
                    customListener.onButtonClickListener(i,temp);
                }
            }
        });
        return view;
    }
    public class ViewHolder{
        TextView text;
        ImageButton button;
    }
}
