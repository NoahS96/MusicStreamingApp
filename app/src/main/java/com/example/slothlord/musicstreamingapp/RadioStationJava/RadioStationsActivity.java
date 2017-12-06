package com.example.slothlord.musicstreamingapp.RadioStationJava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;
import android.view.View;

import com.example.slothlord.musicstreamingapp.MediaPlayer.MediaPlayerActivity;
import com.example.slothlord.musicstreamingapp.NewsfeedJava.NewsFeedActivity;
import com.example.slothlord.musicstreamingapp.R;

public class RadioStationsActivity extends AppCompatActivity {

    Button rap,pop,rock,alt,jazz,punk;

    String genre;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_stations);

        final Context context = this;

        rap = (Button) findViewById(R. id. rap_button);
        pop = (Button) findViewById(R. id. pop_button);
        rock = (Button) findViewById(R. id. rock_button);
        alt = (Button) findViewById(R. id. Alternative_button);
        jazz = (Button) findViewById(R. id. jazz_button);
        punk = (Button) findViewById(R. id. punk_button);

        rap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genre = "rap";

                intent = new Intent(context, MediaPlayerActivity.class);
                intent.putExtra("rap", genre);
                startActivity(intent);
            }
        });
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genre = "pop";

                intent = new Intent(context, MediaPlayerActivity.class);
                intent.putExtra("pop", genre);
                startActivity(intent);
            }
        });

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genre = "rock";

                intent = new Intent(context, MediaPlayerActivity.class);
                intent.putExtra("rock", genre);
                startActivity(intent);
            }
        });

        alt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genre = "alternative";

                intent = new Intent(context, MediaPlayerActivity.class);
                intent.putExtra("alt", genre);
                startActivity(intent);
            }
        });

        jazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genre = "jazz";

                intent = new Intent(context, MediaPlayerActivity.class);
                intent.putExtra("jazz", genre);
                startActivity(intent);
            }
        });

        punk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                genre = "punk";

                intent = new Intent(context, MediaPlayerActivity.class);
                intent.putExtra("punk", genre);
                startActivity(intent);
            }
        });


    }



}
