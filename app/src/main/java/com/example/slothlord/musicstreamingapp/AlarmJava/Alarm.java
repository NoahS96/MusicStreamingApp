package com.example.slothlord.musicstreamingapp.AlarmJava;

/**
 * Created by jperales on 11/12/17.
 * Alarm Object that has an hour and minute
 */
public class Alarm {
    private int hour;
    private int min;
    private String amOrPm;
    private String alarmName;

    public Alarm(int hour, int min){
        this.hour = hour;
        this.min = min;
        this.alarmName = "New Alarm";
        if(this.getHour() >  12){
            amOrPm = "PM";
        }
        else{
            amOrPm = "AM";
        }
    }

    public Alarm(int hour, int min, String alarmName){
        this.hour = hour;
        this.min = min;
        this.alarmName = alarmName;
        if(this.getHour() >  12){
            amOrPm = "PM";
        }
        else{
            amOrPm = "AM";
        }
    }

    public int getHour() {
      //  this.hour = this.hour % 12;
        //if(this.hour == 0){
          //  this.hour = 12;
        //}
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
        int hour = this.getHour();
        if (hour > 12){
            hour = hour%12;
        }
        if(this.getMin() > 9) {
            alarmTime = (hour + ":" + this.getMin() + " " + amOrPm);
        }
        else{
            alarmTime = hour + ":0" + this.getMin()+ " " + amOrPm;
        }

        return alarmTime;
    }
}
