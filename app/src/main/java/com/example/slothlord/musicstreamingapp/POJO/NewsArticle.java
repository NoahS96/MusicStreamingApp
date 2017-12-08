package com.example.slothlord.musicstreamingapp.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Andrew Schaffer on 11/16/2017.
 */

public class NewsArticle {

    @SerializedName("article_text")
    public String description;

    @SerializedName("article_image")
    public String imagePath;
}
