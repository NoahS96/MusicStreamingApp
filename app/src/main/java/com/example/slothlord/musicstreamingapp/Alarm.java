package com.example.slothlord.musicstreamingapp;

/**
 * Created by jperales on 11/12/17.
 * Alarm Object that has an hour and minute
 */
public class Alarm {
    private int hour;
    private int min;
    private String alarmName;

    public Alarm(int hour, int min){
        this.hour = hour;
        this.min = min;
        this.alarmName = "New Alarm";
    }

    public Alarm(int hour, int min, String alarmName){
        this.hour = hour;
        this.min = min;
        this.alarmName = alarmName;
    }

    public int getHour() {
        this.hour = this.hour % 12;
        if(this.hour == 0){
            this.hour = 12;
        }
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    //Hey make sure to code an if statement that adds a 0 in front of min if min is less than 10
    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getAlarmTime(){
        String alarmTime;
        if(this.getMin() > 9) {
            alarmTime = (this.getHour() + ":" + this.getMin());
        }
        else{
            alarmTime = this.getHour() + ":0" + this.getMin();
        }
        return alarmTime;
    }
}
