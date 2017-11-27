package com.example.slothlord.musicstreamingapp.AlarmJava;

/**
 * Created by jperales on 11/12/17.
 * Alarm Object that has a date, time, and name
 */
public class Alarm {
    private int month, day, year;
    private int hour;
    private int min;
    private String amOrPm;
    private String alarmName;
    private String date = null;
    private String monthName;
    private String stationName;

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

    public Alarm(int hour, int min, int month, int day, int year, String alarmName){
        this.hour = hour;
        this.min = min;
        this.alarmName = alarmName;
        this.month = month;
        this.day = day;
        this.year = year;
        monthName = null;

        switch (month) {
            case 0:
                monthName = "Jan.";
                break;

            case 1:
                monthName = "Feb.";
                break;

            case 2:
                monthName = "Mar.";
                break;

            case 3:
                monthName = "Apr.";
                break;

            case 4:
                monthName = "May";
                break;

            case 5:
                monthName = "Jun.";
                break;

            case 6:
                monthName = "Jul.";
                break;

            case 7:
                monthName = "Aug.";
                break;

            case 8:
                monthName = "Sept.";

                break;

            case 9:
                monthName = "Oct.";
                break;

            case 10:
                monthName = "Nov.";
                break;

            case 11:
                monthName = "Dec";
                break;

        }

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

    public String getDate(){
        date = monthName + " " + day + ", " + year;
        return date;
    }
}
