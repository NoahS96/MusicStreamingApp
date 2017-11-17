package com.example.slothlord.musicstreamingapp.AlarmJava;

import com.example.slothlord.musicstreamingapp.AlarmJava.Alarm;

import java.util.ArrayList;

/**
 * Created by jperales on 11/13/17.
 */

public class Alarms {

    private ArrayList<Alarm> alarms = new ArrayList<>();

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }

    public void removeAlarm(int position){
        this.alarms.remove(position);
    }

    public ArrayList<Alarm> getAlarms(){

        return alarms;
    }
}
