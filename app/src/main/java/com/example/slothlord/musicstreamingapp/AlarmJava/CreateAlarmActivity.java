

package com.example.slothlord.musicstreamingapp.AlarmJava;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.slothlord.musicstreamingapp.R;

import java.util.Calendar;

public class CreateAlarmActivity extends AppCompatActivity implements View.OnClickListener {

    Button createAlarm;
    EditText title;
    TextView time, dateText;
    String date;
    Intent intent;

    private int year, month, day, hour, minute;
    private String alarmTitle, monthName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);

        createAlarm = (Button) findViewById(R.id.createAlarmButton);
        dateText = (TextView) findViewById(R.id.et_alarmDate);
        time = (TextView) findViewById(R.id.et_alarmTime);
        title = (EditText) findViewById(R.id.et_alarmTitle);
        //Sets Current time
        final Calendar cal = Calendar.getInstance();
        String amPm = null;
        hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour < 12){
            amPm = "AM";
        }
        else{
            amPm = "PM";
        }
        minute = cal.get(Calendar.MINUTE);
        hour %= 12;
        if (hour == 0){
            hour = 12;
        }
        if(minute < 10) {
            time.setText(hour + ":0" + minute + " " + amPm);
        }
        else{
            time.setText(hour + ":" + minute + " " + amPm);
        }
        //Sets Current Date
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        date = dateMaker(month, day, year);
        dateText.setText(date);

        dateText.setOnClickListener(this);
        time.setOnClickListener(this);
        title.setOnClickListener(this);
        createAlarm.setOnClickListener(this);
        intent = new Intent();
    }

    @Override
    public void onClick(View view) {
        if (view == time) {

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int min) {
                    int displayHr = hour % 12;
                    String amPm = null;
                    if (hour < 12){
                        amPm = "AM";
                    }
                    else{
                        amPm = "PM";
                    }
                    if(displayHr == 0){
                        displayHr =12;
                    }
                    if(min >= 10) {
                        time.setText(displayHr + ":" + min + " " + amPm);
                    }
                    else{
                        time.setText(displayHr + ":0" + min + " " + amPm);
                    }
                }

            }, hour, minute, false);
            timePickerDialog.show();
            intent.putExtra("hour", hour);
            intent.putExtra("min", minute);
        }

        if (view == dateText) {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    dateText.setText(dateMaker(month,day,year));
                }
            },year,month,day);
            datePickerDialog.show();
            intent.putExtra("month", month);
            intent.putExtra("day", day);
            intent.putExtra("year",year);
        }



        if (view == createAlarm){

            intent.putExtra("title", title.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }

    }


    public static String dateMaker(int month, int day, int year) {
        String monthName = null;

        switch (month) {
            case 0:
                monthName = "January";
                break;

            case 1:
                monthName = "February";
                break;

            case 2:
                monthName = "March";
                break;

            case 3:
                monthName = "April";
                break;

            case 4:
                monthName = "May";
                break;

            case 5:
                monthName = "June";
                break;

            case 6:
                monthName = "July";
                break;

            case 7:
                monthName = "August";
                break;

            case 8:
                monthName = "September";

                break;

            case 9:
                monthName = "October";
                break;

            case 10:
                monthName = "November";
                break;

            case 11:
                monthName = "December";
                break;

        }
        String date = monthName + " " + day + ", " + year;
        return  date;
    }

}








