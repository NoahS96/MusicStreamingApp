package com.example.slothlord.musicstreamingapp.MediaPlayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.slothlord.musicstreamingapp.R;

public class MediaPlayerActivity extends AppCompatActivity {

    ImageButton previous, sound, play, next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        previous = (ImageButton) findViewById(R.id.previous);
        sound = (ImageButton) findViewById(R.id.sound);
        play = (ImageButton) findViewById(R.id.play);
        next = (ImageButton) findViewById(R.id.next);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
