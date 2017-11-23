package com.example.slothlord.musicstreamingapp.AlarmJava;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
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
            viewHolder.time = (TextView) view.findViewById(R.id.alarmRow);
            viewHolder.date = (TextView) view.findViewById(R.id.date);
            viewHolder.name = (TextView) view.findViewById(R.id.alarmName);
            viewHolder.button = (ImageButton) view.findViewById(R.id.deleteAlarmButton);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }



        final String time = getItem(i).getAlarmTime();
        viewHolder.time.setText(time);
        final String date = getItem(i).getDate();
        viewHolder.date.setText(date);
        final String title = getItem(i).getAlarmName();
        viewHolder.name.setText(title);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customListener != null){
                    customListener.onButtonClickListener(i,time);
                }
            }
        });
        return view;
    }
    public class ViewHolder{
        TextView time;
        TextView date;
        TextView name;
        ImageButton button;
    }
}
