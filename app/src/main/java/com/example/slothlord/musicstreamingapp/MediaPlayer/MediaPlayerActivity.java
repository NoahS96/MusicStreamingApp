/*
 * Copyright 2017 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.slothlord.musicstreamingapp.MediaPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.slothlord.musicstreamingapp.AlarmJava.Alarm;
import com.example.slothlord.musicstreamingapp.R;

/**
 * Allows playback of a single MP3 file via the UI. It contains a {@link MediaPlayerHolder}
 * which implements the {@link PlayerAdapter} interface that the activity uses to control
 * audio playback.
 */
public final class MediaPlayerActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
   public static  int MEDIA_RES_ID;


    private PlayerAdapter mPlayerAdapter;
    private boolean mUserIsSeeking = false;


    /*protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == ALARMCODE && resultCode == RESULT_OK ){
            if (intent.hasExtra("hour") && intent.hasExtra("min") ){
                alarms.addAlarm(new Alarm(intent.getExtras().getInt("hour"),intent.getExtras().getInt("min"),
                        intent.getExtras().getInt("month"), intent.getExtras().getInt("day"), intent.getExtras().getInt("year"),
                        intent.getExtras().getString("title")));
                adapter.notifyDataSetChanged();
            }
        }
    }*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        initializeUI();

        initializePlaybackController();
        Log.d(TAG, "onCreate: finished");


        //Bundle extras = getIntent().getExtras();
        if(getIntent().hasExtra("pop")){
            MEDIA_RES_ID = R.raw.superawesomesong;
        }

        if(getIntent().hasExtra("rap")){
            MEDIA_RES_ID = R.raw.othersong;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        //This will hold the name of the station
        mPlayerAdapter.loadMedia(MEDIA_RES_ID);
        Log.d(TAG, "onStart: create MediaPlayer");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isChangingConfigurations() && mPlayerAdapter.isPlaying()) {
            Log.d(TAG, "onStop: don't release MediaPlayer as screen is rotating & playing");
        } else {
            mPlayerAdapter.release();
            Log.d(TAG, "onStop: release MediaPlayer");
        }
    }

    private void initializeUI() {

        ImageButton mPlayButton = (ImageButton) findViewById(R.id.play);
        ImageButton mPauseButton = (ImageButton) findViewById(R.id.previous);
        ImageButton mResetButton = (ImageButton) findViewById(R.id.next);


        mPauseButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPlayerAdapter.pause();
                    }
                });
        mPlayButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPlayerAdapter.play();
                    }
                });
        mResetButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPlayerAdapter.reset();
                    }
                });
    }

    private void initializePlaybackController() {
        MediaPlayerHolder mMediaPlayerHolder = new MediaPlayerHolder(this);
        Log.d(TAG, "initializePlaybackController: created MediaPlayerHolder");
        mMediaPlayerHolder.setPlaybackInfoListener(new PlaybackListener());
        mPlayerAdapter = mMediaPlayerHolder;
        Log.d(TAG, "initializePlaybackController: MediaPlayerHolder progress callback set");
    }





    public class PlaybackListener extends PlaybackInfoListener {


        @Override
        public void onStateChanged(@State int state) {
            String stateToString = PlaybackInfoListener.convertStateToString(state);
            onLogUpdated(String.format("onStateChanged(%s)", stateToString));
        }

        @Override
        public void onPlaybackCompleted() {
        }


    }
}