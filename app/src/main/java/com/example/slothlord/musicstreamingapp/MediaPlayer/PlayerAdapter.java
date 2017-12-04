package com.example.slothlord.musicstreamingapp.MediaPlayer;

/**
 * Created by jperales on 11/30/17.
 */

public interface PlayerAdapter {

    void loadMedia(int resourceId);

    void release();

    boolean isPlaying();

    void play();

    void reset();

    void pause();

    
}
