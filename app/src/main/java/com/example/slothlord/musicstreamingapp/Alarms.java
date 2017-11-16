package com.example.slothlord.musicstreamingapp;

import java.util.ArrayList;

/**
 * Created by jperales on 11/13/17.
 */

public class Alarms {

    private ArrayList<Alarm> alarms = new ArrayList<>();

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }

    public ArrayList<Alarm> getAlarms(){

        return alarms;
    }
}
