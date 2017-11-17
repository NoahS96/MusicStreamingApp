package com.example.slothlord.musicstreamingapp.AlarmJava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.slothlord.musicstreamingapp.R;

public class CreateAlarmActivity extends AppCompatActivity {

    private Button createAlarm;
    private TimePicker timePicker;
    private int hr, min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alarm);
        createAlarm = (Button) findViewById(R.id.createAlarm);
        timePicker = (TimePicker) findViewById(R.id.timepicker);
    }

    public void CreateAlarm(View view){
        hr = timePicker.getCurrentHour();
        min = timePicker.getCurrentMinute();

        Intent intent = new Intent();
        intent.putExtra("hour",hr);
        intent.putExtra("min",min);
        setResult(RESULT_OK, intent);

        finish();
    }

}
