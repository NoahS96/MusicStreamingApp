package com.example.slothlord.musicstreamingapp.NewsfeedJava;

import android.widget.ImageView;

import com.example.slothlord.musicstreamingapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis on 11/17/2017.
 */

public class NewsCard {
    private String title;
    private String description;
    private int background;

    NewsCard(String title, String description, int background) {
        this.title = title;
        this.description = description;
        this.background = background;
    }

    NewsCard() {
        this.title = "";
        this.description = "";
        this.background = 0;
    }

    public String getTitle() { return title; }

    public void setTitle() { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription() { this.description = description; }

    public int getBackground() { return background; }

    public void setBackground() { this.background = background; }

}
