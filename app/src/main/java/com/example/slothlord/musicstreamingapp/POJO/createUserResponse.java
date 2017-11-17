package com.example.slothlord.musicstreamingapp.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by slothlord on 11/17/17.
 */

public class createUserResponse {

    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("id")
    public String id;
}
