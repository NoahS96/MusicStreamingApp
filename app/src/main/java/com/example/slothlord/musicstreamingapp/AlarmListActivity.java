package com.example.slothlord.musicstreamingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;




public class AlarmListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_list);

        final ListView alarmListView = (ListView) findViewById(R.id.alarmList);
        final Button newAlarm = (Button) findViewById(R.id.newAlarm);
    }
}
